package usecase.empleado;

import co.com.sofka.business.generic.UseCase;
import co.com.sofka.business.support.RequestCommand;
import co.com.sofka.business.support.ResponseEvents;
import domain.empleado.Empleado;
import domain.empleado.commands.ActualizarNombre;

public class ActualizarNombreUseCase extends UseCase<RequestCommand<ActualizarNombre>, ResponseEvents> {

    @Override
    public void executeUseCase(RequestCommand<ActualizarNombre> actualizarNombreRequestCommand){
        var command =actualizarNombreRequestCommand.getCommand();
        var empleado = Empleado.from(command.getEmpleadoId(),retrieveEvents(command.getEmpleadoId().value()));

        //Se pueden poner reglas de negocio
        empleado.actualizarNombre(command.getNombre());
        emit().onResponse(new ResponseEvents(empleado.getUncommittedChanges()));
    }
}
