package factura.events;

import co.com.sofka.domain.generic.DomainEvent;
import empleado.values.Descripcion;
import empleado.values.EmpleadoId;
import factura.values.ClienteId;
import factura.values.Fecha;
import factura.values.PedidoId;
import factura.values.Precio;

public class FacturaCreada extends DomainEvent {
    private final Descripcion descripcion;
    private final Fecha fecha;
    private final Precio precio;
    private final PedidoId pedidoId;
    private final ClienteId clienteId;
    private final EmpleadoId empleadoId;

    public FacturaCreada(Descripcion descripcion, Fecha fecha, Precio precio,PedidoId pedidoId,ClienteId clienteId, EmpleadoId empleadoId){
        super("sofka.factura.facturacreada");
        this.descripcion = descripcion;
        this.fecha = fecha;
        this.precio = precio;
        this.pedidoId = pedidoId;
        this.clienteId = clienteId;
        this.empleadoId = empleadoId;
    }

    public Descripcion getDescripcion() {
        return descripcion;
    }

    public Fecha getFecha() {
        return fecha;
    }

    public Precio getPrecio() {
        return precio;
    }

    public EmpleadoId getEmpleadoId() {
        return empleadoId;
    }

    public PedidoId getPedidoId() {
        return pedidoId;
    }

    public ClienteId getClienteId() {
        return clienteId;
    }
}
