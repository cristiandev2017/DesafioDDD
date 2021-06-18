package empleado.commands;

import co.com.sofka.domain.generic.Command;
import empleado.values.Direccion;
import empleado.values.EmpleadoId;
import empleado.values.Telefono;

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
