package empleado.events;

import co.com.sofka.domain.generic.DomainEvent;
import empleado.values.Precio;
import empleado.values.FuncionId;

public class DescripcionFuncionActualizada extends DomainEvent {
    private final FuncionId entityId;
    private final Precio descripcion;

    public DescripcionFuncionActualizada(FuncionId entityId, Precio descripcion){
        super("sofka.empleado.descripcionfuncionactualizada");
        this.entityId = entityId;
        this.descripcion = descripcion;
    }

    public FuncionId getFuncionId() {
        return entityId;
    }

    public Precio getDescripcion() {
        return descripcion;
    }
}
