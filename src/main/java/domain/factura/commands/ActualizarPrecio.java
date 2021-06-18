package domain.factura.commands;

import co.com.sofka.domain.generic.Command;
import domain.empleado.values.Descripcion;
import domain.factura.values.FacturaId;
import domain.factura.values.Precio;


public class ActualizarPrecio implements Command {

    private final FacturaId facturaId;
    private final Precio precio;

    public ActualizarPrecio(FacturaId facturaId, Precio precio){
        this.facturaId = facturaId;
        this.precio = precio;
    }

    public FacturaId getFacturaId() {
        return facturaId;
    }

    public Precio getPrecio() {
        return precio;
    }
}
