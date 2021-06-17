package factura.values;

import co.com.sofka.domain.generic.ValueObject;

import java.util.Objects;

public class Detalle implements ValueObject<String> {

    private final String value;

    public Detalle(String value){
        this.value = Objects.requireNonNull(value);
        if(this.value.isBlank()){
            throw new IllegalArgumentException("la descripcion no puede estar vacia");
        }

        if(this.value.length()<= 10){
            throw new IllegalArgumentException("Debes de tener minimo 10 caracteres");
        }
    }

    public String value(){
        return value;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Detalle detalle = (Detalle) o;
        return Objects.equals(value, detalle.value);
    }

    @Override
    public int hashCode() {
        return Objects.hash(value);
    }
}
