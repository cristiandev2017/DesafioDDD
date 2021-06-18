package domain.empleado.values;

import co.com.sofka.domain.generic.Identity;

public class CargoId extends Identity {

    public CargoId(){

    }

    private CargoId(String id){
        super(id);
    }

    public static CargoId of(String id){
        return new CargoId(id);
    }
}
