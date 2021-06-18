package usecase.factura;

import co.com.sofka.business.generic.UseCaseHandler;
import co.com.sofka.business.repository.DomainEventRepository;
import co.com.sofka.business.support.RequestCommand;
import co.com.sofka.domain.generic.DomainEvent;
import domain.empleado.values.Descripcion;
import domain.empleado.values.EmpleadoId;
import domain.empleado.values.Nombre;
import domain.factura.Cliente;
import domain.factura.Pedido;
import domain.factura.commands.ActualizarFecha;
import domain.factura.events.FacturaCreada;
import domain.factura.events.FechaActualizada;
import domain.factura.values.*;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import java.util.Date;
import java.util.List;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;


class ActualizarFechaUseCaseTest {

    private ActualizarFechaUseCase actualizarFechaUseCase;

    @Mock
    private DomainEventRepository repository;

    @BeforeEach
    public void setup(){
        actualizarFechaUseCase = new ActualizarFechaUseCase();
        repository = mock(DomainEventRepository.class);
        actualizarFechaUseCase.addRepository(repository);
    }

    @Test
    void actualizarFechaHappyPath(){
        //Arrange
        var fecha = new Date(1990,06,22);
        var command = new ActualizarFecha(
                FacturaId.of("fff-fff"),
                new Fecha(fecha)
        );
        when(repository.getEventsBy("fff-fff")).thenReturn(events());

        //Act
        var response = UseCaseHandler.getInstance()
                .setIdentifyExecutor("fff-fff")
                .syncExecutor(
                        actualizarFechaUseCase, new RequestCommand<>(command)
                ).orElseThrow();
        var evento = response.getDomainEvents();
        //Asserts
        FechaActualizada fechaActualizadaUseCase = (FechaActualizada) evento.get(0);
        Assertions.assertEquals("sofka.domain.factura.fechactualizado",fechaActualizadaUseCase.type);
    }



    private List<DomainEvent> events(){
        var fecha = new Date(1990,06,22);
        return List.of(new FacturaCreada(
                new Descripcion("Primera factura"),
                new Fecha(fecha),
                new Precio(500.000),
                new Pedido(PedidoId.of("ppp-ppp"),new Detalle("Esto es un detalle del pedido")),
                new Cliente(ClienteId.of("ccc-ccc"),new Nombre("El mejor cliente")),
                EmpleadoId.of("xxx-xxx")

        ));
    }

}