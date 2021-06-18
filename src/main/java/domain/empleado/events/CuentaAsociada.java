package domain.empleado.events;

import co.com.sofka.domain.generic.DomainEvent;
import domain.empleado.Cuenta;

public class CuentaAsociada extends DomainEvent {
    private final Cuenta cuenta;
    public CuentaAsociada(Cuenta cuenta){
        super("sofka.domain.empleado.cuentaasociada");
        this.cuenta = cuenta;
    }

    public Cuenta getCuenta() {
        return cuenta;
    }
}
