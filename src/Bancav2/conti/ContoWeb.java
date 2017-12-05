package Bancav2.conti;

import Bancav2.Eccezioni.PWAlreadyChngd;
import Bancav2.Eccezioni.PWNotNull;
import Bancav2.accountable.Accountable;
import Bancav2.accountable.TipoAccountable;

public class ContoWeb extends ContoCorrente {

    private String pw = "changeme";
    private boolean pwModificata = false;

    public ContoWeb(String cf, String iban) {
        super(cf, iban);
    }

    public boolean changePW(String newPW) {
        if(!pwModificata) {
            if(newPW.equals("")) throw new PWNotNull();
            this.pw = newPW;
            this.pwModificata = true;
            return true;
        } else {
            throw new PWAlreadyChngd();
        }
    }

    private boolean login(String pw) {
        return pwModificata && pw.equals(this.pw);
    }

    public boolean operazione(double amount, String pw) {
        return this.login(pw) && super.operazione(amount);
    }

    @Override
    public boolean operazione(double amount) {
        return false;
    }

    @Override
    public boolean opFineMese() {
        for(Accountable acc : flowFineMese) {
            if(acc.getTipo().equals(TipoAccountable.ACCREDITO)) {
                this.operazione(acc.getImporto(), this.pw);
            }
            else if(acc.getTipo().equals(TipoAccountable.ADDEBITO)) {
                this.operazione(- acc.getImporto(), this.pw);
            }
            else return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return ("Conto WEB; CF: " + this.getCf() + ";  IBAN: " + this.getIban() + "; Saldo: " + this.getSaldo());
    }

}
