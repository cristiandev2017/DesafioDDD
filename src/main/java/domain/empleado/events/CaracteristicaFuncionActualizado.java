package domain.empleado.events;

import co.com.sofka.domain.generic.DomainEvent;
import domain.empleado.values.Caracteristica;
import domain.empleado.values.FuncionId;

public class CaracteristicaFuncionActualizado extends DomainEvent {
    private final FuncionId entityId;
    private final Caracteristica caracteristica;

    public CaracteristicaFuncionActualizado(FuncionId entityId,Caracteristica caracteristica){
        super("sofka.domain.empleado.caracteristicafuncionactualizada");
        this.entityId = entityId;
        this.caracteristica = caracteristica;
    }

    public FuncionId getFuncionId() {
        return entityId;
    }

    public Caracteristica getCaracteristica() {
        return caracteristica;
    }
}
