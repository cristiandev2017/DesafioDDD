package usecase.empleado;

import co.com.sofka.business.generic.UseCase;
import co.com.sofka.business.support.RequestCommand;
import co.com.sofka.business.support.ResponseEvents;
import domain.empleado.Empleado;
import domain.empleado.commands.ActualizarEdad;


public class ActualizarEdadUseCase extends UseCase<RequestCommand<ActualizarEdad>, ResponseEvents> {

    @Override
    public void executeUseCase(RequestCommand<ActualizarEdad> actualizarEdadRequestCommand){
        var command =actualizarEdadRequestCommand.getCommand();
        var empleado = Empleado.from(command.getEmpleadoId(),retrieveEvents(command.getEmpleadoId().value()));

        empleado.actualizarEdad(command.getEdad());
        emit().onResponse(new ResponseEvents(empleado.getUncommittedChanges()));
    }
}
