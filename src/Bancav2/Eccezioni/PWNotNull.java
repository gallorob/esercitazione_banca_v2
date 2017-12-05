package Bancav2.Eccezioni;

public class PWNotNull extends RuntimeException {

    public PWNotNull() {
        super("Password non puo` essere vuota/nulla.");
    }

}
