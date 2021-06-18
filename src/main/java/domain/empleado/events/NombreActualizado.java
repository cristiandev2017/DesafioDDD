package domain.empleado.events;

import co.com.sofka.domain.generic.DomainEvent;
import domain.empleado.values.Nombre;

public class NombreActualizado extends DomainEvent {
    private final Nombre nombre;
    public NombreActualizado(Nombre nombre){
        super("sofka.domain.empleado.nombre");
        this.nombre =nombre;
    }

    public Nombre getNombre() {
        return nombre;
    }
}
