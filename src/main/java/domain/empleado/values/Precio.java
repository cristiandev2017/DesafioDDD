package empleado.values;

import co.com.sofka.domain.generic.ValueObject;

import java.util.Objects;

public class Precio implements ValueObject<String> {
    private final String value;

    public Precio(String value){
        this.value = Objects.requireNonNull(value);
        //Validaciones
        if(this.value.isBlank()){
            throw new IllegalArgumentException("La descripcion no puede estar vacia");
        }
        if(this.value.length()<=8){
            throw new IllegalArgumentException("Debes de tener minimo 8 caracteres en la descripción");
        }
    }

    public String value(){
        return value;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Precio that = (Precio) o;
        return Objects.equals(value, that.value);
    }

    @Override
    public int hashCode() {
        return Objects.hash(value);
    }
}
