package Bancav2.Eccezioni;

public class PWAlreadyChngd extends RuntimeException{

    public PWAlreadyChngd() {
        super("Password gia` modificata.");
    }
}
