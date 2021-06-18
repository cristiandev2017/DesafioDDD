package domain.factura.events;

import co.com.sofka.domain.generic.DomainEvent;
import domain.empleado.values.Nombre;
import domain.factura.values.Existencia;
import domain.factura.values.ProductoId;

public class ProductoAgregado extends DomainEvent {
    private final ProductoId productoId;
    private final Nombre nombre;
    private final Existencia existencia;

    public ProductoAgregado(ProductoId productoId, Nombre nombre, Existencia existencia){
        super("sofka.domain.factura.productoagregado");
        this.productoId = productoId;
        this.nombre = nombre;
        this.existencia = existencia;
    }

    public ProductoId getProductoId() {
        return productoId;
    }

    public Nombre getNombre() {
        return nombre;
    }

    public Existencia getExistencia() {
        return existencia;
    }
}
