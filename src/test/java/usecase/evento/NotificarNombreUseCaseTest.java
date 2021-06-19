package usecase.evento;

import co.com.sofka.business.generic.ServiceBuilder;
import co.com.sofka.business.generic.UseCaseHandler;
import co.com.sofka.business.support.TriggeredEvent;
import domain.empleado.events.CargoCreado;
import domain.empleado.events.CuentaCreada;
import domain.empleado.values.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.Mockito.*;
import static org.mockito.Mockito.verify;

class NotificarNombreUseCaseTest {

    private NotificarNombreUseCase notificarNombreUseCase;

    private CargoService cargoService;
    private SenderNombreService senderNombreService;

    @BeforeEach
    public void setup(){
        notificarNombreUseCase = new NotificarNombreUseCase();
        cargoService = mock(CargoService.class);
        senderNombreService = mock(SenderNombreService.class);
        ServiceBuilder builder = new ServiceBuilder()
                .addService(cargoService)
                .addService(senderNombreService);
        notificarNombreUseCase.addServiceBuilder(builder);
    }

    @Test
    void sendNombreHappyPath(){
        //Arrage
        var event = new CargoCreado(
                CargoId.of("sss"),
                new Nombre("cristian"),
                new TipoCargo("obrero de cabina")
        );

        when(cargoService.getNombreByEmpleadoId(any())).thenReturn("cristian camilo");
        doNothing().when(senderNombreService).sendNombre(anyString(),anyString());

        //act
        UseCaseHandler.getInstance()
                .syncExecutor(notificarNombreUseCase, new TriggeredEvent<>(event));

        //assert
        verify(cargoService).getNombreByEmpleadoId(any());
        verify(senderNombreService).sendNombre(anyString(),anyString());
    }


}