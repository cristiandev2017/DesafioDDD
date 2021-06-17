package empleado.events;

import co.com.sofka.domain.generic.DomainEvent;
import empleado.values.CargoId;
import empleado.values.TipoCargo;

public class TipoCargoActualizado extends DomainEvent {
    private final CargoId cargoId;
    private final TipoCargo tipoCargo;

    public TipoCargoActualizado(CargoId cargoId,TipoCargo tipoCargo){
        super("sofka.empleado.tipocargoactualizado");
        this.cargoId = cargoId;
        this.tipoCargo = tipoCargo;
    }

    public CargoId getCargoId() {
        return cargoId;
    }

    public TipoCargo getTipoCargo() {
        return tipoCargo;
    }
}
