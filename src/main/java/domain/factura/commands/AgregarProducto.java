package factura.commands;

import co.com.sofka.domain.generic.Command;
import empleado.values.Nombre;
import factura.values.Existencia;
import factura.values.FacturaId;
import factura.values.ProductoId;

public class AgregarProducto implements Command {
    private final FacturaId facturaId;
    private final ProductoId productoId;
    private final Nombre nombre;
    private final Existencia existencia;

    public AgregarProducto(FacturaId facturaId,ProductoId productoId,Nombre nombre, Existencia existencia){
        this.facturaId = facturaId;
        this.productoId = productoId;
        this.nombre = nombre;
        this.existencia = existencia;
    }

    public FacturaId getFacturaId() {
        return facturaId;
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
