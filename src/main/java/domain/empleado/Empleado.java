package domain.empleado;

import co.com.sofka.domain.generic.AggregateEvent;
import co.com.sofka.domain.generic.DomainEvent;
import domain.empleado.events.*;
import domain.empleado.values.*;

import java.util.List;
import java.util.Objects;
import java.util.Optional;
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
    protected CargoId cargoId;

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

    //Ahora se pondran los eventos
    public void actualizarCaracteristicaDeFuncion(FuncionId entityId,Caracteristica caracteristica){
        appendChange(new CaracteristicaFuncionActualizado(entityId,caracteristica));
    }

    public void actualizarDescripcionDeFuncion(FuncionId entityId, Descripcion descripcion){
        appendChange(new DescripcionFuncionActualizada(entityId,descripcion));
    }

    public void actualizarNombre(Nombre nombre){
        appendChange(new NombreActualizado(nombre)).apply();
    }

    public void actualizarDireccion(Direccion direccion){
        appendChange(new DireccionActualizada(direccion)).apply();
    }

    public void actualizarEdad(Edad edad){
        appendChange(new EdadActualizada(edad)).apply();
    }

    public void actualizarTelefono(Telefono telefono){
        appendChange(new TelefonoActualizado(telefono)).apply();
    }

    public void agregarFuncion(FuncionId entityId, Caracteristica caracteristica, Descripcion descripcion){
        Objects.requireNonNull(entityId);
        Objects.requireNonNull(caracteristica);
        Objects.requireNonNull(descripcion);
        appendChange(new FuncionAgregada(entityId,caracteristica,descripcion)).apply();
    }

    public void asociarCargo(Cargo cargo){
        appendChange(new CargoAsociado(cargo)).apply();
    }

    public void crearCargo(CargoId cargoId, Nombre nombre, TipoCargo tipoCargo){appendChange(new CargoCreado(cargoId,nombre,tipoCargo)).apply(); }

    public void asociarCuenta( Cuenta cuenta){
        appendChange(new CuentaAsociada(cuenta)).apply();
    }



    protected Optional<Funcion> getFuncionPorId(FuncionId entityId){
        return funciones()
                .stream()
                .filter(funcion-> funcion.identity().equals(entityId))
                .findFirst();
    }

    public Set<Funcion> funciones(){
        return funciones;
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

    public Set<Funcion> getFunciones() {
        return funciones;
    }

    public Cuenta getCuenta() {
        return cuenta;
    }

    public Cargo getCargo() {
        return cargo;
    }
}
