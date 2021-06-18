package empleado.events;

import co.com.sofka.domain.generic.DomainEvent;
import empleado.Cargo;
import empleado.values.CargoId;

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
