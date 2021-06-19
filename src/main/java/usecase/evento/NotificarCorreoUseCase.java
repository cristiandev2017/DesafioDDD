package usecase.evento;

import co.com.sofka.business.generic.UseCase;
import co.com.sofka.business.support.ResponseEvents;
import co.com.sofka.business.support.TriggeredEvent;
import domain.empleado.events.CuentaCreada;

public class NotificarCorreoUseCase extends UseCase<TriggeredEvent<CuentaCreada>, ResponseEvents> {

    @Override
    public void executeUseCase(TriggeredEvent<CuentaCreada> cuentaCreadaTriggeredEvent){
        var event=cuentaCreadaTriggeredEvent.getDomainEvent();
        var cuentaService = getService(CuentaService.class).orElseThrow();
        var sender = getService(SenderEmailService.class).orElseThrow();

        var email = cuentaService.getEmailByEmpleadoId(event.getCuentaId());
        sender.sendEmail(email, "Content body");

    }
}
