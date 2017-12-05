package Bancav2.accountable;

public abstract class Accountable implements IAccountable {

    protected TipoAccountable tipo;

    public TipoAccountable getTipo() {
        return tipo;
    }

    abstract public double getImporto();

}
