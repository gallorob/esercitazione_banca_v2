package Bancav2;

import Bancav2.Eccezioni.CFNotNull;
import Bancav2.Eccezioni.IBANNotFound;
import Bancav2.Eccezioni.MaxContiRaggiunto;
import Bancav2.conti.*;
import Bancav2.accountable.*;

import java.util.HashMap;
import java.util.Iterator;
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
        if(cf.equals("")) throw new CFNotNull();
        if(numContiAttivi < MAXCONTI) {
            String iban = radIban + nomeBanca + "00" + (numContiAttivi + 1);
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

        else throw new MaxContiRaggiunto();
    }

    public String detConto(String iban) {
        if(conti.get(iban) == null) throw new IBANNotFound();
        return conti.get(iban).toString();
    }

    public double saldoConto(String iban) {
        if(conti.get(iban) == null) throw new IBANNotFound();
        return conti.get(iban).getSaldo();
    }

    public boolean operazione(String iban, double amount) {
        if(conti.get(iban) == null) throw new IBANNotFound();
        Conto tmp = conti.get(iban);
        return !(tmp instanceof ContoWeb) && tmp.operazione(amount);
    }

    public boolean operazione(String iban, double amount, String pw) {
        if(conti.get(iban) == null) throw new IBANNotFound();
        Conto tmp = conti.get(iban);
        return tmp instanceof ContoWeb && ((ContoWeb) tmp).operazione(amount, pw);
    }

    public boolean changePW(String iban, String pw) {
        if(conti.get(iban) == null) throw new IBANNotFound();
        Conto tmp = conti.get(iban);
        return tmp instanceof ContoWeb && ((ContoWeb) tmp).changePW(pw);
    }

    public boolean addAccountable(String iban, TipoAccountable tipo, double amount) {
        Conto tmp = conti.get(iban);
        return tmp.addAccountable(tipo, amount);
    }

    public boolean saldoFineMese() {
        Iterator it = conti.entrySet().iterator();
        while (it.hasNext()) {
            Map.Entry pair = (Map.Entry)it.next();
            Conto c = (Conto)pair.getValue();
            c.opFineMese();
        }
        return true;
    }

}
