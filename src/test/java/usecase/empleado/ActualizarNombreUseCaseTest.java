package usecase.empleado;


import co.com.sofka.business.generic.UseCaseHandler;
import co.com.sofka.business.repository.DomainEventRepository;
import co.com.sofka.business.support.RequestCommand;
import co.com.sofka.domain.generic.DomainEvent;
import domain.empleado.Cargo;
import domain.empleado.Cuenta;
import domain.empleado.commands.ActualizarNombre;
import domain.empleado.events.EmpleadoCreado;
import domain.empleado.events.NombreActualizado;
import domain.empleado.values.*;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;

import java.util.List;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

import static org.junit.jupiter.api.Assertions.*;

@RunWith(MockitoJUnitRunner.class)
class ActualizarNombreUseCaseTest {

    private ActualizarNombreUseCase actualizarNombreUseCase;

    @Mock
    private DomainEventRepository repository;

    @BeforeEach
    public void setup(){
        actualizarNombreUseCase = new ActualizarNombreUseCase();
        repository = mock(DomainEventRepository.class);
        actualizarNombreUseCase.addRepository(repository);
    }

    @Test
    void actualizarNombreHappyPath(){
        //Arrange
        var command = new ActualizarNombre(
                EmpleadoId.of("xxx-xxx"),
                new Nombre("Cristian Camilo")
        );
        when(repository.getEventsBy("xxx-xxx")).thenReturn(events());

        //Act
        var response =UseCaseHandler.getInstance()
                .setIdentifyExecutor("xxx-xxx")
                .syncExecutor(
                actualizarNombreUseCase, new RequestCommand<>(command)
        ).orElseThrow();
        //assert
        var evento = (NombreActualizado)response.getDomainEvents().get(0);
        Assertions.assertEquals("Cristian Camilo",evento.getNombre().value());

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