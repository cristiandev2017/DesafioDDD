package factura;

import co.com.sofka.domain.generic.AggregateEvent;
import co.com.sofka.domain.generic.DomainEvent;
import empleado.values.Precio;
import empleado.values.EmpleadoId;
import empleado.values.Nombre;
import factura.events.*;
import factura.values.*;

import java.util.List;
import java.util.Objects;
import java.util.Optional;
import java.util.Set;

public class Factura extends AggregateEvent<FacturaId> {
    protected Precio descripcion;
    protected factura.values.Fecha fecha;
    protected factura.values.Precio precio;
    protected EmpleadoId empleadoId;
    //Relacionados
    protected Pedido pedido;
    protected Cliente cliente;
    protected Set<Producto> productos;

    //Constructor inicial
    public Factura(FacturaId entityId, Precio descripcion, factura.values.Fecha fecha, factura.values.Precio precio, Pedido pedido, Cliente cliente, EmpleadoId empleadoId){
        super(entityId);
        appendChange(new FacturaCreada(descripcion, fecha, precio,pedido,cliente, empleadoId)).apply();
    }

    //Factoria
    public static Factura from(FacturaId facturaId, List<DomainEvent> events){
        var factura = new Factura(facturaId);
        events.forEach(factura::applyEvent);
        return factura;
    }

    //Constructor privado
    private Factura(FacturaId entityId){
        super(entityId);
        //Se realiza una suscripcion de los eventos
        subscribe(new FacturaChange(this));
    }

    //Eventos
    //Crear cliente
    public void crearCliente(ClienteId clienteId, Nombre nombre){
        appendChange(new ClienteCreado(clienteId,nombre)).apply();
    }

    //Actualizar Descripcion
    public void actualizarDescripcion(Precio descripcion){
        appendChange(new DescripcionActualizada(descripcion)).apply();
    }

    //Actualizar Precio
    public void actualizarPrecio(factura.values.Precio precio){
        appendChange(new PrecioActualizado(precio)).apply();
    }

    //Actualizar Fecha
    public void actualizarFecha(factura.values.Fecha fecha){
        appendChange(new FechaActualizada(fecha)).apply();
    }

    //Crear Pedido
    public void crearPedido(PedidoId pedidoId, Detalle detalle){
        appendChange(new PedidoCreado(pedidoId,detalle)).apply();
    }

    //Agregar Productos
    public void agregarProducto(ProductoId entityId, Nombre nombre, Existencia existencia){
        Objects.requireNonNull(entityId);
        Objects.requireNonNull(nombre);
        Objects.requireNonNull(existencia);
        appendChange(new ProductoAgregado(entityId,nombre,existencia)).apply();
    }

    protected Optional<Producto> getProductoPorId(ProductoId entityId){
        return productos()
                .stream()
                .filter(funcion-> funcion.identity().equals(entityId))
                .findFirst();
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

    public Set<Producto> productos() {
        return productos;
    }
}
