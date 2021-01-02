package Source;

public class Trump extends Player {
    public Trump() {
        super("Donaldo Trombetta");
    }

    @Override
    public String attacco1(Player player) {
        return "McNuke";
    }

    @Override
    public String attacco2(Player player) {
        return "Controllo Bordi";
    }

    @Override
    public String toString() {
        return nome;
    }
}
