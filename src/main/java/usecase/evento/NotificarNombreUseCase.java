package usecase.evento;

import co.com.sofka.business.generic.UseCase;
import co.com.sofka.business.support.ResponseEvents;
import co.com.sofka.business.support.TriggeredEvent;
import domain.empleado.events.CargoCreado;
import domain.empleado.events.CuentaCreada;

public class NotificarNombreUseCase extends UseCase<TriggeredEvent<CargoCreado>, ResponseEvents> {

    @Override
    public void executeUseCase(TriggeredEvent<CargoCreado> cargoCreadoTriggeredEvent){
        var event=cargoCreadoTriggeredEvent.getDomainEvent();
        var cargoService = getService(CargoService.class).orElseThrow();
        var sender = getService(SenderNombreService.class).orElseThrow();
        var nombre = cargoService.getNombreByEmpleadoId(event.getNombre());
        sender.sendNombre(nombre, "Content body");
    }

}
