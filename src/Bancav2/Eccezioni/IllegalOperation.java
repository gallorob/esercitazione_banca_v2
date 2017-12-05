package Bancav2.Eccezioni;

public class IllegalOperation extends RuntimeException {

    public IllegalOperation() {
        super("Operazione illecita per il tipo di conto.");
    }

}
