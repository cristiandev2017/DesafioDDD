package factura;

import co.com.sofka.domain.generic.Entity;
import empleado.values.Nombre;
import factura.values.Existencia;
import factura.values.ProductoId;

public class Producto extends Entity<ProductoId> {
    private Nombre nombre;
    private Existencia existencia;

    public Producto(ProductoId entityId, Nombre nombre, Existencia existencia){
        super(entityId);
        this.nombre = nombre;
        this.existencia = existencia;
    }

    public Nombre getNombre() {
        return nombre;
    }

    public Existencia getExistencia() {
        return existencia;
    }
}
