package empleado;

import co.com.sofka.domain.generic.Entity;
import empleado.values.CuentaId;
import empleado.values.Email;

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
