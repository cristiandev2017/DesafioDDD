package empleado.events;

import co.com.sofka.domain.generic.DomainEvent;
import empleado.values.Nombre;

public class NombreActualizado extends DomainEvent {
    private final Nombre nombre;
    public NombreActualizado(Nombre nombre){
        super("sofka.empleado.nombre");
        this.nombre =nombre;
    }

    public Nombre getNombre() {
        return nombre;
    }
}
