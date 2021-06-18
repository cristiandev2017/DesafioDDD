package factura;

import co.com.sofka.domain.generic.EventChange;
import factura.events.*;


public class FacturaChange extends EventChange {
    public FacturaChange(Factura factura){
        //Crear Factura
        apply((FacturaCreada event)->{
            factura.descripcion = event.getDescripcion();
            factura.precio = event.getPrecio();
            factura.fecha = event.getFecha();
            factura.cliente = event.getCliente();
            factura.pedido = event.getPedido();
            factura.empleadoId = event.getEmpleadoId();
        });

        //Crear Cliente
        apply((ClienteCreado event)->{
           factura.cliente = new Cliente(event.getClienteId(),event.getNombre());
        });

        //Actualizar descripcion
        apply((DescripcionActualizada event)->{
           factura.descripcion = event.getDescripcion();
        });

        //Actualizar Fecha
        apply((FechaActualizada event)->{
            factura.fecha = event.getFecha();
        });

        //Actualizar Precio
        apply((PrecioActualizado event)->{
            factura.precio = event.getPrecio();
        });

        //Crear Pedido
        apply((PedidoCreado event)->{
           factura.pedido = new Pedido(event.getPedidoId(),event.getDetalle());
        });

        //Agregar Productos
        apply((ProductoAgregado event)->{
            factura.productos.add(new Producto(
                    event.getProductoId(),
                    event.getNombre(),
                    event.getExistencia()
            ));
        });

    }
}
