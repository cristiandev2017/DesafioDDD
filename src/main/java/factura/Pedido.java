package factura;

import co.com.sofka.domain.generic.Entity;
import factura.values.Detalle;
import factura.values.PedidoId;

public class Pedido extends Entity<PedidoId> {
    private Detalle detalle;

    public Pedido(PedidoId entityId,Detalle detalle){
        super(entityId);
        this.detalle = detalle;
    }

    public Detalle detalle() {
        return detalle;
    }
}
