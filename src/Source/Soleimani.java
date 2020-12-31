package Source;

public class Soleimani extends Player implements Arabic {
    public Soleimani() {
        super("Solemani");
    }

    @Override
    public String beating(Player player) {
        return "Pestaggio";
    }

    @Override
    public String childSoldiers(Player player) {
        return "Bambini Soldato";
    }

    @Override
    public String toString() {
        return null;
    }
}
