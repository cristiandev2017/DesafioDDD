package domain.empleado.commands;

import co.com.sofka.domain.generic.Command;
import domain.empleado.values.Edad;
import domain.empleado.values.EmpleadoId;

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
