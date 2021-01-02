/*+-+-+*\
* Autore programma originale: Iuri Antico, Emanuele Parinetti
* Autore versione aggiornata: Iuri Antico
\*+-+-+*/

package Source;

import java.util.Scanner;

public class Main {
    private static Scanner in = new Scanner(System.in);
    private static Client clt = new Client(2);

    public static void main(String[] args) {//todo
        clt.turn();
    }
}
/* +-+ \[T]/ +-+ */
class Client {
    private final Scanner cin;
    protected final Player[] plr;

    public Client(int nPlayers) {
        this.cin = new Scanner(System.in);
        this.plr = new Player[nPlayers];
        initPlayers();
    }

    private void initPlayers() {
        for (int i = 0; i < plr.length; i++) {
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
                case 0 -> plr[i] = new Biden();
                case 1 -> plr[i] = new Merkel();
                case 2 -> plr[i] = new Putin();
                case 3 -> plr[i] = new Salvini();
                case 4 -> plr[i] = new Soleimani();
                case 5 -> plr[i] = new Trump();
                default -> initPlayers();
            }
        }
    }

    public void turn() {//todo
        for (int i = 0; i < plr.length; i++) {
            Player player = plr[i];
            player = new Biden();
        }
        isDone();
        turn();
    }

    public void isDone() {//todo
        StringBuilder strBuild = new StringBuilder("90");
        for (int i = 0; i < plr.length; i++) {
            Player player = plr[i];
            if (player.getPuntiVita() <= 0) {
                System.out.println(player.getNome() + " e' morto, la partita e' finita");
                strBuild.append(i).append("90");
            }
        }
        System.exit(Integer.parseInt(strBuild.toString()));
    }
}
