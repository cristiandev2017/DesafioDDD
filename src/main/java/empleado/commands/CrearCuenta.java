package empleado.commands;


import co.com.sofka.domain.generic.Command;
import empleado.values.CuentaId;
import empleado.values.Email;
import empleado.values.EmpleadoId;


public class CrearCuenta implements Command {
    private final EmpleadoId empleadoId;
    private final CuentaId entityId;
    private final Email email;

    public CrearCuenta(EmpleadoId empleadoId, CuentaId entityId, Email email){
        this.empleadoId = empleadoId;
        this.entityId = entityId;
        this.email = email;
    }

    public EmpleadoId getEmpleadoId() {
        return empleadoId;
    }

    public CuentaId getEntityId() {
        return entityId;
    }

    public Email getEmail() {
        return email;
    }
}
