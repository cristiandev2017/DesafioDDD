package usecase.factura;

import co.com.sofka.business.generic.UseCase;
import co.com.sofka.business.support.RequestCommand;
import co.com.sofka.business.support.ResponseEvents;
import domain.factura.Factura;
import domain.factura.commands.CrearFactura;



public class CrearFacturaUseCase extends UseCase<RequestCommand<CrearFactura>,ResponseEvents> {

    @Override
    public void executeUseCase(RequestCommand<CrearFactura> crearFacturaRequestCommand){
        var command=crearFacturaRequestCommand.getCommand();
        var factura = new Factura(command.getEntityId(),command.getDescripcion(),command.getFecha(),command.getPrecio(),command.getPedido(),command.getCliente(),command.getEmpleadoId());
        //Confirmaciones
        emit().onResponse(new ResponseEvents(factura.getUncommittedChanges()));
    }
}

