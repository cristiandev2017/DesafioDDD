package domain.empleado.commands;

import co.com.sofka.domain.generic.Command;
import domain.empleado.values.Caracteristica;
import domain.empleado.values.Descripcion;
import domain.empleado.values.EmpleadoId;
import domain.empleado.values.FuncionId;

public class AgregarFuncion implements Command {

    private final EmpleadoId empleadoId;
    private final FuncionId entityId;
    private final Caracteristica caracteristica;
    private final Descripcion descripcion;

    public AgregarFuncion(EmpleadoId empleadoId, FuncionId entityId, Caracteristica caracteristica, Descripcion descripcion){
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

    public Descripcion getDescripcion() {
        return descripcion;
    }
}
