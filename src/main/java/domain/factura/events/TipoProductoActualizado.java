package factura.events;

import co.com.sofka.domain.generic.DomainEvent;
import factura.values.FacturaId;
import factura.values.TipoProducto;

public class TipoProductoActualizado extends DomainEvent {
    private final FacturaId facturaId;
    private final TipoProducto tipoProducto;

    public TipoProductoActualizado(FacturaId facturaId, TipoProducto tipoProducto){
        super("sofka.factura.tipoproductoactualizado");
        this.facturaId = facturaId;
        this.tipoProducto = tipoProducto;
    }

    public FacturaId getFacturaId() {
        return facturaId;
    }

    public TipoProducto getTipoProducto() {
        return tipoProducto;
    }
}
