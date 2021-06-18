package usecase.empleado;

import co.com.sofka.business.generic.UseCase;
import co.com.sofka.business.support.RequestCommand;
import co.com.sofka.business.support.ResponseEvents;
import domain.empleado.Cargo;
import domain.empleado.Empleado;
import domain.empleado.commands.CrearCargo;


public class CrearCargoUseCase extends UseCase<RequestCommand<CrearCargo>,ResponseEvents> {

    @Override
    public void executeUseCase(RequestCommand<CrearCargo>crearCargoRequestCommand){
        var command=crearCargoRequestCommand.getCommand();
        var empleado = new Cargo(command.getEntityId(),command.getNombre(),command.getTipoCargo());
        //Confirmaciones
        //emit().onResponse(new ResponseEvents(cargo.getUncommittedChanges()));
    }
}

