package domain.empleado.events;

import co.com.sofka.domain.generic.DomainEvent;
import domain.empleado.values.CargoId;
import domain.empleado.values.Nombre;
import domain.empleado.values.TipoCargo;

public class CargoCreado extends DomainEvent {
    private final CargoId cargoId;
    private final Nombre nombre;
    private final TipoCargo tipoCargo;

    public CargoCreado(CargoId cargoId, Nombre nombre, TipoCargo tipoCargo){
        super("sofka.domain.empleado.cargocreado");
        this.cargoId = cargoId;
        this.nombre = nombre;
        this.tipoCargo = tipoCargo;
    }

    public CargoId getCargoId() {
        return cargoId;
    }

    public Nombre getNombre() {
        return nombre;
    }

    public TipoCargo getTipoCargo() {
        return tipoCargo;
    }
}
