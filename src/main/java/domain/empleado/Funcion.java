package empleado;

import co.com.sofka.domain.generic.Entity;
import empleado.values.Caracteristica;
import empleado.values.Precio;
import empleado.values.FuncionId;

import java.util.Objects;

public class Funcion extends Entity<FuncionId> {
    private Caracteristica caracteristica;
    private Precio descripcion;

    public Funcion(FuncionId entityId, Caracteristica caracteristica, Precio descripcion){
        super(entityId);
        this.caracteristica = caracteristica;
        this.descripcion = descripcion;
    }

    public void actualizarCaracteristica(Caracteristica caracteristica){
        this.caracteristica = Objects.requireNonNull(caracteristica);
    }

    public void actualizarDescripcion(Precio descripcion){
        this.descripcion = Objects.requireNonNull(descripcion);
    }

    public Caracteristica caracteristica() {
        return caracteristica;
    }

    public Precio descripcion() {
        return descripcion;
    }
}
