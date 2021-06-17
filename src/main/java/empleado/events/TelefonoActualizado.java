package empleado.events;

import co.com.sofka.domain.generic.DomainEvent;
import empleado.values.Telefono;

public class TelefonoActualizado extends DomainEvent {
    private final Telefono telefono;
    public TelefonoActualizado(Telefono telefono){
        super("sofka.empleado.telefonoactualizado");
        this.telefono=telefono;
    }

    public Telefono getTelefono() {
        return telefono;
    }
}
