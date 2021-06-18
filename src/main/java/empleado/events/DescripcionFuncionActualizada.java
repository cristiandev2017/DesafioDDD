package empleado.events;

import co.com.sofka.domain.generic.DomainEvent;
import empleado.values.Descripcion;
import empleado.values.FuncionId;

public class DescripcionFuncionActualizada extends DomainEvent {
    private final FuncionId entityId;
    private final Descripcion descripcion;

    public DescripcionFuncionActualizada(FuncionId entityId, Descripcion descripcion){
        super("sofka.empleado.descripcionfuncionactualizada");
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
