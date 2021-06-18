package domain.empleado.commands;

import co.com.sofka.domain.generic.Command;
import domain.empleado.values.EmpleadoId;
import domain.empleado.values.Telefono;

public class ActualizarTelefono implements Command {

    private final EmpleadoId empleadoId;
    private final Telefono telefono;

    public ActualizarTelefono(EmpleadoId empleadoId, Telefono telefono){
        this.empleadoId = empleadoId;
        this.telefono = telefono;
    }

    public EmpleadoId getEmpleadoId() {
        return empleadoId;
    }

    public Telefono getTelefono() {
        return telefono;
    }
}
