/*+-+-+*\
* Autore programma originale: Iuri Antico, Emanuele Parinetti
* Autore versione aggiornata: Iuri Antico
\*+-+-+*/

package Source;

import java.util.Scanner;

import MyUtils.*;

public class Main {
    private static Client clt = new Client(2);

    public static void main(String[] args) {
        System.out.println("+-+-+-+-+");
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
            System.out.println("+-+-+-+-+");
            Player player = plr[i];
            String choice;
            do {
                System.out.println(player + "\ne' il tuo turno!");
                menu(player);
                isDone();
                if (player.getStamina() > player.getConsumoATK()) {
                    System.out.println("Voui fare un'altra mossa? S/N?");
                    choice = cin.next();
                } else {
                    System.out.println(player.getNome() + " Non hai abbastanza stamina per continuare il turno");
                    choice = "n";
                }
            } while (choice.equals("s") || choice.equals("S"));
            player.ripristina(player.getVitaMod(), player.getStmMod(), player.getDefMod());
            isDone();
        }
        isDone();
        turn();
    }

    private void menu(Player player) {
        isDone();
        Player target = player;
        System.out
                .println("1 per attacco base" + "\n2 per " + player.getNomeATK1() + "\n3 per " + player.getNomeATK2());
        switch (cin.nextInt()) {
            case 1 -> {
                target = targeter();
                System.out.println(player.attacca(target));
            }
            case 2 -> {
                target = targeter();
                System.out.println(player.attacco1(target));
            }
            case 3 -> {
                target = targeter();
                System.out.println(player.attacco2(target));
            }
            default -> menu(player);
        }
    }

    private Player targeter() {
        isDone();
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
            e.printStackTrace();
            targeter();
        }
        return plr[choice];
    }

    public void printPlayers() {
        for (int i = 0; i < plr.length; i++) {
            if (plr[i] != null) {
                System.out.println("-----");
                System.out.println(i + ": " + plr[i]);
            }
        }
        System.out.println("-----");
    }

    public void isDone() {
        for (int i = 0; i < plr.length; i++) {
            if (plr[i] != null) {
                if (plr[i].getPuntiVita() <= 0) {
                    System.out.println(plr[i].getNome() + " e' morto");
                    plr[i] = null;
                }
            }
        }
        Player alive = plr[arrayUtils.search.findNotNull(plr)];// cerca un Player vivo qualsiasi
        int aliveIndex = arrayUtils.search.findNotNull(plr);
        if (plr.length == 2) {
            if (plr[0] == null) {
                printWinner(alive);
            } else if (plr[1] == null) {
                printWinner(alive);
            }
        } else {
            try {
                if (arrayUtils.search.findNotNull(plr, aliveIndex) == -1) {// cerca un player vivo dopo il precedente, se non esiste esegue l'if
                    printWinner(alive);
                }
            } catch (NullPointerException e) {
                e.printStackTrace();
                printWinner(alive);
            }
        }
    }

    private void printWinner(Player alive) {
        System.out.println("+-+ \\[T]/ +-+");
        System.out.println(alive + "\ne' il vincitore!");
        System.exit(2);
    }
}
