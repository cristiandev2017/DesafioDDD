package empleado.commands;

import co.com.sofka.domain.generic.Command;
import empleado.values.Caracteristica;
import empleado.values.Precio;
import empleado.values.EmpleadoId;
import empleado.values.FuncionId;

public class AgregarFuncion implements Command {

    private final EmpleadoId empleadoId;
    private final FuncionId entityId;
    private final Caracteristica caracteristica;
    private final Precio descripcion;

    public AgregarFuncion(EmpleadoId empleadoId, FuncionId entityId, Caracteristica caracteristica, Precio descripcion){
        this.empleadoId = empleadoId;
        this.entityId = entityId;
        this.caracteristica = caracteristica;
        this.descripcion = descripcion;
    }

    public EmpleadoId getEmpleadoId() {
        return empleadoId;
    }

    public FuncionId getEntityId() {
        return entityId;
    }

    public Caracteristica getCaracteristica() {
        return caracteristica;
    }

    public Precio getDescripcion() {
        return descripcion;
    }
}
