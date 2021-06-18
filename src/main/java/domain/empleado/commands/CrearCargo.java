package empleado.commands;


import co.com.sofka.domain.generic.Command;
import empleado.values.CargoId;
import empleado.values.EmpleadoId;
import empleado.values.Nombre;
import empleado.values.TipoCargo;

public class CrearCargo implements Command {
    private final EmpleadoId empleadoId;
    private final CargoId entityId;
    private final Nombre nombre;
    private final TipoCargo tipoCargo;

    public CrearCargo(EmpleadoId empleadoId, CargoId entityId, Nombre nombre, TipoCargo tipoCargo){
        this.empleadoId = empleadoId;
        this.entityId = entityId;
        this.nombre = nombre;
        this.tipoCargo = tipoCargo;
    }

    public EmpleadoId getEmpleadoId() {
        return empleadoId;
    }

    public CargoId getEntityId() {
        return entityId;
    }

    public Nombre getNombre() {
        return nombre;
    }

    public TipoCargo getTipoCargo() {
        return tipoCargo;
    }
}
