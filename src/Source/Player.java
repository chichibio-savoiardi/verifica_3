package Source;

public abstract class Player {
    protected String nome;
    protected int puntiVita;
    protected int difesa;
    protected int stamina;

    public Player(String nome) {
        this.nome = nome;
        this.puntiVita = 100;
        this.difesa = 5;
        this.stamina = 100;
    }

    public String attacca(Player player) {
        int dmg = 15;
        if (stamina < dmg) return "Non hai abbastanza stamina";
        stamina -= 20;
        if (player.difesa > dmg) dmg = 0;
        else dmg -= player.difesa;
        player.puntiVita -= dmg;
        return player.nome + " e' stato attaccato con un attacco normale";
    }

    @Override
    public abstract String toString();
}
