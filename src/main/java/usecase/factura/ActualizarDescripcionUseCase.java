package usecase.factura;

import co.com.sofka.business.generic.UseCase;
import co.com.sofka.business.support.RequestCommand;
import co.com.sofka.business.support.ResponseEvents;
import domain.factura.Factura;
import domain.factura.commands.ActualizarDescripcion;
import domain.factura.commands.ActualizarPrecio;

public class ActualizarDescripcionUseCase extends UseCase<RequestCommand<ActualizarDescripcion>, ResponseEvents> {

    @Override
    public void executeUseCase(RequestCommand<ActualizarDescripcion> actualizarDescripcionRequestCommand){
        var command = actualizarDescripcionRequestCommand.getCommand();
        var factura = Factura.from(command.getFacturaId(),retrieveEvents(command.getFacturaId().value()));

        factura.actualizarDescripcion(command.getDescripcion());
        emit().onResponse(new ResponseEvents(factura.getUncommittedChanges()));
    }
}
