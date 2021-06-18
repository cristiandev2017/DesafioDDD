package domain.empleado.events;

import co.com.sofka.domain.generic.DomainEvent;
import domain.empleado.values.Telefono;

public class TelefonoActualizado extends DomainEvent {
    private final Telefono telefono;
    public TelefonoActualizado(Telefono telefono){
        super("sofka.domain.empleado.telefonoactualizado");
        this.telefono=telefono;
    }

    public Telefono getTelefono() {
        return telefono;
    }
}
