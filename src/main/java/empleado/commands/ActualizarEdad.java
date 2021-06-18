package empleado.commands;

import co.com.sofka.domain.generic.Command;
import empleado.values.Edad;
import empleado.values.EmpleadoId;

public class ActualizarEdad implements Command {

    private final EmpleadoId empleadoId;
    private final Edad edad;

    public ActualizarEdad(EmpleadoId empleadoId, Edad edad){
        this.empleadoId = empleadoId;
        this.edad = edad;
    }

    public EmpleadoId getEmpleadoId() {
        return empleadoId;
    }

    public Edad getEdad() {
        return edad;
    }
}
