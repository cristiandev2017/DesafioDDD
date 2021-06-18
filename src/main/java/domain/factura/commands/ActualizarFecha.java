package factura.commands;

import co.com.sofka.domain.generic.Command;
import empleado.values.Precio;
import factura.values.FacturaId;


public class ActualizarFecha implements Command {

    private final FacturaId facturaId;
    private final Precio fecha;

    public ActualizarFecha(FacturaId facturaId, Precio descripcion){
        this.facturaId = facturaId;
        this.fecha = descripcion;
    }

    public FacturaId getFacturaId() {
        return facturaId;
    }

    public Precio getFecha() {
        return fecha;
    }
}
