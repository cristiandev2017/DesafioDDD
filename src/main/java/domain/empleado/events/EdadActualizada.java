package domain.empleado.events;

import co.com.sofka.domain.generic.DomainEvent;
import domain.empleado.values.Edad;

public class EdadActualizada extends DomainEvent {
    private final Edad edad;
    public EdadActualizada(Edad edad){
        super("sofka.domain.empleado.edadactualizada");
        this.edad = edad;
    }

    public Edad getEdad() {
        return edad;
    }
}
