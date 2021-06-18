package domain.factura.events;

import co.com.sofka.domain.generic.DomainEvent;
import domain.empleado.values.Descripcion;
import domain.empleado.values.EmpleadoId;
import domain.factura.Cliente;
import domain.factura.Pedido;
import domain.factura.values.Fecha;
import domain.factura.values.Precio;

public class FacturaCreada extends DomainEvent {
    private final Descripcion descripcion;
    private final Fecha fecha;
    private final Precio precio;
    private final Pedido pedido;
    private final Cliente cliente;
    private final EmpleadoId empleadoId;

    public FacturaCreada(Descripcion descripcion,Fecha fecha, Precio precio, Pedido pedido, Cliente cliente, EmpleadoId empleadoId){
        super("sofka.domain.factura.facturacreada");
        this.descripcion = descripcion;
        this.fecha = fecha;
        this.precio = precio;
        this.pedido = pedido;
        this.cliente = cliente;
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

    public Pedido getPedido() {
        return pedido;
    }

    public Cliente getCliente() {
        return cliente;
    }
}
