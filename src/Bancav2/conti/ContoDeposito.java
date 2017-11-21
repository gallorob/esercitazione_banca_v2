package Bancav2.conti;

public class ContoDeposito extends ContoCorrente {

    public ContoDeposito(String cf, String iban) {
        super(cf, iban);
    }

    @Override
    public boolean operazione(double amount) {
        return amount >= 0 && super.operazione(amount);
    }

    @Override
    public String toString() {
        return ("Bancav2.conti.Conto Deposito; CF: " + this.getCf() + ";  IBAN: " + this.getIban() + "; Saldo: " + this.getSaldo());
    }

}
