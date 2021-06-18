package empleado.commands;

import co.com.sofka.domain.generic.Command;
import empleado.values.Descripcion;
import empleado.values.EmpleadoId;
import empleado.values.FuncionId;

public class ActualizarDescripcionDeFuncion implements Command {
    private final EmpleadoId empleadoId;
    private final FuncionId entityId;
    private final Descripcion descripcion;

    public ActualizarDescripcionDeFuncion(EmpleadoId empleadoId, FuncionId entityId, Descripcion descripcion){
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

    public Descripcion getDescripcion() {
        return descripcion;
    }
}
