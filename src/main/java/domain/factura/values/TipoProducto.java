package domain.factura.values;

import co.com.sofka.domain.generic.ValueObject;

import java.util.Objects;

public class TipoProducto implements ValueObject<String> {

    private final String value;

    public TipoProducto(String value){
        this.value = Objects.requireNonNull(value);
        //Validaciones
        if(this.value.isBlank()){
            throw new IllegalArgumentException("El tipo de producto no puede estar vacia");
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
        TipoProducto that = (TipoProducto) o;
        return Objects.equals(value, that.value);
    }

    @Override
    public int hashCode() {
        return Objects.hash(value);
    }
}
