package Bancav2.accountable;

public class Stipendio extends Accountable{

    private double importo;

    public Stipendio(double importo) {
        this.tipo = TipoAccountable.ACCREDITO;
        this.importo = importo;
    }

    public double getImporto() {
        return this.importo;
    }

}
