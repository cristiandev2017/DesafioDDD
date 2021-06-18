package factura.events;

import co.com.sofka.domain.generic.DomainEvent;
import factura.values.Precio;

public class PrecioActualizado extends DomainEvent {
    private final Precio precio;
    public PrecioActualizado(Precio precio){
        super("sofka.factura.precioactualizado");
        this.precio = precio;
    }

    public Precio getPrecio() {
        return precio;
    }
}
