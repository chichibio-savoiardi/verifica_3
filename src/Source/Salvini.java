package Source;

public class Salvini extends Player {
    public Salvini() {
        super("Capitan Salvini");
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
        return nome;
    }
}
