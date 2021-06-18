package domain.factura.events;

import co.com.sofka.domain.generic.DomainEvent;
import domain.empleado.values.Descripcion;

public class DescripcionActualizada extends DomainEvent {
    private final Descripcion descripcion;
    public DescripcionActualizada(Descripcion descripcion){
        super("sofka.domain.factura.descripcionactualizada");
        this.descripcion = descripcion;
    }

    public Descripcion getDescripcion() {
        return descripcion;
    }
}
