package empleado;

import co.com.sofka.domain.generic.AggregateEvent;
import co.com.sofka.domain.generic.DomainEvent;
import empleado.events.EmpleadoCreado;
import empleado.values.*;

import java.util.List;
import java.util.Set;

public class Empleado extends AggregateEvent<EmpleadoId> {
    //Se definiran los valores del agregado
    protected Nombre nombre;
    protected Edad edad;
    protected Telefono telefono;
    protected Direccion direccion;
    //Los relacionados
    protected Set<Funcion> funciones;
    protected Cuenta cuenta;
    protected Cargo cargo;

    public Empleado(EmpleadoId entityId,Nombre nombre, Edad edad, Telefono telefono, Direccion direccion, Cuenta cuenta, Cargo cargo) {
        super(entityId);
        appendChange(new EmpleadoCreado(nombre,edad,telefono,direccion,cuenta,cargo)).apply();
    }

    //Factoria
    public static Empleado from(EmpleadoId empleadoId, List<DomainEvent> events){
        var empleado = new Empleado(empleadoId);
        events.forEach(empleado::applyEvent);
        return empleado;
    }

    //Constructor privado para afectar los estados
    private Empleado(EmpleadoId entityId){
        super(entityId);
        subscribe(new EmpleadoChange(this));
    }

}
