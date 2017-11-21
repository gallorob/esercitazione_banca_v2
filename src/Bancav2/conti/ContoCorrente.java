package Bancav2.conti;

import Bancav2.accountable.TipoAccountable;

public class ContoCorrente extends Conto {

    public ContoCorrente(String cf, String iban) {
        super(cf, iban);
    }

    @Override
    public boolean operazione(double amount) {
        return super.operazione(amount);
    }

    @Override
    public String toString() {
        return ("Bancav2.conti.Conto Corrente; CF: " + this.getCf() + ";  IBAN: " + this.getIban() + "; Saldo: " + this.getSaldo());
    }
}