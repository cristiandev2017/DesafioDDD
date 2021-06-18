package domain.factura.events;

import co.com.sofka.domain.generic.DomainEvent;
import domain.factura.values.Fecha;

public class FechaActualizada extends DomainEvent {
    private final Fecha fecha;
    public FechaActualizada(Fecha fecha){
        super("sofka.domain.factura.fechactualizado");
        this.fecha = fecha;
    }

    public Fecha getFecha() {
        return fecha;
    }
}
