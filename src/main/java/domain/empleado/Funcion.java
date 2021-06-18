package domain.empleado;

import co.com.sofka.domain.generic.Entity;
import domain.empleado.values.Caracteristica;
import domain.empleado.values.Descripcion;
import domain.empleado.values.FuncionId;

import java.util.Objects;

public class Funcion extends Entity<FuncionId> {
    private Caracteristica caracteristica;
    private Descripcion descripcion;

    public Funcion(FuncionId entityId, Caracteristica caracteristica, Descripcion descripcion){
        super(entityId);
        this.caracteristica = caracteristica;
        this.descripcion = descripcion;
    }

    public void actualizarCaracteristica(Caracteristica caracteristica){
        this.caracteristica = Objects.requireNonNull(caracteristica);
    }

    public void actualizarDescripcion(Descripcion descripcion){
        this.descripcion = Objects.requireNonNull(descripcion);
    }

    public Caracteristica caracteristica() {
        return caracteristica;
    }

    public Descripcion descripcion() {
        return descripcion;
    }
}
