package Source;

public abstract class Player implements Specials {
    private String nome, nomeATK1, nomeATK2;
    private int puntiVita, difesa, stamina, vitaMod, defMod, stmMod;
    private final int consumoATK, consumoATK1, consumoATK2, dannoATK, dannoATK1, dannoATK2;

    public Player(String nome, String nomeATK1, String nomeATK2, int consumoATK1, int consumaATK2, int dannoATK1,
            int dannoATK2) {
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
        this.difesa = 0;
        this.stamina = 100;
        this.vitaMod = 0;
        this.defMod = 0;
        this.stmMod = 0;
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
        this.difesa = 0;
        this.stamina = 100;
        this.vitaMod = 0;
        this.defMod = 0;
        this.stmMod = 0;
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
        this.difesa = 0;
        this.stamina = 100;
        this.vitaMod = 0;
        this.defMod = 0;
        this.stmMod = 0;
    }

    public String attacca(Player target) {// la funzione di attacco base, tutti gli altri attacchi sono una copia modificata di questa funzione
        StringBuilder msg = new StringBuilder(target.getNome());
        int dmg = dannoATK, stm = consumoATK;
        if (stamina < stm)// controlla la stamina
            return "Non hai abbastanza stamina";
        if (target.getDifesa() >= dmg) {// la difesa agisce come attenuatore del danno
            msg.append(" è stato attaccato ma non ha ricevuto danno");
            dmg = 0;
        } else {
            dmg -= target.getDifesa();
            msg.append(" è stato attaccato con un attacco normale per danni " + dmg);
        }
        stamina -= stm;
        target.setPuntiVita(target.getPuntiVita() - dmg);// toglie la vita all'avversario
        return msg.toString();
    }
// alla fine di ogni turno vengono ripristinate di un po i valori del personaggio e vengono resettate le variabili di buff/debuff
    public void ripristina(int modVita, int modSTM, int modDEF) {
        puntiVita += 5 + modVita;
        stamina += 50 + modSTM;
        difesa += modDEF;
        this.vitaMod = 0;
        this.defMod = 0;
        this.stmMod = 0;
    }

    public void buffDefMod(int buff) {// metodi usati in ripristina per aumentare statistiche del giocatore
        defMod += buff;
    }

    public void buffVitaMod(int buff) {
        vitaMod += buff;
    }

    public void buffStmMod(int buff) {
        stmMod += buff;
    }
    
    @Override
    public abstract String toString();

// getter-setter

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

    public int getDannoATK() {
        return dannoATK;
    }

    public void setPuntiVita(int puntiVita) {
        this.puntiVita = puntiVita;
    }

    public void setDifesa(int difesa) {
        this.difesa = difesa;
    }

    public void setStamina(int stamina) {
        this.stamina = stamina;
    }

    public int getVitaMod() {
        return vitaMod;
    }

    public void setVitaMod(int vitaMod) {
        this.vitaMod = vitaMod;
    }

    public int getDefMod() {
        return defMod;
    }

    public void setDefMod(int defMod) {
        this.defMod = defMod;
    }

    public int getStmMod() {
        return stmMod;
    }

    public void setStmMod(int stmMod) {
        this.stmMod = stmMod;
    }
}
