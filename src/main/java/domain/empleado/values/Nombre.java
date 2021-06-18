package domain.empleado.values;

import co.com.sofka.domain.generic.ValueObject;

import java.util.Objects;

public class Nombre implements ValueObject<String> {

    private final String value;

    public Nombre(String value){
        this.value = Objects.requireNonNull(value);
        //Validaciones
        if(this.value.isBlank()){
            throw new IllegalArgumentException("El nombre no debe estar vacio");
        }
        if(this.value.length()<3){
            throw new IllegalArgumentException("Debes de tener minimo 3 caracteres en el nombre");
        }
    }
    @Override
    public String value(){return value;}


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Nombre nombre = (Nombre) o;
        return Objects.equals(value, nombre.value);
    }

    @Override
    public int hashCode() {
        return Objects.hash(value);
    }

}
