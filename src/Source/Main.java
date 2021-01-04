/*+-+-+*\
* Autore programma originale: Iuri Antico, Emanuele Parinetti
* Autore versione aggiornata: Iuri Antico
\*+-+-+*/

package Source;

import java.util.Scanner;

import JavaUtils.ArrayUtils;

public class Main {
    private static Client clt = new Client(2);

    public static void main(String[] args) {// TODO
        clt.printPlayers();
        clt.turn();
    }
}

/* +-+ \[T]/ +-+ */
class Client {
    private Scanner cin;
    private Player[] plr;
    private ArrayUtils arrayUtils;

    public Client(int nPlayers) {
        this.cin = new Scanner(System.in);
        arrayUtils = new ArrayUtils();
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
            String choice;
            do {
                menu(player);
                isDone();
                player.ripristina(player.getVitaMod(), player.getStmMod(), player.getDefMod());
                if (player.getStamina() > player.getConsumoATK()) {
                    System.out.println("Voui fare un'altra mossa? S/N?");
                    choice = cin.next();
                } else {
                    choice = "n";
                }
            } while (choice.equals("s") || choice.equals("S"));
        }
    }

    private void menu(Player player) {
        System.out
                .println("1 per attacco base" + "\n2 per " + player.getNomeATK1() + "\n3 per " + player.getNomeATK2());
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
            if (plr[choice] == null) {
                System.out.println("giocatore non valido: morto");
                targeter();
            }
            return plr[choice];
        } catch (Exception e) {
            System.out.println("Valore non valido in " + targeter().getClass());
            System.out.println(e.getCause());
            targeter();
        }
        return plr[choice];
    }

    public void printPlayers() {
        for (int i = 0; i < plr.length; i++) {
            if (plr[i] != null) {
                System.out.println(i + ": " + plr[i].getNome());
            }
        }
    }

    public void isDone() {
        for (int i = 0; i < plr.length; i++) {
            Player player = plr[i];
            if (player.getPuntiVita() <= 0) {
                System.out.println(player.getNome() + " e' morto");
                player = null;
            }
        }
        if (!(arrayUtils.findNotNull(plr) != -1)) {// cerca un Player vivo qualsiasi, se esiste esegue l'if
            if (arrayUtils.findNotNull(plr, arrayUtils.findNotNull(plr)) == -1) {// cerca un player vivo dopo il precedente, se non esiste esegue l'if
                Player player = plr[arrayUtils.findNotNull(plr)];
                System.out.println(player + "e' il vincitore!");
                System.exit(0);
            }
        }
    }
}
