package factura.commands;

import co.com.sofka.domain.generic.Command;
import empleado.values.Precio;
import factura.values.FacturaId;


public class ActualizarDescripcion implements Command {

    private final FacturaId facturaId;
    private final Precio descripcion;

    public ActualizarDescripcion(FacturaId facturaId, Precio descripcion){
        this.facturaId = facturaId;
        this.descripcion = descripcion;
    }

    public FacturaId getFacturaId() {
        return facturaId;
    }

    public Precio getDescripcion() {
        return descripcion;
    }
}
