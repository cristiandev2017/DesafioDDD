package factura.commands;

import co.com.sofka.domain.generic.Command;
import empleado.values.Precio;
import factura.values.FacturaId;


public class ActualizarPrecio implements Command {

    private final FacturaId facturaId;
    private final Precio precio;

    public ActualizarPrecio(FacturaId facturaId, Precio descripcion){
        this.facturaId = facturaId;
        this.precio = descripcion;
    }

    public FacturaId getFacturaId() {
        return facturaId;
    }

    public Precio getPrecio() {
        return precio;
    }
}
