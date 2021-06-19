package usecase.evento;

import domain.empleado.values.CuentaId;
import domain.empleado.values.EmpleadoId;

public interface CuentaService {
    String getEmailByEmpleadoId(CuentaId cuentaId);
}
