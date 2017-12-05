package Bancav2.Eccezioni;

public class CFNotNull extends RuntimeException {

    public CFNotNull() {
        super("Il Codice Fiscale non puo` essere vuoto.");
    }

}
