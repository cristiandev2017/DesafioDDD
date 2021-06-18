package empleado.events;

import co.com.sofka.domain.generic.DomainEvent;
import empleado.Cuenta;
import empleado.values.CuentaId;

public class CuentaAsociada extends DomainEvent {
    private final Cuenta cuenta;
    public CuentaAsociada(Cuenta cuenta){
        super("sofka.empleado.cuentaasociada");
        this.cuenta = cuenta;
    }

    public Cuenta getCuenta() {
        return cuenta;
    }
}
