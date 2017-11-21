package Bancav2.conti;

import Bancav2.accountable.*;

import java.util.ArrayList;

public abstract class Conto implements IConto {

    private String cf;
    private String iban;
    private double saldo;
    private TipoAccountable tipo;
    protected ArrayList<Accountable> flowFineMese = new ArrayList<>();

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

    public boolean addAccountable(TipoAccountable tipo, double amount) {
        switch (tipo) {
            case ADDEBITO:  this.flowFineMese.add(new Stipendio(amount));
                            break;
            case ACCREDITO: this.flowFineMese.add(new Spese(amount));
                            break;
            default:        return false;
        }
        return true;
    }

    public boolean opFineMese() {
        for(Accountable acc : flowFineMese) {
            if(acc.getTipo().equals(TipoAccountable.ACCREDITO)) {
                this.operazione(acc.getImporto());
            }
            else if(acc.getTipo().equals(TipoAccountable.ADDEBITO)) {
                this.operazione(- acc.getImporto());
            }
            else return false;
        }
        return true;
    }

}
