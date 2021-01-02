package Source;

public class Merkel extends Player {
    public Merkel() {
        super("Merchel");
    }

    @Override
    public String attacco1(Player player) {
        return "Operazione Congiunta";
    }

    @Override
    public String attacco2(Player player) {
        return "Riforma Politca";
    }

    @Override
    public String toString() {
        return null;
    }
}
