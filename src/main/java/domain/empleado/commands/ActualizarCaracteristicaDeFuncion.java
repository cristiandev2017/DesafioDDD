package domain.empleado.commands;

import co.com.sofka.domain.generic.Command;
import domain.empleado.values.Caracteristica;
import domain.empleado.values.EmpleadoId;
import domain.empleado.values.FuncionId;

public class ActualizarCaracteristicaDeFuncion implements Command {
    private final EmpleadoId empleadoId;
    private final FuncionId entityId;
    private final Caracteristica caracteristica;

    public ActualizarCaracteristicaDeFuncion(EmpleadoId empleadoId, FuncionId entityId, Caracteristica caracteristica){
        this.empleadoId = empleadoId;
        this.entityId = entityId;
        this.caracteristica = caracteristica;
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
}
