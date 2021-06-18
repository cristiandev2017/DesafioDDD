package domain.factura;

import co.com.sofka.domain.generic.Entity;
import domain.empleado.values.Nombre;
import domain.factura.values.Existencia;
import domain.factura.values.ProductoId;

public class Producto extends Entity<ProductoId> {
    private Nombre nombre;
    private Existencia existencia;

    public Producto(ProductoId entityId, Nombre nombre, Existencia existencia){
        super(entityId);
        this.nombre = nombre;
        this.existencia = existencia;
    }

    public Nombre nombre() {
        return nombre;
    }

    public Existencia existencia() {
        return existencia;
    }
}
