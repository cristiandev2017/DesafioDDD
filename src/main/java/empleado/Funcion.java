package empleado;

import co.com.sofka.domain.generic.Entity;
import empleado.values.Caracteristica;
import empleado.values.Descripcion;
import empleado.values.FuncionId;

public class Funcion extends Entity<FuncionId> {
    private Caracteristica caracteristica;
    private Descripcion descripcion;

    public Funcion(FuncionId entityId, Caracteristica caracteristica, Descripcion descripcion){
        super(entityId);
        this.caracteristica = caracteristica;
        this.descripcion = descripcion;
    }

    public Caracteristica caracteristica() {
        return caracteristica;
    }

    public Descripcion descripcion() {
        return descripcion;
    }
}
