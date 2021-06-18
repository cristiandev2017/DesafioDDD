package usecase.empleado;

import co.com.sofka.business.generic.UseCase;
import co.com.sofka.business.support.RequestCommand;
import co.com.sofka.business.support.ResponseEvents;
import domain.empleado.Empleado;
import domain.empleado.commands.ActualizarDireccion;
import domain.empleado.commands.ActualizarNombre;

public class ActualizarDireccionUseCase extends UseCase<RequestCommand<ActualizarDireccion>, ResponseEvents> {

    @Override
    public void executeUseCase(RequestCommand<ActualizarDireccion> actualizarDireccionRequestCommand){
        var command =actualizarDireccionRequestCommand.getCommand();
        var empleado = Empleado.from(command.getEmpleadoId(),retrieveEvents(command.getEmpleadoId().value()));

        empleado.actualizarDireccion(command.getDireccion());
        emit().onResponse(new ResponseEvents(empleado.getUncommittedChanges()));

    }
}
