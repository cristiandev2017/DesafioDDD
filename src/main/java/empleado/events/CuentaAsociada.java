package empleado.events;

import co.com.sofka.domain.generic.DomainEvent;
import empleado.values.CuentaId;

public class CuentaAsociada extends DomainEvent {
    private final CuentaId cuentaId;
    public CuentaAsociada(CuentaId cuentaId){
        super("sofka.empleado.cuentaasociada");
        this.cuentaId = cuentaId;
    }

    public CuentaId getCuentaId() {
        return cuentaId;
    }
}
