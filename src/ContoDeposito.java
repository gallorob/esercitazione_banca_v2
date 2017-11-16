public class ContoDeposito extends ContoCorrente {

    public ContoDeposito(String cf, String iban) {
        super(cf, iban);
    }

    @Override
    public boolean operazione(double amount) {
        if(amount >= 0) {
            return super.operazione(amount);
        } else {
            return false;
        }
    }

    @Override
    public String toString() {
        return ("Conto Deposito; CF: " + this.getCf() + ";  IBAN: " + this.getIban() + "; Saldo: " + this.getSaldo());
    }

}
