package Source;

public class Putin extends Player implements Slavic {
    public Putin() {
        super("Putin Putout");
    }

    @Override
    public String invasion(Player player) {
        return "Invasione Russa";
    }

    @Override
    public String vodka() {
        return "Vodka!";
    }

    @Override
    public String toString() {
        return nome;
    }
}
