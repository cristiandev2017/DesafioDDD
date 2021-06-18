package usecase.empleado;

import co.com.sofka.business.generic.UseCaseHandler;
import co.com.sofka.business.support.RequestCommand;
import domain.empleado.Cargo;
import domain.empleado.Cuenta;
import domain.empleado.commands.CrearEmpleado;
import domain.empleado.events.EmpleadoCreado;
import domain.empleado.values.*;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class CrearEmpleadoUseCaseTest {

    //Se crea el objeto que vamos a testear
    private CrearEmpleadoUseCase crearEmpleadoUseCase;

    //Construyame ese objeto
    @BeforeEach
    public void setup(){
        crearEmpleadoUseCase = new CrearEmpleadoUseCase();
    }


    @Test
    //Caso feliz
    void crearEmpleadoHappyPath(){
        //Arrange
        var command = new CrearEmpleado(
                EmpleadoId.of("xxx-xxx"),
                new Nombre("Primer empleado"),
                new Edad(19),
                new Telefono("45020203"),
                new Direccion("Calle uramita"),
                new Cuenta(CuentaId.of("eee-eee"),new Email("correo@correito.com")),
                new Cargo(CargoId.of("sss-ss"),new Nombre("Prueba"),new TipoCargo("Cualquier carogo"))
        );

        //Act Respuesta
        var response =UseCaseHandler.getInstance().syncExecutor(
                crearEmpleadoUseCase, new RequestCommand<>(command)
        ).orElseThrow();

        var events=response.getDomainEvents();

        //Asserts
        EmpleadoCreado empleadoCreado = (EmpleadoCreado) events.get(0);
        Assertions.assertEquals("Primer empleado",empleadoCreado.getNombre().value());
        Assertions.assertEquals(19,empleadoCreado.getEdad().value());
        Assertions.assertEquals("45020203",empleadoCreado.getTelefono().value());
        Assertions.assertEquals("Calle uramita",empleadoCreado.getDireccion().value());

    }

    @Test
    //Caso Triste
    void crearEmpleadoSadPath(){
        //Arrange
        var command = new CrearEmpleado(
                EmpleadoId.of("xxx-xxx"),
                new Nombre("Primer empleado"),
                new Edad(10),
                new Telefono("45020"),
                new Direccion("Calle uramita"),
                new Cuenta(CuentaId.of("eee-eee"),new Email("correo@correito.com")),
                new Cargo(CargoId.of("sss-ss"),new Nombre("Prueba"),new TipoCargo("Cualquier carogo"))
        );

        //Act Respuesta
        var response =UseCaseHandler.getInstance().syncExecutor(
                crearEmpleadoUseCase, new RequestCommand<>(command)
        ).orElseThrow();

        var events=response.getDomainEvents();

        //Asserts
        EmpleadoCreado empleadoCreado = (EmpleadoCreado) events.get(0);
        Assertions.assertEquals("Primer empleado",empleadoCreado.getNombre().value());
        Assertions.assertEquals(10,empleadoCreado.getEdad().value());
        Assertions.assertEquals("45020",empleadoCreado.getTelefono().value());
        Assertions.assertEquals("Calle uramita",empleadoCreado.getDireccion().value());

    }

}