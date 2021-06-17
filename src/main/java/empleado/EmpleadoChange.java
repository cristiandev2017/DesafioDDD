package empleado;

import co.com.sofka.domain.generic.EventChange;
import empleado.events.CargoAsociado;
import empleado.events.CargoCreado;
import empleado.events.CuentaAsociada;
import empleado.events.EmpleadoCreado;

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

    }
}
