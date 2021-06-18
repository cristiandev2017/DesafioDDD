package domain.empleado.values;

import co.com.sofka.domain.generic.ValueObject;

import java.util.Objects;

public class Email implements ValueObject<String> {

    private final String value;

    public Email(String value){
        //Validaciones
        this.value = Objects.requireNonNull(value);
        if(this.value.isBlank()){
            throw new IllegalArgumentException("El email no puede estar vacio");
        }

        if(!this.value.matches("^[_A-Za-z0-9-\\+]+(\\.[_A-Za-z0-9-]+)*@[A-Za-z0-9-]+(\\.[A-Za-z0-9]+)*(\\.[A-Za-z]{2,})$")){
            throw new IllegalArgumentException("Email no valido");
        }
    }

    public String value(){
        return value;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Email email = (Email) o;
        return Objects.equals(value, email.value);
    }

    @Override
    public int hashCode() {
        return Objects.hash(value);
    }
}
