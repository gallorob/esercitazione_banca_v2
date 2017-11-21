package Bancav2.accountable;

import Bancav2.IAccountable;

public abstract class Accountable implements IAccountable {

    protected TipoAccountable tipo;

    public TipoAccountable getTipo() {
        return tipo;
    }

    abstract public double getImporto();

}
