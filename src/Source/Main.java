/*+-+-+*\
* Autore programma originale: Iuri Antico, Emanuele Parinetti
* Autore versione aggiornata: Iuri Antico
\*+-+-+*/

package Source;

import java.util.*;
import java.lang.*;

public class Main {
    private static Scanner in = new Scanner(System.in);
    private static Client client = new Client(2);

    public static void main(String[] args) {
        //todo
    }
}
//+-+-+
class Client {
    private Scanner cin;
    private Player[] pl;

    public Client(int nPlayers) {
        this.cin = new Scanner(System.in);
        this.pl = new Player[nPlayers];
        initPlayers();
    }

    private void initPlayers() {
        for (int i = 0; i < pl.length; i++) {
            System.out.println("Giocatore " + i + " scegli il tuo personaggio");
            System.out.println("""
                    0 per Biden
                    1 per Merkel
                    2 per Putin
                    3 per Salvini
                    4 per Soleimani
                    5 per Trump""");
            int choice = cin.nextInt();
            switch (choice) {
                case 0 -> pl[i] = new Biden();
                case 1 -> pl[i] = new Merkel();
                case 2 -> pl[i] = new Putin();
                case 3 -> pl[i] = new Salvini();
                case 4 -> pl[i] = new Soleimani();
                case 5 -> pl[i] = new Trump();
            }
        }
    }
}
