package domain.empleado.events;

import co.com.sofka.domain.generic.DomainEvent;
import domain.empleado.values.Direccion;
import domain.empleado.values.Nombre;

public class DireccionActualizada extends DomainEvent {
    private final Direccion direccion;
    public DireccionActualizada(Direccion direccion){
        super("sofka.domain.empleado.direccion");
        this.direccion =direccion;
    }

    public Direccion getDireccion() {
        return direccion;
    }
}
