package Source;

public abstract class Player implements Specials {
    private String nome, nomeATK1, nomeATK2;
    private int puntiVita;
    private int difesa;
    private int stamina;

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

    public String getNomeATK1() {
        return nomeATK1;
    }

    public String getNomeATK2() {
        return nomeATK2;
    }

    public int getDifesa() {
        return difesa;
    }

    public int getStamina() {
        return stamina;
    }

    @Override
    public abstract String toString();
}
