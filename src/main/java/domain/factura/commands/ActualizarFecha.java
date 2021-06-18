package domain.factura.commands;

import co.com.sofka.domain.generic.Command;
import domain.empleado.values.Descripcion;
import domain.factura.values.FacturaId;


public class ActualizarFecha implements Command {

    private final FacturaId facturaId;
    private final Descripcion fecha;

    public ActualizarFecha(FacturaId facturaId, Descripcion descripcion){
        this.facturaId = facturaId;
        this.fecha = descripcion;
    }

    public FacturaId getFacturaId() {
        return facturaId;
    }

    public Descripcion getFecha() {
        return fecha;
    }
}
