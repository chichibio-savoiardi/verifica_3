package Source;

public class Salvini extends Player implements European {
    public Salvini() {
        super("Capitan Salvini");
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
        return nome;
    }
}
