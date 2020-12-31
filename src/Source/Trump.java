package Source;

public class Trump extends Player implements American {
    public Trump() {
        super("Donaldo Trombetta");
    }

    @Override
    public String mcNuke(Player player) {
        return "McNuke";
    }

    @Override
    public String borderControl(Player player) {
        return "Controllo Bordi";
    }

    @Override
    public String toString() {
        return nome;
    }
}
