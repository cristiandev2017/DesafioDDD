package empleado.commands;

import co.com.sofka.domain.generic.Command;
import empleado.Cuenta;
import empleado.values.EmpleadoId;

public class AsociarCuenta implements Command {

    private final EmpleadoId empleadoId;
    private final Cuenta cuenta;

    public AsociarCuenta(EmpleadoId empleadoId, Cuenta cuenta){
        this.empleadoId = empleadoId;
        this.cuenta = cuenta;
    }

    public EmpleadoId getEmpleadoId() {
        return empleadoId;
    }

    public Cuenta getCuenta() {
        return cuenta;
    }
}
