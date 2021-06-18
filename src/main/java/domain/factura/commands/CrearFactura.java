package domain.factura.commands;

import co.com.sofka.domain.generic.Command;
import domain.empleado.values.Descripcion;
import domain.empleado.values.EmpleadoId;
import domain.factura.Cliente;
import domain.factura.Pedido;
import domain.factura.values.FacturaId;
import domain.factura.values.Fecha;
import domain.factura.values.Precio;

public class CrearFactura implements Command {
    private final FacturaId entityId;
    private final Fecha fecha;
    private final Descripcion descripcion;
    private final Precio precio;
    private final Pedido pedido;
    private final Cliente cliente;
    private final EmpleadoId empleadoId;

    public CrearFactura(FacturaId entityId, Descripcion descripcion, Fecha fecha, Precio precio, Pedido pedido, Cliente cliente, EmpleadoId empleadoId){
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

    public Fecha getFecha() {
        return fecha;
    }

    public Descripcion getDescripcion() {
        return descripcion;
    }

    public Precio getPrecio() {
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
