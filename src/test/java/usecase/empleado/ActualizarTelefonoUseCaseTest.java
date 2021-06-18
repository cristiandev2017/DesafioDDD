package usecase.empleado;

import co.com.sofka.business.generic.UseCaseHandler;
import co.com.sofka.business.repository.DomainEventRepository;
import co.com.sofka.business.support.RequestCommand;
import co.com.sofka.domain.generic.DomainEvent;
import domain.empleado.Cargo;
import domain.empleado.Cuenta;
import domain.empleado.commands.ActualizarTelefono;
import domain.empleado.events.EmpleadoCreado;
import domain.empleado.events.TelefonoActualizado;
import domain.empleado.values.*;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

class ActualizarTelefonoUseCaseTest {

    private ActualizarTelefonoUseCase actualizarTelefonoUseCase;

    @Mock
    private DomainEventRepository repository;

    @BeforeEach
    public void setup(){
        actualizarTelefonoUseCase = new ActualizarTelefonoUseCase();
        repository = mock(DomainEventRepository.class);
        actualizarTelefonoUseCase.addRepository(repository);
    }

    @Test
    void actualizarTelefonoHappyPath(){
        //Arrange
        var command = new ActualizarTelefono(
                EmpleadoId.of("xxx-xxx"),
                new Telefono("4567809")
        );
        when(repository.getEventsBy("xxx-xxx")).thenReturn(events());

        //Act
        var response = UseCaseHandler.getInstance()
                .setIdentifyExecutor("xxx-xxx")
                .syncExecutor(
                        actualizarTelefonoUseCase, new RequestCommand<>(command)
                ).orElseThrow();
        var evento = response.getDomainEvents();
        //Asserts
        TelefonoActualizado telefonoActualizadoUseCase = (TelefonoActualizado) evento.get(0);
        Assertions.assertEquals("sofka.domain.empleado.telefonoactualizado",telefonoActualizadoUseCase.type);
    }

    private List<DomainEvent> events(){
        return List.of(new EmpleadoCreado(
                new Nombre("Primer empleado"),
                new Edad(20),
                new Telefono("450202562"),
                new Direccion("Calle uramita"),
                new Cuenta(CuentaId.of("eee-eee"),new Email("correo@correito.com")),
                new Cargo(CargoId.of("sss-ss"),new Nombre("Prueba"),new TipoCargo("Cualquier carogo"))
        ));
    }

}