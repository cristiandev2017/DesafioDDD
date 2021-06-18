package factura.events;

import co.com.sofka.domain.generic.DomainEvent;
import factura.values.Fecha;

public class FechaActualizada extends DomainEvent {
    private final Fecha fecha;
    public FechaActualizada(Fecha fecha){
        super("sofka.factura.fechaactualizado");
        this.fecha = fecha;
    }

    public Fecha getFecha() {
        return fecha;
    }
}
