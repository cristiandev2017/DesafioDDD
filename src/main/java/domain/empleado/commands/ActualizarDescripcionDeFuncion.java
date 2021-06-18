package empleado.commands;

import co.com.sofka.domain.generic.Command;
import empleado.values.Precio;
import empleado.values.EmpleadoId;
import empleado.values.FuncionId;

public class ActualizarDescripcionDeFuncion implements Command {
    private final EmpleadoId empleadoId;
    private final FuncionId entityId;
    private final Precio descripcion;

    public ActualizarDescripcionDeFuncion(EmpleadoId empleadoId, FuncionId entityId, Precio descripcion){
        this.empleadoId = empleadoId;
        this.entityId = entityId;
        this.descripcion = descripcion;
    }

    public EmpleadoId getEmpleadoId() {
        return empleadoId;
    }

    public FuncionId getEntityId() {
        return entityId;
    }

    public Precio getDescripcion() {
        return descripcion;
    }
}
