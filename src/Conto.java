public abstract class Conto implements IConto {

    private String cf;
    private String iban;
    private double saldo;

    public Conto(String cf, String iban) {
        this.cf = cf;
        this.iban = iban;
        this.saldo = 0;
    }

    public String getCf() {
        return cf;
    }

    public String getIban() {
        return iban;
    }

    public double getSaldo() {
        return saldo;
    }

    public boolean operazione(double amount) {
        if(amount > 0 || this.saldo >= Math.abs(amount)) {
            this.saldo += amount;
            return true;
        } else {
            return false;
        }
    }
}
