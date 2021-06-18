package usecase.empleado;

import co.com.sofka.business.generic.UseCase;
import co.com.sofka.business.support.RequestCommand;
import co.com.sofka.business.support.ResponseEvents;
import domain.empleado.commands.AsociarCuenta;

public class AsociarCuentaUseCase extends UseCase<RequestCommand<AsociarCuenta>, ResponseEvents> {
    @Override
    public void executeUseCase(RequestCommand<AsociarCuenta> asociarCuentaRequestCommand){
        var command = asociarCuentaRequestCommand.getCommand();
        var empleado = command.getCuenta();

        //emit().onResponse(new ResponseEvents(empleado.getUncommitedChanges()));
    }
}
