package usecase.factura;

import co.com.sofka.business.generic.UseCase;
import co.com.sofka.business.support.RequestCommand;
import co.com.sofka.business.support.ResponseEvents;
import domain.factura.Factura;
import domain.factura.commands.ActualizarFecha;

public class ActualizarFechaUseCase extends UseCase<RequestCommand<ActualizarFecha>, ResponseEvents> {

    @Override
    public void executeUseCase(RequestCommand<ActualizarFecha> actualizarFechaRequestCommand){
        var command = actualizarFechaRequestCommand.getCommand();
        var factura = Factura.from(command.getFacturaId(),retrieveEvents(command.getFacturaId().value()));

        factura.actualizarFecha(command.getFecha());
        emit().onResponse(new ResponseEvents(factura.getUncommittedChanges()));
    }
}
