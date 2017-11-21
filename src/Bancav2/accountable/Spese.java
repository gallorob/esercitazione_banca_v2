package Bancav2.accountable;

public class Spese extends Accountable{

    private double importo;

    public Spese(double importo) {
        this.tipo = TipoAccountable.ADDEBITO;
        this.importo = importo;
    }

    public double getImporto() {
        return this.importo;
    }

}
