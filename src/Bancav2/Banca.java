import Bancav2.conti.*;
import Bancav2.accountable.*;

import java.util.HashMap;
import java.util.Map;

public class Banca {

    private String radIban, nomeBanca;
    private final double MAXCONTI;
    private int numContiAttivi;

    private Map<String, Conto> conti = new HashMap<>();

    public Banca(String nomeBanca, double maxConti) {
        this.nomeBanca = nomeBanca;
        this.MAXCONTI = maxConti;
        this.numContiAttivi = 0;
        this.radIban = "IT00000";
    }

    public boolean aggiungiConto(String cf, TipoConto tipo) {
        if(numContiAttivi < MAXCONTI) {
            String iban = radIban + nomeBanca + "00" + (numContiAttivi+1);
            switch (tipo) {
                case CORRENTE:
                    conti.put(iban, new ContoCorrente(cf, iban));
                    break;
                case WEB:
                    conti.put(iban, new ContoWeb(cf, iban));
                    break;
                case DEPOSITO:
                    conti.put(iban, new ContoDeposito(cf, iban));
                    break;
                default:
                    return false;
            }
            numContiAttivi++;
            return true;
        }
        return false;
    }

    public String detConto(String iban) {
        return conti.get(iban).toString();
    }

    public double saldoConto(String iban) {
        return conti.get(iban).getSaldo();
    }

    public boolean operazione(String iban, double amount) {
        Conto tmp = conti.get(iban);
        return !(tmp instanceof ContoWeb) && tmp.operazione(amount);
    }

    public boolean operazione(String iban, double amount, String pw) {
        Conto tmp = conti.get(iban);
        return tmp instanceof ContoWeb && ((ContoWeb) tmp).operazione(amount, pw);
    }

    public boolean changePW(String iban, String pw) {
        Conto tmp = conti.get(iban);
        return tmp instanceof ContoWeb && ((ContoWeb) tmp).changePW(pw);
    }

}
