package factura.values;
import co.com.sofka.domain.generic.ValueObject;

import java.util.Objects;

public class Precio implements ValueObject<Double> {


    private final Double value;

    public Precio(Double value){
        //Validaciones
        this.value = Objects.requireNonNull(value);
        if(this.value<0){
            throw new IllegalArgumentException("El precio no puede ser negativo");
        }

    }
    public Double value(){
        return value;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Precio precio = (Precio) o;
        return Objects.equals(value, precio.value);
    }

    @Override
    public int hashCode() {
        return Objects.hash(value);
    }
}