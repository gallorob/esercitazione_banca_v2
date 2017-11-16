public class ContoWeb extends ContoCorrente {

    private String pw = "changeme";
    private boolean pwModificata = false;

    public ContoWeb(String cf, String iban) {
        super(cf, iban);
    }

    public boolean changePW(String newPW) {
        if(!pwModificata && newPW != "") {
            this.pw = newPW;
            this.pwModificata = true;
            return true;
        } else {
            return false;
        }
    }

    private boolean login(String pw) {
        if(pwModificata) {
            if (pw.equals(this.pw)) {
                return true;
            } else {
                return false;
            }
        }
        return false;
    }

    public boolean operazione(double amount, String pw) {
        if (this.login(pw)) {
            return super.operazione(amount);
        } else {
            return false;
        }
    }

    @Override
    public String toString() {
        return ("Conto WEB; CF: " + this.getCf() + ";  IBAN: " + this.getIban() + "; Saldo: " + this.getSaldo());
    }

}
