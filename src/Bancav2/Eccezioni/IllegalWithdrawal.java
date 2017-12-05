package Bancav2.Eccezioni;

public class IllegalWithdrawal extends RuntimeException {

    public IllegalWithdrawal() {
        super("Eh, li volevi i 20 centesimi");
    }

}
