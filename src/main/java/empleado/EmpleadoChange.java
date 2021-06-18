package empleado;

import co.com.sofka.domain.generic.EventChange;
import empleado.events.*;

public class EmpleadoChange extends EventChange {

    public EmpleadoChange(Empleado empleado){
        //Crear empleado
        apply((EmpleadoCreado event)->{
           empleado.nombre = event.getNombre();
           empleado.edad = event.getEdad();
           empleado.telefono = event.getTelefono();
           empleado.cuenta = event.getCuenta();
           empleado.cargo = event.getCargo();
        });

        //Asociar Cargo
        apply((CargoAsociado event)->{
           empleado.cargo = event.getCargo();
        });

        //Crear cargo
        apply((CargoCreado event)->{
            empleado.cargo = new Cargo(event.getCargoId(),event.getNombre(),event.getTipoCargo());
        });

        //Asociar Cuenta
        apply((CuentaAsociada event)->{
            empleado.cuenta = event.getCuenta();
        });

        //Crear cuenta
        apply((CuentaCreada event)->{
            empleado.cuenta = new Cuenta(event.getCuentaId(),event.getEmail());
        });

        //Descripcion funcion actualizada
        apply((DescripcionFuncionActualizada event) -> {
            var funcion = empleado.getFuncionPorId(event.getFuncionId())
                    .orElseThrow(() -> new IllegalArgumentException("No se encuenta la funcion del empleado"));
            funcion.actualizarDescripcion(event.getDescripcion());
        });

        //Caracteristica funcion actualizada
        apply((CaracteristicaFuncionActualizado event) -> {
            var funcion = empleado.getFuncionPorId(event.getFuncionId())
                    .orElseThrow(() -> new IllegalArgumentException("No se encuenta la funcion del empleado"));
            funcion.actualizarCaracteristica(event.getCaracteristica());
        });

        //Actualizar Edad
        apply((EdadActualizada event)->{
           empleado.edad = event.getEdad();
        });

        //Actualizar Nombre
        apply((NombreActualizado event)->{
            empleado.nombre = event.getNombre();
        });

        //Actualizar Telefono
        apply((TelefonoActualizado event)->{
            empleado.telefono = event.getTelefono();
        });

        //Agregar funcion
        apply((FuncionAgregada event) -> {
            empleado.funciones.add(new Funcion(
                    event.getFuncionId(),
                    event.getCaracteristica(),
                    event.getDescripcion()
            ));
        });
    }
}
