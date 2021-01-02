package Source;

public class Putin extends Player implements Slavic {
    public Putin() {
        super("Putin Putout", Slavic.nameATK1, Slavic.nameATK2);
    }

    @Override
    public String attacco1(Player player) {
        return "Invasione Russa";
    }

    @Override
    public String attacco2(Player player) {
        return "Vodka!";
    }

    @Override
    public String toString() {
        return super.getNome();
    }
}
