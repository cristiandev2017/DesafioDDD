package empleado.events;

import co.com.sofka.domain.generic.DomainEvent;
import empleado.values.Caracteristica;
import empleado.values.Precio;
import empleado.values.FuncionId;

public class FuncionAgregada extends DomainEvent {
    private final FuncionId funcionId;
    private final Caracteristica caracteristica;
    private Precio descripcion;

    public FuncionAgregada(FuncionId funcionId, Caracteristica caracteristica, Precio descripcion){
        super("sofka.empleado.funcionagregada");
        this.funcionId = funcionId;
        this.caracteristica = caracteristica;
        this.descripcion = descripcion;
    }

    public FuncionId getFuncionId() {
        return funcionId;
    }

    public Caracteristica getCaracteristica() {
        return caracteristica;
    }

    public Precio getDescripcion() {
        return descripcion;
    }
}
