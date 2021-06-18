package domain.empleado.commands;

import co.com.sofka.domain.generic.Command;
import domain.empleado.values.Direccion;
import domain.empleado.values.EmpleadoId;

public class ActualizarDireccion implements Command {

    private final EmpleadoId empleadoId;
    private final Direccion direccion;

    public ActualizarDireccion(EmpleadoId empleadoId, Direccion direccion){
        this.empleadoId = empleadoId;
        this.direccion = direccion;
    }

    public EmpleadoId getEmpleadoId() {
        return empleadoId;
    }

    public Direccion getDireccion() {
        return direccion;
    }
}
