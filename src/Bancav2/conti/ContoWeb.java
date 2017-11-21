public class ContoWeb extends ContoCorrente {

    private String pw = "changeme";
    private boolean pwModificata = false;

    public ContoWeb(String cf, String iban) {
        super(cf, iban);
    }

    public boolean changePW(String newPW) {
        if(!pwModificata && !(newPW.equals(""))) {
            this.pw = newPW;
            this.pwModificata = true;
            return true;
        } else {
            return false;
        }
    }

    private boolean login(String pw) {
        return pwModificata && pw.equals(this.pw);
    }

    public boolean operazione(double amount, String pw) {
        return this.login(pw) && super.operazione(amount);
    }

    @Override
    public String toString() {
        return ("Conto WEB; CF: " + this.getCf() + ";  IBAN: " + this.getIban() + "; Saldo: " + this.getSaldo());
    }

}
