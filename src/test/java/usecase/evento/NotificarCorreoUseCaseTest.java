package usecase.evento;

import co.com.sofka.business.generic.UseCaseHandler;
import co.com.sofka.business.generic.ServiceBuilder;
import co.com.sofka.business.support.TriggeredEvent;
import domain.empleado.events.CuentaCreada;
import domain.empleado.values.CuentaId;
import domain.empleado.values.Email;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.internal.matchers.Any;

import static org.mockito.ArgumentMatchers.any;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

class NotificarCorreoUseCaseTest {

    private NotificarCorreoUseCase notificarCorreoUseCase;

    private CuentaService cuentaService;
    private SenderEmailService senderEmailService;

    @BeforeEach
    public void setup(){
        notificarCorreoUseCase = new NotificarCorreoUseCase();
        cuentaService = mock(CuentaService.class);
        senderEmailService = mock(SenderEmailService.class);
        ServiceBuilder builder = new ServiceBuilder()
                .addService(cuentaService)
                .addService(senderEmailService);
        notificarCorreoUseCase.addServiceBuilder(builder);
    }

    @Test
    void sendEmailHappyPath(){
        //Arrage
        var event = new CuentaCreada(
                CuentaId.of("sss"),
                new Email("hola@correo.com")
        );

        when(cuentaService.getEmailByEmpleadoId(any())).thenReturn("correo@cristian.com");
        doNothing().when(senderEmailService).sendEmail(anyString(),anyString());

        //act
         UseCaseHandler.getInstance()
                .syncExecutor(notificarCorreoUseCase, new TriggeredEvent<>(event));

         //assert
         verify(cuentaService).getEmailByEmpleadoId(any());
         verify(senderEmailService).sendEmail(anyString(),anyString());
    }

}