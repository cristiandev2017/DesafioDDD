package factura.commands;

import co.com.sofka.domain.generic.Command;
import empleado.values.Precio;
import empleado.values.EmpleadoId;
import factura.Cliente;
import factura.Pedido;
import factura.values.FacturaId;

public class CrearFactura implements Command {
    private final FacturaId entityId;
    private final factura.values.Fecha fecha;
    private final Precio descripcion;
    private final factura.values.Precio precio;
    private final Pedido pedido;
    private final Cliente cliente;
    private final EmpleadoId empleadoId;

    public CrearFactura(FacturaId entityId, Precio descripcion, factura.values.Fecha fecha, factura.values.Precio precio, Pedido pedido, Cliente cliente, EmpleadoId empleadoId){
        this.entityId = entityId;
        this.descripcion = descripcion;
        this.fecha = fecha;
        this.precio = precio;
        this.pedido = pedido;
        this.cliente = cliente;
        this.empleadoId = empleadoId;
    }

    public FacturaId getEntityId() {
        return entityId;
    }

    public factura.values.Fecha getFecha() {
        return fecha;
    }

    public Precio getDescripcion() {
        return descripcion;
    }

    public factura.values.Precio getPrecio() {
        return precio;
    }

    public Pedido getPedido() {
        return pedido;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public EmpleadoId getEmpleadoId() {
        return empleadoId;
    }
}
