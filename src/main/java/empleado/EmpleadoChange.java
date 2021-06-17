package empleado;

import co.com.sofka.domain.generic.EventChange;
import empleado.events.EmpleadoCreado;

public class EmpleadoChange extends EventChange {

    public EmpleadoChange(Empleado empleado){
        apply((EmpleadoCreado event)->{
           empleado.nombre = event.getNombre();
           empleado.edad = event.getEdad();
           empleado.telefono = event.getTelefono();
           empleado.cuentaId = event.getCuentaId();
           empleado.cargoId = event.getCargoId();
        });
    }

}
