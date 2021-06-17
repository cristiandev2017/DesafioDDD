package empleado.events;

import co.com.sofka.domain.generic.DomainEvent;
import empleado.values.Caracteristica;
import empleado.values.FuncionId;

public class CaracteristicaFuncionActualizado extends DomainEvent {
    private final FuncionId entityId;
    private final Caracteristica caracteristica;

    public CaracteristicaFuncionActualizado(FuncionId entityId,Caracteristica caracteristica){
        super("sofka.empleado.caracteristicafuncionactualizada");
        this.entityId = entityId;
        this.caracteristica = caracteristica;
    }

    public FuncionId getEntityId() {
        return entityId;
    }

    public Caracteristica getCaracteristica() {
        return caracteristica;
    }
}
