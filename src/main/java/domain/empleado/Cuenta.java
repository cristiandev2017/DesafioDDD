package domain.empleado;

import co.com.sofka.domain.generic.Entity;
import domain.empleado.values.CuentaId;
import domain.empleado.values.Email;

public class Cuenta extends Entity<CuentaId> {
    private Email email;

    public Cuenta(CuentaId entityId, Email email){
        super(entityId);
        this.email = email;
    }

    public Email eail() {
        return email;
    }
}
