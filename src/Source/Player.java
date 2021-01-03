package Source;

public abstract class Player implements Specials {
    private String nome, nomeATK1, nomeATK2;
    private int puntiVita, difesa, stamina;
    private final int consumoATK, consumoATK1, consumoATK2, dannoATK, dannoATK1, dannoATK2;

    public Player(String nome, String nomeATK1, String nomeATK2, int consumoATK1, int consumaATK2, int dannoATK1, int dannoATK2) {
        this.nome = nome;
        this.nomeATK1 = nomeATK1;
        this.nomeATK2 = nomeATK2;
        this.consumoATK1 = consumoATK1;
        this.consumoATK2 = consumaATK2;
        this.dannoATK = 15;
        this.dannoATK1 = dannoATK1;
        this.dannoATK2 = dannoATK2;
        this.consumoATK = 20;
        this.puntiVita = 100;
        this.difesa = 5;
        this.stamina = 100;
    }

    public Player(String nome, String nomeATK1, String nomeATK2) {
        this.nome = nome;
        this.nomeATK1 = nomeATK1;
        this.nomeATK2 = nomeATK2;
        this.consumoATK = 20;
        this.consumoATK1 = 40;
        this.consumoATK2 = 60;
        this.dannoATK = 15;
        this.dannoATK1 = 40;
        this.dannoATK2 = 60;
        this.puntiVita = 100;
        this.difesa = 5;
        this.stamina = 100;
    }

    public Player(String nome) {
        this.nome = nome;
        this.nomeATK1 = Specials.nameATK1;
        this.nomeATK2 = Specials.nameATK2;
        this.consumoATK = 20;
        this.consumoATK1 = 40;
        this.consumoATK2 = 60;
        this.dannoATK = 15;
        this.dannoATK1 = 40;
        this.dannoATK2 = 60;
        this.puntiVita = 100;
        this.difesa = 5;
        this.stamina = 100;
    }

    public String attacca(Player player) {
        int dmg = dannoATK;
        int stm = consumoATK;
        if (stamina < stm)
            return "Non hai abbastanza stamina";
        stamina -= stm;
        if (player.difesa > dmg)
            dmg = 0;
        else
            dmg -= player.difesa;
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

    public int getConsumoATK() {
        return consumoATK;
    }

    public int getConsumoATK1() {
        return consumoATK1;
    }

    public int getConsumoATK2() {
        return consumoATK2;
    }

    public int getDannoATK1() {
        return dannoATK1;
    }

    public int getDannoATK2() {
        return dannoATK2;
    }

    @Override
    public abstract String toString();
}
