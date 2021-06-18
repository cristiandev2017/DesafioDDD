package domain.factura.events;

import co.com.sofka.domain.generic.DomainEvent;
import domain.factura.values.FacturaId;
import domain.factura.values.TipoProducto;

public class TipoProductoActualizado extends DomainEvent {
    private final FacturaId facturaId;
    private final TipoProducto tipoProducto;

    public TipoProductoActualizado(FacturaId facturaId, TipoProducto tipoProducto){
        super("sofka.domain.factura.tipoproductoactualizado");
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
