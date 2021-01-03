/*+-+-+*\
* Autore programma originale: Iuri Antico, Emanuele Parinetti
* Autore versione aggiornata: Iuri Antico
\*+-+-+*/

package Source;

import java.util.Scanner;

public class Main {
    private static Client clt = new Client(2);

    public static void main(String[] args) {// TODO
        clt.printPlayers();
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
                    1 per Trump
                    2 per Merkel
                    3 per Salvini
                    4 per Soleimani
                    5 per Putin""");
            switch (cin.nextInt()) {
                case 0 -> plr[i] = new Biden();
                case 1 -> plr[i] = new Trump();
                case 2 -> plr[i] = new Merkel();
                case 3 -> plr[i] = new Salvini();
                case 4 -> plr[i] = new Soleimani();
                case 5 -> plr[i] = new Putin();
                default -> initPlayers();
            }
        }
    }

    public void turn() {
        for (int i = 0; i < plr.length; i++) {
            Player player = plr[i];
            System.out.println(player + "e' il tuo turno!");
            menu(player);
            player.ripristina(player.getVitaMod(), player.getStmMod(), player.getDefMod());
        }
    }

    private void menu(Player player) {
        System.out.println("1 per attacco base" + "\n2 per " + player.getNomeATK1() + "\n3 per " + player.getNomeATK2());
        switch (cin.nextInt()) {
            case 1 -> {
                player.attacca(targeter());
            }
            case 2 -> {
                player.attacco1(targeter());
            }
            case 3 -> {
                player.attacco2(targeter());
            }
            default -> menu(player);
        }
    }

    private Player targeter() {
        printPlayers();
        System.out.println("Scegli il giocatore da bersagliare");
        int choice = cin.nextInt();
        try {
            if (plr[choice].getPuntiVita() <= 0) {
                System.out.println("giocatore non valido: morto");
                targeter();
            }
            return plr[choice];
        } catch (Exception e) {
            System.out.println("Valore non valido in " + targeter().getClass());
            targeter();
        }
        return plr[choice];
    }

    public void printPlayers() {
        for (int i = 0; i < plr.length; i++) {
            if (plr[i].getPuntiVita() > 0) {
                System.out.println(i + ": " + plr[i].getNome());
            }
        }
    }

    public void isDone() {
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
