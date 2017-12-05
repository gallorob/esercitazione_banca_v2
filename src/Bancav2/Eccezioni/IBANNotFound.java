package Bancav2.Eccezioni;

public class IBANNotFound extends RuntimeException{

    public IBANNotFound() {
        super("IBAN inserito non trovato.");
    }

}
