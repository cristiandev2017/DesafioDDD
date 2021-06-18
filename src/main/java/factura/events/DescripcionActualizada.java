package factura.events;

import co.com.sofka.domain.generic.DomainEvent;
import empleado.values.Precio;

public class DescripcionActualizada extends DomainEvent {
    private final Precio descripcion;
    public DescripcionActualizada(Precio descripcion){
        super("sofka.factura.descripcionactualizada");
        this.descripcion = descripcion;
    }

    public Precio getDescripcion() {
        return descripcion;
    }
}
