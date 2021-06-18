package domain.factura.commands;

import co.com.sofka.domain.generic.Command;
import domain.empleado.values.Descripcion;
import domain.factura.values.FacturaId;


public class ActualizarPrecio implements Command {

    private final FacturaId facturaId;
    private final Descripcion precio;

    public ActualizarPrecio(FacturaId facturaId, Descripcion descripcion){
        this.facturaId = facturaId;
        this.precio = descripcion;
    }

    public FacturaId getFacturaId() {
        return facturaId;
    }

    public Descripcion getPrecio() {
        return precio;
    }
}
