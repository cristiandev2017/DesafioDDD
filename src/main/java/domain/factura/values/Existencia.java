package factura.values;

import co.com.sofka.domain.generic.ValueObject;

import java.util.Objects;

public class Existencia implements ValueObject<Integer> {
    private final Integer value;

    public Existencia(Integer value){
        this.value = Objects.requireNonNull(value);
        //Se espera definir como validar si son numeros decimales porque si puede que no hayan existencias al ser integer ya valido que no me ingresen decimales
        if (this.value <= 0 ){
            throw new IllegalArgumentException("Debe tener valores positivos en la existencia");
        }
    }

    public Integer value(){
        return value;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Existencia that = (Existencia) o;
        return Objects.equals(value, that.value);
    }

    @Override
    public int hashCode() {
        return Objects.hash(value);
    }
}
