package Source;

public abstract class Player implements Specials {
    protected String nome, nomeATK1, nomeATK2;
    protected int puntiVita;
    protected int difesa;
    protected int stamina;

    public Player(String nome, String nomeATK1, String nomeATK2) {
        this.nome = nome;
        this.nomeATK1 = nomeATK1;
        this.nomeATK2 = nomeATK2;
        this.puntiVita = 100;
        this.difesa = 5;
        this.stamina = 100;
    }

    public Player(String nome) {
        this.nome = nome;
        this.nomeATK1 = Specials.nameATK1;
        this.nomeATK2 = Specials.nameATK2;
        this.puntiVita = 100;
        this.difesa = 5;
        this.stamina = 100;
    }

    public String attacca(Player player) {
        int dmg = 15;
        int stm = 20;
        if (stamina < stm) return "Non hai abbastanza stamina";
        stamina -= stm;
        if (player.difesa > dmg) dmg = 0;
        else dmg -= player.difesa;
        player.puntiVita -= dmg;
        return player.nome + " e' stato attaccato con un attacco normale";
    }

    public String getNome() {
        return nome;
    }

    public int getPuntiVita() {
        return puntiVita;
    }

    @Override
    public abstract String toString();
}
