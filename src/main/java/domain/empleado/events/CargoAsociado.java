package domain.empleado.events;

import co.com.sofka.domain.generic.DomainEvent;
import domain.empleado.Cargo;
import domain.empleado.values.EmpleadoId;

public class CargoAsociado extends DomainEvent {
    private final Cargo cargo;
    public CargoAsociado(Cargo cargo){
        super("sofka.empleado.cargoasociado");
        this.cargo = cargo;
    }

    public Cargo getCargo() {
        return cargo;
    }

}
