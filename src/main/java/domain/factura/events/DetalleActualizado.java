package domain.factura.events;

import co.com.sofka.domain.generic.DomainEvent;
import domain.factura.values.Detalle;
import domain.factura.values.PedidoId;

public class DetalleActualizado extends DomainEvent {
    private final PedidoId pedidoId;
    private final Detalle detalle;

    public DetalleActualizado(PedidoId pedidoId, Detalle detalle){
        super("sofka.domain.factura.detalleactualizado");
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
