package usecase.empleado;

import co.com.sofka.business.generic.UseCase;
import co.com.sofka.business.support.RequestCommand;
import co.com.sofka.business.support.ResponseEvents;
import domain.empleado.Empleado;
import domain.empleado.commands.CrearEmpleado;

public class CrearEmpleadoUseCase extends UseCase<RequestCommand<CrearEmpleado>,ResponseEvents> {

    @Override
    public void executeUseCase(RequestCommand<CrearEmpleado> crearEmpleadoRequestCommand){
        var command=crearEmpleadoRequestCommand.getCommand();
        var empleado = new Empleado(command.getEntityId(),command.getNombre(),command.getEdad(),command.getTelefono(),command.getDireccion(),command.getCuenta(),command.getCargo());
        //Confirmaciones
        emit().onResponse(new ResponseEvents(empleado.getUncommittedChanges()));
    }
}

