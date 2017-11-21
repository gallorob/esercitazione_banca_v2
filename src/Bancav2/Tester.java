package Bancav2;

import Bancav2.accountable.TipoAccountable;
import Bancav2.conti.TipoConto;

public class Tester {

    public static void main(String[] args) {
        Banca b = new Banca("UBI", 5);

        b.aggiungiConto("AAA", TipoConto.CORRENTE);
        b.aggiungiConto("BBB", TipoConto.WEB);
        b.aggiungiConto("CCC", TipoConto.DEPOSITO);

        // Casi possibili
        System.out.println("\n----\nDettaglio conti:\n----");
        System.out.println(b.detConto("IT00000UBI001"));
        System.out.println(b.detConto("IT00000UBI002"));
        System.out.println(b.detConto("IT00000UBI003"));
        System.out.println("\n----\nSaldo conti:\n----");
        System.out.println(b.saldoConto("IT00000UBI001"));
        System.out.println(b.saldoConto("IT00000UBI002"));
        System.out.println(b.saldoConto("IT00000UBI003"));

        // Transazione su conto corrente
        System.out.println("\n----\nCONTO CORRENTE:\n----");

        System.out.println("\n[Transazione di +100:");
        if(b.operazione("IT00000UBI001",100)) {
            System.out.println("Transazione riuscita");
        } else System.out.println("Transazione fallita");
        System.out.println(b.saldoConto("IT00000UBI001"));

        System.out.println("\n[Transazione di -100:");
        if(b.operazione("IT00000UBI001",-50)) {
            System.out.println("Transazione riuscita");
        } else System.out.println("Transazione fallita");
        System.out.println(b.saldoConto("IT00000UBI001"));

        // Transazione su conto Web
        System.out.println("\n----\nCONTO WEB:\n----");

        System.out.println("\n[Transazione di +50; No password:");
        if(b.operazione("IT00000UBI002",50)) {
            System.out.println("Transazione riuscita");
        } else System.out.println("Transazione fallita");
        System.out.println(b.saldoConto("IT00000UBI002"));

        System.out.println("\n[Cambiamento password con password vuota:");
        if(b.changePW("IT00000UBI002", "")) {
            System.out.println("Password cambiata con successo");
        } else System.out.println("Cambiamento password fallito");

        System.out.println("\n[Cambiamento password con password valida:");
        if(b.changePW("IT00000UBI002", "NuovaPassword")) {
            System.out.println("Password cambiata con successo");
        } else System.out.println("Cambiamento password fallito");

        System.out.println("\n[Tentativo di seconda modifica password:");
        if(b.changePW("IT00000UBI002", "PasswordDiversa")) {
            System.out.println("Password cambiata con successo");
        } else System.out.println("Cambiamento password fallito");

        System.out.println("\n[Transazione di +50, password corretta:");
        if(b.operazione("IT00000UBI002",50, "NuovaPassword")) {
            System.out.println("Transazione riuscita");
        } else System.out.println("Transazione fallita");
        System.out.println(b.saldoConto("IT00000UBI002"));

        System.out.println("\n[Transazione di +50, password errata:");
        if(b.operazione("IT00000UBI002",50, "PasswordErrata")) {
            System.out.println("Transazione riuscita");
        } else System.out.println("Transazione fallita");
        System.out.println(b.saldoConto("IT00000UBI002"));

        System.out.println("\n[Transazione di -25, password corretta:");
        if(b.operazione("IT00000UBI002",-25, "NuovaPassword")) {
            System.out.println("Transazione riuscita");
        } else System.out.println("Transazione fallita");
        System.out.println(b.saldoConto("IT00000UBI002"));

        // Transazione su conto Deposito
        System.out.println("\n----\nCONTO DEPOSITO:\n----");

        System.out.println("\n[Transazione di -100:");
        if(b.operazione("IT00000UBI003",-100)) {
            System.out.println("Transazione riuscita");
        } else System.out.println("Transazione fallita");
        System.out.println(b.saldoConto("IT00000UBI003"));

        System.out.println("\n[Transazione di +100:");
        if(b.operazione("IT00000UBI003",100)) {
            System.out.println("Transazione riuscita");
        } else System.out.println("Transazione fallita");
        System.out.println(b.saldoConto("IT00000UBI003"));


        // Operazioni sugli accountable
        System.out.println("\n----\nACCOUNTABLES\n----\n");

        // Aggiunta accountables
        b.addAccountable("IT00000UBI001", TipoAccountable.ACCREDITO, 120);
        b.addAccountable("IT00000UBI001", TipoAccountable.ADDEBITO, 10);
        b.addAccountable("IT00000UBI002", TipoAccountable.ACCREDITO, 500);
        b.addAccountable("IT00000UBI002", TipoAccountable.ADDEBITO, 15);
        b.addAccountable("IT00000UBI003", TipoAccountable.ACCREDITO, 200);
        b.addAccountable("IT00000UBI003", TipoAccountable.ADDEBITO, 160);

        // Stampa prima della fine del mese
        System.out.println("\n----\nDettaglio conti:\n----");
        System.out.println(b.detConto("IT00000UBI001"));
        System.out.println(b.detConto("IT00000UBI002"));
        System.out.println(b.detConto("IT00000UBI003"));

        // Fine del mese
        if(b.saldoFineMese()) {
            System.out.println("\n[ESECUZIONE PROCESSI DI FINE MESE COMPIUTA]");
        } else System.out.println("\n[ESECUZIONE PROCESSI DI FINE MESI FALLITA]");

        // Stampa dopo la fine del mese
        System.out.println("\n----\nDettaglio conti:\n----");
        System.out.println(b.detConto("IT00000UBI001"));
        System.out.println(b.detConto("IT00000UBI002"));
        System.out.println(b.detConto("IT00000UBI003"));
    }

}
