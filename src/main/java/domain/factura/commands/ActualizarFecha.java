package domain.factura.commands;

import co.com.sofka.domain.generic.Command;
import domain.empleado.values.Descripcion;
import domain.factura.values.FacturaId;
import domain.factura.values.Fecha;


public class ActualizarFecha implements Command {

    private final FacturaId facturaId;
    private final Fecha fecha;

    public ActualizarFecha(FacturaId facturaId, Fecha fecha){
        this.facturaId = facturaId;
        this.fecha = fecha;
    }

    public FacturaId getFacturaId() {
        return facturaId;
    }

    public Fecha getFecha() {
        return fecha;
    }
}
