package domain.empleado.commands;


import co.com.sofka.domain.generic.Command;
import domain.empleado.values.CuentaId;
import domain.empleado.values.Email;
import domain.empleado.values.EmpleadoId;


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
