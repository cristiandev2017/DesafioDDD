package factura;

import co.com.sofka.domain.generic.AggregateEvent;
import co.com.sofka.domain.generic.DomainEvent;
import empleado.values.Descripcion;
import empleado.values.EmpleadoId;
import factura.events.FacturaCreada;
import factura.values.*;

import java.util.List;
import java.util.Set;

public class Factura extends AggregateEvent<FacturaId> {
    protected Descripcion descripcion;
    protected Fecha fecha;
    protected Precio precio;
    protected EmpleadoId empleadoId;
    //Relacionados
    protected PedidoId pedidoId;
    protected ClienteId clienteId;
    protected Set<Producto> productos;

    //Constructor inicial
    public Factura(FacturaId entityId,Descripcion descripcion, Fecha fecha, Precio precio,PedidoId pedidoId,ClienteId clienteId, EmpleadoId empleadoId){
        super(entityId);
        appendChange(new FacturaCreada(descripcion, fecha, precio,pedidoId,clienteId, empleadoId)).apply();
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

}
