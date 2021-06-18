package domain.factura.events;

import co.com.sofka.domain.generic.DomainEvent;
import domain.factura.values.Precio;

public class PrecioActualizado extends DomainEvent {
    private final Precio precio;
    public PrecioActualizado(Precio precio){
        super("sofka.domain.factura.precioactualizado");
        this.precio = precio;
    }

    public Precio getPrecio() {
        return precio;
    }
}
