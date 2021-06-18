package usecase.empleado;

import co.com.sofka.business.generic.UseCaseHandler;
import co.com.sofka.business.repository.DomainEventRepository;
import co.com.sofka.business.support.RequestCommand;
import co.com.sofka.domain.generic.DomainEvent;
import domain.empleado.Cargo;
import domain.empleado.Cuenta;
import domain.empleado.commands.ActualizarEdad;
import domain.empleado.events.EdadActualizada;
import domain.empleado.events.EmpleadoCreado;
import domain.empleado.values.*;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

@RunWith(MockitoJUnitRunner.class)
class ActualizarEdadUseCaseTest {

    private ActualizarEdadUseCase actualizarEdadUseCase;

    @Mock
    private DomainEventRepository repository;

    @BeforeEach
    public void setup(){
        actualizarEdadUseCase = new ActualizarEdadUseCase();
        repository = mock(DomainEventRepository.class);
        actualizarEdadUseCase.addRepository(repository);
    }

    @Test
    void actualizarEdadHappyPath(){
        //Arrange
        var command = new ActualizarEdad(
                EmpleadoId.of("xxx-xxx"),
                new Edad(22)
        );
        when(repository.getEventsBy("xxx-xxx")).thenReturn(events());

        //Act
        var response = UseCaseHandler.getInstance()
                .setIdentifyExecutor("xxx-xxx")
                .syncExecutor(
                        actualizarEdadUseCase, new RequestCommand<>(command)
                ).orElseThrow();
        var evento = response.getDomainEvents();
        //Asserts
        EdadActualizada edadActualizadaUseCase = (EdadActualizada) evento.get(0);
        Assertions.assertEquals("sofka.domain.empleado.edadactualizada",edadActualizadaUseCase.type);
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