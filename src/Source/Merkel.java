package Source;

public class Merkel extends Player implements European {
    public Merkel() {
        super("Merchel");
    }

    @Override
    public String jointOperation(Player player) {
        return "Operazione Congiunta";
    }

    @Override
    public String politicalReform(Player player) {
        return "Riforma Politca";
    }

    @Override
    public String toString() {
        return null;
    }
}
