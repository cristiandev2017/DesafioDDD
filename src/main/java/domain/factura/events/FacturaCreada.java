package factura.events;

import co.com.sofka.domain.generic.DomainEvent;
import empleado.values.Precio;
import empleado.values.EmpleadoId;
import factura.Cliente;
import factura.Pedido;

public class FacturaCreada extends DomainEvent {
    private final Precio descripcion;
    private final factura.values.Fecha fecha;
    private final factura.values.Precio precio;
    private final Pedido pedido;
    private final Cliente cliente;
    private final EmpleadoId empleadoId;

    public FacturaCreada(Precio descripcion, factura.values.Fecha fecha, factura.values.Precio precio, Pedido pedido, Cliente cliente, EmpleadoId empleadoId){
        super("sofka.factura.facturacreada");
        this.descripcion = descripcion;
        this.fecha = fecha;
        this.precio = precio;
        this.pedido = pedido;
        this.cliente = cliente;
        this.empleadoId = empleadoId;
    }

    public Precio getDescripcion() {
        return descripcion;
    }

    public factura.values.Fecha getFecha() {
        return fecha;
    }

    public factura.values.Precio getPrecio() {
        return precio;
    }

    public EmpleadoId getEmpleadoId() {
        return empleadoId;
    }

    public Pedido getPedido() {
        return pedido;
    }

    public Cliente getCliente() {
        return cliente;
    }
}
