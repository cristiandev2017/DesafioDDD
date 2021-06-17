package empleado.events;

import co.com.sofka.domain.generic.DomainEvent;
import empleado.values.Caracteristica;
import empleado.values.Descripcion;
import empleado.values.FuncionId;

public class FuncionAgregada extends DomainEvent {
    private final FuncionId funcionId;
    private final Caracteristica caracteristica;
    private Descripcion descripcion;

    public FuncionAgregada(FuncionId funcionId, Caracteristica caracteristica, Descripcion descripcion){
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

    public Descripcion getDescripcion() {
        return descripcion;
    }
}
