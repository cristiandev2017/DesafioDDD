package empleado.commands;

import co.com.sofka.domain.generic.Command;
import empleado.Cargo;
import empleado.values.EmpleadoId;

public class AsociarCargo implements Command {

    private final EmpleadoId empleadoId;
    private final Cargo cargo;

    public AsociarCargo(EmpleadoId empleadoId, Cargo cargo){
        this.empleadoId = empleadoId;
        this.cargo = cargo;
    }

    public EmpleadoId getEmpleadoId() {
        return empleadoId;
    }

    public Cargo getCargo() {
        return cargo;
    }
}
