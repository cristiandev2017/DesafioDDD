package domain.empleado;

import co.com.sofka.domain.generic.Entity;
import domain.empleado.values.CargoId;
import domain.empleado.values.Nombre;
import domain.empleado.values.TipoCargo;

public class Cargo extends Entity<CargoId> {
    private Nombre nombre;
    private TipoCargo tipoCargo;

    public Cargo(CargoId entityId, Nombre nombre, TipoCargo tipoCargo){
        super(entityId);
        this.nombre = nombre;
        this.tipoCargo = tipoCargo;
    }

    public Nombre nombre() {
        return nombre;
    }

    public TipoCargo tipoCargo() {
        return tipoCargo;
    }
}
