package empleado.commands;

import co.com.sofka.domain.generic.Command;
import empleado.Cargo;
import empleado.Cuenta;
import empleado.values.*;

public class CrearEmpleado implements Command {
    private final EmpleadoId entityId;
    private final Nombre nombre;
    private final Edad edad;
    private final Telefono telefono;
    private final Direccion direccion;
    private final Cargo cargo;
    private final Cuenta cuenta;

    public CrearEmpleado(EmpleadoId entityId, Nombre nombre, Edad edad, Telefono telefono, Direccion direccion, Cuenta cuenta, Cargo cargo){
        this.entityId =entityId;
        this.nombre = nombre;
        this.edad = edad;
        this.telefono = telefono;
        this.direccion = direccion;
        this.cuenta = cuenta;
        this.cargo = cargo;
    }

    public EmpleadoId getEntityId() {
        return entityId;
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

    public Cargo getCargo() {
        return cargo;
    }

    public Cuenta getCuenta() {
        return cuenta;
    }
}
