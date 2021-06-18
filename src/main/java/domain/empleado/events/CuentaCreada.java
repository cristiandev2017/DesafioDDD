package domain.empleado.events;

import co.com.sofka.domain.generic.DomainEvent;
import domain.empleado.values.CuentaId;
import domain.empleado.values.Email;

public class CuentaCreada extends DomainEvent {
    private final CuentaId cuentaId;
    private final Email email;

    public CuentaCreada(CuentaId cuentaId, Email email){
        super("sofka.domain.empleado.cuentacreada");
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
