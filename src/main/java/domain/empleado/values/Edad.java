package empleado.values;

import co.com.sofka.domain.generic.ValueObject;

import java.util.Objects;

public class Edad implements ValueObject<Integer> {
    private final Integer value;

    public Edad(Integer value){
        this.value = Objects.requireNonNull(value);
        //Validaciones
        if (this.value < 18 ){
            throw new IllegalArgumentException("La edad no puede ser menor a 18");
        }
    }
    public Integer value(){return value;}

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Edad edad = (Edad) o;
        return Objects.equals(value, edad.value);
    }

    @Override
    public int hashCode() {
        return Objects.hash(value);
    }
}
