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
        clt.isDone();
    }
}
/* +-+ \[T]/ +-+ */
class Client {
    private Scanner cin;
    private Player[] plr;

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
            System.out.println(player.getNome() + " e' il tuo turno!");
            menu(player);
        }
    }

    private void menu(Player player) {
        System.out.println(  "1 per Attacco normale STM: 20, DMG: 15" + 
                           "\n2 per " +  player.getNomeATK1() + "STM: " + player.getConsumoATK1() + ", DMG: " + player.getDannoATK1() + 
                           "\n3 per " +  player.getNomeATK2() + "STM: " + player.getConsumoATK2() + ", DMG: " + player.getDannoATK2());
    }

    public void isDone() {//todo
        StringBuilder strBuild = new StringBuilder();
        for (int i = 0; i < plr.length; i++) {
            Player player = plr[i];
            if (player.getPuntiVita() <= 0) {
                strBuild.append("90");
                strBuild.append(i);
                System.out.println(player.getNome() + " e' morto");
            }
        }
        if (strBuild.isEmpty()) {
            System.out.println("La partita e' finita");
            System.exit(Integer.parseInt(strBuild.toString()));
        } else {
            turn();
        }
    }
}
