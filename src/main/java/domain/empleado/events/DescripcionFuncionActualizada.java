package domain.empleado.events;

import co.com.sofka.domain.generic.DomainEvent;
import domain.empleado.values.Descripcion;
import domain.empleado.values.FuncionId;

public class DescripcionFuncionActualizada extends DomainEvent {
    private final FuncionId entityId;
    private final Descripcion descripcion;

    public DescripcionFuncionActualizada(FuncionId entityId, Descripcion descripcion){
        super("sofka.domain.empleado.descripcionfuncionactualizada");
        this.entityId = entityId;
        this.descripcion = descripcion;
    }

    public FuncionId getFuncionId() {
        return entityId;
    }

    public Descripcion getDescripcion() {
        return descripcion;
    }
}
