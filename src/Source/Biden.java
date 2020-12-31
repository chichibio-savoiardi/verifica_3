package Source;

public class Biden extends Player implements American{
    public Biden() {
        super("Giovanni Bidone");
    }

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
