package usecase.evento;

import domain.empleado.values.Nombre;

public interface CargoService {
    String getNombreByEmpleadoId(Nombre nombre);
}
