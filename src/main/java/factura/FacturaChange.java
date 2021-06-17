package factura;

import co.com.sofka.domain.generic.EventChange;
import factura.events.FacturaCreada;


public class FacturaChange extends EventChange {
    public FacturaChange(Factura factura){
        apply((FacturaCreada event)->{
            factura.descripcion = event.getDescripcion();
            factura.precio = event.getPrecio();
            factura.fecha = event.getFecha();
            factura.clienteId = event.getClienteId();
            factura.pedidoId = event.getPedidoId();
            factura.empleadoId = event.getEmpleadoId();
        });
    }
}
