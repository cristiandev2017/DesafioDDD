package usecase.factura;

import co.com.sofka.business.generic.UseCase;
import co.com.sofka.business.support.RequestCommand;
import co.com.sofka.business.support.ResponseEvents;
import domain.factura.Factura;
import domain.factura.commands.ActualizarFecha;
import domain.factura.commands.ActualizarPrecio;

public class ActualizarPrecioUseCase extends UseCase<RequestCommand<ActualizarPrecio>, ResponseEvents> {

    @Override
    public void executeUseCase(RequestCommand<ActualizarPrecio> actualizarPrecioRequestCommand){
        var command = actualizarPrecioRequestCommand.getCommand();
        var factura = Factura.from(command.getFacturaId(),retrieveEvents(command.getFacturaId().value()));

        factura.actualizarPrecio(command.getPrecio());
        emit().onResponse(new ResponseEvents(factura.getUncommittedChanges()));
    }
}
