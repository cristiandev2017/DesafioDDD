package factura.events;

import co.com.sofka.domain.generic.DomainEvent;
import empleado.values.Descripcion;
import factura.values.Fecha;
import factura.values.Precio;

public class FacturaCreada extends DomainEvent {
    private final Descripcion descripcion;
    private final Fecha fecha;
    private final Precio precio;

    public FacturaCreada(Descripcion descripcion, Fecha fecha, Precio precio){
        super("sofka.factura.facturacreada");
        this.descripcion = descripcion;
        this.fecha = fecha;
        this.precio = precio;
    }

    public Descripcion getDescripcion() {
        return descripcion;
    }

    public Fecha getFecha() {
        return fecha;
    }

    public Precio getPrecio() {
        return precio;
    }
}
