package Bancav2.Eccezioni;

public class MaxContiRaggiunto extends RuntimeException{

    public MaxContiRaggiunto() {
        super("Numero di conti massimo raggiunto.");
    }
}
