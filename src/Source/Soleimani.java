package Source;

public class Soleimani extends Player implements Arabic {
    public Soleimani() {
        super("Solemani", Arabic.nameATK1, Arabic.nameATK2);
    }

    @Override
    public String attacco1(Player player) {
        return "Pestaggio";
    }

    @Override
    public String attacco2(Player player) {
        return "Bambini Soldato";
    }

    @Override
    public String toString() {
        return super.getNome();
    }
}
