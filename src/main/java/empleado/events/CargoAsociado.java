package empleado.events;

import co.com.sofka.domain.generic.DomainEvent;
import empleado.values.CargoId;

public class CargoAsociado extends DomainEvent {
    private final CargoId cargoId;
    public CargoAsociado(CargoId cargoId){
        super("sofka.empleado.cargoasociado");
        this.cargoId = cargoId;
    }

    public CargoId getCargoId() {
        return cargoId;
    }
}
