package domain.factura;

import co.com.sofka.domain.generic.Entity;
import domain.empleado.values.Nombre;
import domain.factura.values.ClienteId;

public class Cliente extends Entity<ClienteId> {
    private Nombre nombre;

    public Cliente(ClienteId entityId, Nombre nombre){
        super(entityId);
        this.nombre = nombre;
    }

    public Nombre getNombre() {
        return nombre;
    }
}
