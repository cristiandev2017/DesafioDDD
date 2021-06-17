package empleado.events;

import co.com.sofka.domain.generic.DomainEvent;
import empleado.values.CuentaId;
import empleado.values.Email;

public class CuentaCreada extends DomainEvent {
    private final CuentaId cuentaId;
    private final Email email;

    public CuentaCreada(CuentaId cuentaId, Email email){
        super("sofka.empleado.cuentacreada");
        this.cuentaId = cuentaId;
        this.email = email;
    }

    public CuentaId getCuentaId() {
        return cuentaId;
    }

    public Email getEmail() {
        return email;
    }
}
