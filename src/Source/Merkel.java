package Source;

public class Merkel extends Player implements European {
    public Merkel() {
        super("Merchel", European.nameATK1, European.nameATK2);
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
        return super.getNome();
    }
}
