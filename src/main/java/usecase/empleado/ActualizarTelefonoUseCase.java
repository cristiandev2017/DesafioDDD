package usecase.empleado;

import co.com.sofka.business.generic.UseCase;
import co.com.sofka.business.support.RequestCommand;
import co.com.sofka.business.support.ResponseEvents;
import domain.empleado.Empleado;
import domain.empleado.commands.ActualizarEdad;
import domain.empleado.commands.ActualizarTelefono;


public class ActualizarTelefonoUseCase extends UseCase<RequestCommand<ActualizarTelefono>, ResponseEvents> {

    @Override
    public void executeUseCase(RequestCommand<ActualizarTelefono> actualizarTelefonoRequestCommand){
        var command =actualizarTelefonoRequestCommand.getCommand();
        var empleado = Empleado.from(command.getEmpleadoId(),retrieveEvents(command.getEmpleadoId().value()));

        empleado.actualizarTelefono(command.getTelefono());
        emit().onResponse(new ResponseEvents(empleado.getUncommittedChanges()));
    }
}
