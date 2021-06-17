package empleado.events;

import co.com.sofka.domain.generic.DomainEvent;
import empleado.values.Direccion;
import empleado.values.Edad;
import empleado.values.Nombre;
import empleado.values.Telefono;

public class EmpleadoCreado extends DomainEvent {
    private final Nombre nombre;
    private final Edad edad;
    private final Telefono telefono;
    private final Direccion direccion;

    public EmpleadoCreado(Nombre nombre, Edad edad, Telefono telefono, Direccion direccion){
        super("sofka.empleado.empleadocreado");
        this.nombre = nombre;
        this.edad = edad;
        this.telefono = telefono;
        this.direccion = direccion;
    }

    public Nombre getNombre() {
        return nombre;
    }

    public Edad getEdad() {
        return edad;
    }

    public Telefono getTelefono() {
        return telefono;
    }

    public Direccion getDireccion() {
        return direccion;
    }
}
