package domain.factura.events;

import co.com.sofka.domain.generic.DomainEvent;
import domain.empleado.values.Nombre;
import domain.factura.values.ClienteId;

public class NombreClienteActualizado extends DomainEvent {
    private final ClienteId clienteId;
    private final Nombre nombre;
    public NombreClienteActualizado(ClienteId clienteId, Nombre nombre){
        super("sofka.domain.factura.nombre");
        this.clienteId = clienteId;
        this.nombre = nombre;
    }

    public ClienteId getClienteId() {
        return clienteId;
    }

    public Nombre getNombre() {
        return nombre;
    }
}
