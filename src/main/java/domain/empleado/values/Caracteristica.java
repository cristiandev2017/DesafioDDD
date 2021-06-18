package empleado.values;

import co.com.sofka.domain.generic.ValueObject;

import java.util.Objects;

public class Caracteristica implements ValueObject<String> {
    private final String value;

    public Caracteristica(String value){
        this.value = Objects.requireNonNull(value);
        //Validaciones
        if(this.value.isBlank()){
            throw new IllegalArgumentException("La caracteristica no puede estar vacia");
        }
        if(this.value.length()<5){
            throw new IllegalArgumentException("Debes de tener minimo 8 caracteres en la caracteristica");
        }
    }

    public String value(){
        return value;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Caracteristica that = (Caracteristica) o;
        return Objects.equals(value, that.value);
    }

    @Override
    public int hashCode() {
        return Objects.hash(value);
    }
}
