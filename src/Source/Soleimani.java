package Source;

public class Soleimani extends Player {
    public Soleimani() {
        super("Solemani");
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
        return null;
    }
}
