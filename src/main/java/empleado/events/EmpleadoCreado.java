package empleado.events;

import co.com.sofka.domain.generic.DomainEvent;
import empleado.Cargo;
import empleado.Cuenta;
import empleado.values.*;

public class EmpleadoCreado extends DomainEvent {
    private final Nombre nombre;
    private final Edad edad;
    private final Telefono telefono;
    private final Direccion direccion;
    //Relacionados
    private final Cuenta cuenta;
    private final Cargo cargo;

    public EmpleadoCreado(Nombre nombre, Edad edad, Telefono telefono, Direccion direccion, Cuenta cuenta, Cargo cargo){
        super("sofka.empleado.empleadocreado");
        this.nombre = nombre;
        this.edad = edad;
        this.telefono = telefono;
        this.direccion = direccion;
        this.cuenta = cuenta;
        this.cargo = cargo;
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

    public Cuenta getCuenta() {
        return cuenta;
    }

    public Cargo getCargo() {
        return cargo;
    }
}
