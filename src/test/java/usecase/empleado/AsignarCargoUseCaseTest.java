package usecase.empleado;

import co.com.sofka.business.generic.UseCaseHandler;
import co.com.sofka.business.repository.DomainEventRepository;
import co.com.sofka.business.support.RequestCommand;
import co.com.sofka.domain.generic.DomainEvent;
import domain.empleado.Cargo;
import domain.empleado.Cuenta;
import domain.empleado.Empleado;
import domain.empleado.commands.AsociarCargo;
import domain.empleado.events.CargoAsociado;
import domain.empleado.events.EmpleadoCreado;
import domain.empleado.values.*;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

import static org.junit.jupiter.api.Assertions.*;

class AsignarCargoUseCaseTest {

    private AsignarCargoUseCase asignarCargoUseCase;
    private DomainEventRepository repository;

    @BeforeEach
    public void setUp(){
        asignarCargoUseCase = new AsignarCargoUseCase();
        repository= mock(DomainEventRepository.class);
        asignarCargoUseCase.addRepository(repository);
    }

    @Test
    void AsignarCargoHappyPath(){
        //arrange
        var command = new AsociarCargo(EmpleadoId.of("12"), new Cargo(CargoId.of("sss-ss"),new Nombre("Prueba"),new TipoCargo("Cualquier carogo")));
        when(repository.getEventsBy("12")).thenReturn(events());

        //act
        var response = UseCaseHandler.getInstance()
                .setIdentifyExecutor("12")
                .syncExecutor(asignarCargoUseCase,new RequestCommand<>(command))
                .orElseThrow();

        var events= response.getDomainEvents();

        //asserts
        CargoAsociado asignarCargoUseCase = (CargoAsociado) events.get(0);
        Assertions.assertEquals("sofka.empleado.cargoasociado",asignarCargoUseCase.type);
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