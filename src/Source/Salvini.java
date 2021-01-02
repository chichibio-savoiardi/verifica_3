package Source;

public class Salvini extends Player implements European {
    public Salvini() {
        super("Capitan Salvini", European.nameATK1, European.nameATK2);
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
