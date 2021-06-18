package factura.events;

import co.com.sofka.domain.generic.DomainEvent;
import factura.values.Detalle;
import factura.values.PedidoId;

public class PedidoCreado extends DomainEvent{
    private final PedidoId pedidoId;
    private final Detalle detalle;

    public PedidoCreado(PedidoId pedidoId, Detalle detalle){
        super("sofka.factura.pedidocreado");
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
