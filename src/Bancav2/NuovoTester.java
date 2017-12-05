package Bancav2;

import Bancav2.Eccezioni.*;
import Bancav2.conti.TipoConto;

public class NuovoTester {

    public static void main(String[] args) {

        Banca b = new Banca("UBI", 3);

        b.aggiungiConto("AAA", TipoConto.CORRENTE);
        b.aggiungiConto("BBB", TipoConto.WEB);
        b.aggiungiConto("CCC", TipoConto.DEPOSITO);

        try {
            b.operazione("IT00000UBI003",500);
            b.operazione("IT00000UBI003",-100);
        } catch (IllegalOperation e) {
            System.err.println(e.getMessage());
        }

        try {
            b.changePW("IT00000UBI002","");
        } catch (PWNotNull e) {
            System.err.println(e.getMessage());
        }

        try {
            b.aggiungiConto("",TipoConto.CORRENTE);
        } catch (CFNotNull e) {
            System.err.println(e.getMessage());
        }

        try {
            b.detConto("GANG");
        } catch (IBANNotFound e) {
            System.err.println(e.getMessage());
        }

        try {
            b.operazione("IT00000UBI001", -50);
        } catch (IllegalWithdrawal e) {
            System.err.println(e.getMessage());

        }

        try {
            b.operazione("IT00000UBI003", -50);
        } catch (IllegalWithdrawal | IllegalOperation  e) {
            System.err.println(e.getMessage());
        }

        b.changePW("IT00000UBI002", "nuovaPW");

        try {
            b.changePW("IT00000UBI002", "anotherPW");
        } catch (PWAlreadyChngd e) {
            System.err.println(e.getMessage());
        }

        try {
            b.aggiungiConto("DDD", TipoConto.CORRENTE);
        } catch (MaxContiRaggiunto e) {
            System.err.println(e.getMessage());
        }

    }
}
