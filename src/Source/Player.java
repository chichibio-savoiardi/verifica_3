package Source;

public abstract class Player {
    protected int puntiVita;
    protected int difesa;
    protected int stamina;

    public Player() {
        this.puntiVita = 100;
        this.difesa = 0;
        this.stamina = 100;
    }
}
