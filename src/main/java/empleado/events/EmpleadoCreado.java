package empleado.events;

import co.com.sofka.domain.generic.DomainEvent;
import empleado.values.*;

public class EmpleadoCreado extends DomainEvent {
    private final Nombre nombre;
    private final Edad edad;
    private final Telefono telefono;
    private final Direccion direccion;
    //Relacionados
    private final CuentaId cuentaId;
    private final CargoId cargoId;

    public EmpleadoCreado(Nombre nombre, Edad edad, Telefono telefono, Direccion direccion, CuentaId cuentaId, CargoId cargoId){
        super("sofka.empleado.empleadocreado");
        this.nombre = nombre;
        this.edad = edad;
        this.telefono = telefono;
        this.direccion = direccion;
        this.cuentaId = cuentaId;
        this.cargoId = cargoId;
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

    public CuentaId getCuentaId() {
        return cuentaId;
    }

    public CargoId getCargoId() {
        return cargoId;
    }
}
