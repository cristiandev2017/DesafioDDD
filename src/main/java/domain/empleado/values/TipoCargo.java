package domain.empleado.values;

import co.com.sofka.domain.generic.ValueObject;

import java.util.Objects;

public class TipoCargo implements ValueObject<String> {

    private final String value;

    public TipoCargo(String value){
        this.value = Objects.requireNonNull(value);
        //Validaciones
        if(this.value.isBlank()){
            throw new IllegalArgumentException("El tipo de cargo no puede estar vacia");
        }
        if(this.value.length()<=8){
            throw new IllegalArgumentException("Debes de tener minimo 5 caracteres en el tipo");
        }
    }

    public String value(){return value;}

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        TipoCargo tipoCargo = (TipoCargo) o;
        return Objects.equals(value, tipoCargo.value);
    }

    @Override
    public int hashCode() {
        return Objects.hash(value);
    }
}
