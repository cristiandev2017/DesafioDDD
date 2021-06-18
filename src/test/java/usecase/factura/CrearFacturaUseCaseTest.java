package usecase.factura;

import co.com.sofka.business.generic.UseCaseHandler;
import co.com.sofka.business.support.RequestCommand;
import domain.empleado.values.*;
import domain.factura.Cliente;
import domain.factura.Pedido;
import domain.factura.commands.CrearFactura;
import domain.factura.events.FacturaCreada;
import domain.factura.values.*;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import java.util.Date;

import static org.junit.jupiter.api.Assertions.*;

class CrearFacturaUseCaseTest {

    //Se crea el objeto que vamos a testear
    private CrearFacturaUseCase crearFacturaUseCase;

    //Construyame ese objeto
    @BeforeEach
    public void setup(){
        crearFacturaUseCase = new CrearFacturaUseCase();
    }


    @Test
        //Caso feliz
    void crearFacturaHappyPath(){
        //Arrange
        var command = new CrearFactura(
                FacturaId.of("fff-fff"),
                new Descripcion("Primera factura"),
                new Fecha(new Date()),
                new Precio(500.000),
                new Pedido(PedidoId.of("ppp-ppp"),new Detalle("Esto es un detalle del pedido")),
                new Cliente(ClienteId.of("ccc-ccc"),new Nombre("El mejor cliente")),
                EmpleadoId.of("xxx-xxx")

        );

        //Act Respuesta
        var response = UseCaseHandler.getInstance().syncExecutor(
                crearFacturaUseCase, new RequestCommand<>(command)
        ).orElseThrow();

        var events=response.getDomainEvents();

        //Asserts
        FacturaCreada facturaCreada = (FacturaCreada) events.get(0);
        Assertions.assertEquals("Primera factura",facturaCreada.getDescripcion().value());
    }


}