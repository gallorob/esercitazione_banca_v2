package Bancav2.conti;

import Bancav2.Eccezioni.IllegalOperation;

public class ContoDeposito extends ContoCorrente {

    public ContoDeposito(String cf, String iban) {
        super(cf, iban);
    }

    @Override
    public boolean operazione(double amount) {
        if(amount < 0) {
            throw new IllegalOperation();
        }
        else return super.operazione(amount);
    }

    @Override
    public String toString() {
        return ("Conto Deposito; CF: " + this.getCf() + ";  IBAN: " + this.getIban() + "; Saldo: " + this.getSaldo());
    }

}
