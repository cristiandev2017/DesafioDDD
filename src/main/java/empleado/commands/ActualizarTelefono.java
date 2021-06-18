package empleado.commands;

import co.com.sofka.domain.generic.Command;
import empleado.values.EmpleadoId;
import empleado.values.Telefono;

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
