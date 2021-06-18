package empleado.commands;

import co.com.sofka.domain.generic.Command;
import empleado.values.EmpleadoId;
import empleado.values.Nombre;

public class ActualizarNombre implements Command {

    private final EmpleadoId empleadoId;
    private final Nombre nombre;

    public ActualizarNombre(EmpleadoId empleadoId, Nombre nombre){
        this.empleadoId = empleadoId;
        this.nombre = nombre;
    }

    public EmpleadoId getEmpleadoId() {
        return empleadoId;
    }

    public Nombre getNombre() {
        return nombre;
    }
}
