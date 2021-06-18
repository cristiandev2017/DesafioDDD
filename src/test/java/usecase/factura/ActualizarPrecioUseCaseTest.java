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
import domain.factura.commands.ActualizarPrecio;
import domain.factura.events.FacturaCreada;
import domain.factura.events.PrecioActualizado;
import domain.factura.values.*;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;

import java.util.Date;
import java.util.List;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

class ActualizarPrecioUseCaseTest {

    private ActualizarPrecioUseCase actualizarPrecioUseCase;

    @Mock
    private DomainEventRepository repository;

    @BeforeEach
    public void setup() {
        actualizarPrecioUseCase = new ActualizarPrecioUseCase();
        repository = mock(DomainEventRepository.class);
        actualizarPrecioUseCase.addRepository(repository);
    }

    @Test
    void actualizarPrecioHappyPath() {
        //Arrange
        var command = new ActualizarPrecio(
                FacturaId.of("fff-fff"),
                new Precio(500.000)
        );
        when(repository.getEventsBy("fff-fff")).thenReturn(events());

        //Act
        var response = UseCaseHandler.getInstance()
                .setIdentifyExecutor("xxx-xxx")
                .syncExecutor(
                        actualizarPrecioUseCase, new RequestCommand<>(command)
                ).orElseThrow();
        var evento = response.getDomainEvents();
        //Asserts
        PrecioActualizado precioActualizadoUseCase = (PrecioActualizado) evento.get(0);
        Assertions.assertEquals("sofka.domain.factura.precioactualizado", precioActualizadoUseCase.type);
    }


    private List<DomainEvent> events() {
        var fecha = new Date(1990, 06, 22);
        return List.of(new FacturaCreada(
                new Descripcion("Primera factura"),
                new Fecha(fecha),
                new Precio(500.000),
                new Pedido(PedidoId.of("ppp-ppp"), new Detalle("Esto es un detalle del pedido")),
                new Cliente(ClienteId.of("ccc-ccc"), new Nombre("El mejor cliente")),
                EmpleadoId.of("xxx-xxx")
        ));
    }

}