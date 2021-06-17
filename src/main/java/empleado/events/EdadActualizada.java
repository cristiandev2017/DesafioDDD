package empleado.events;

import co.com.sofka.domain.generic.DomainEvent;
import empleado.values.Edad;

public class EdadActualizada extends DomainEvent {
    private final Edad edad;
    public EdadActualizada(Edad edad){
        super("sofka.empleado.edadactualizada");
        this.edad = edad;
    }

    public Edad getEdad() {
        return edad;
    }
}
