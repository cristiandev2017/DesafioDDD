package factura.events;

import co.com.sofka.domain.generic.DomainEvent;
import factura.values.Detalle;
import factura.values.PedidoId;

public class DetalleActualizado extends DomainEvent {
    private final PedidoId pedidoId;
    private final Detalle detalle;

    public DetalleActualizado(PedidoId pedidoId, Detalle detalle){
        super("sofka.factura.detalleactualizado");
        this.pedidoId = pedidoId;
        this.detalle = detalle;
    }

    public PedidoId getPedidoId() {
        return pedidoId;
    }

    public Detalle getDetalle() {
        return detalle;
    }
}
