package empleado.events;

import co.com.sofka.domain.generic.DomainEvent;
import empleado.values.Email;
import empleado.values.FuncionId;

public class EmailCuentaActualizado extends DomainEvent {
    private final FuncionId entityId;
    private final Email email;

    public EmailCuentaActualizado(FuncionId entityId, Email email){
        super("sofka.empleado.emailcuentaactualizado");
        this.entityId = entityId;
        this.email = email;
    }

    public FuncionId getEntityId() {
        return entityId;
    }

    public Email getEmail() {
        return email;
    }



}
