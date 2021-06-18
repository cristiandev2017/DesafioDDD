package domain.factura.commands;

import co.com.sofka.domain.generic.Command;
import domain.empleado.values.Descripcion;
import domain.factura.values.FacturaId;


public class ActualizarDescripcion implements Command {

    private final FacturaId facturaId;
    private final Descripcion descripcion;

    public ActualizarDescripcion(FacturaId facturaId, Descripcion descripcion){
        this.facturaId = facturaId;
        this.descripcion = descripcion;
    }

    public FacturaId getFacturaId() {
        return facturaId;
    }

    public Descripcion getDescripcion() {
        return descripcion;
    }
}
