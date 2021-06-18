package usecase.empleado;

import co.com.sofka.business.generic.UseCase;
import co.com.sofka.business.support.RequestCommand;
import co.com.sofka.business.support.ResponseEvents;
import domain.empleado.Empleado;
import domain.empleado.commands.AsociarCargo;

public class AsignarCargoUseCase extends UseCase<RequestCommand<AsociarCargo>, ResponseEvents> {

    @Override
    public void executeUseCase(RequestCommand<AsociarCargo> asociarCargoRequestCommand){
        var command = asociarCargoRequestCommand.getCommand();
        var empleado = Empleado.from(command.getEmpleadoId(),retrieveEvents(command.getEmpleadoId().value()));
        empleado.asociarCargo(command.getCargo());
        emit().onResponse(new ResponseEvents(empleado.getUncommittedChanges()));
    }
}
