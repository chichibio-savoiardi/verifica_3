package Source;

public class Soleimani extends Player implements Arabic {
    public Soleimani() {
        super("Solemani", Arabic.nameATK1, Arabic.nameATK2, Arabic.beatingSTM, Arabic.childSoldiersSTM, Arabic.beatingDMG, Arabic.childSoldiersDMG);
    }

    @Override
    public String attacco1(Player target) {
        String msg = "empty";
        int dmg = super.getDannoATK1(), stm = super.getConsumoATK2();
        if (super.getStamina() < stm)
            return "Non hai abbastanza stamina";
        if (target.getDifesa() >= dmg) {
            msg = target.getNome() + " è stato attaccato ma non ha ricevuto danno";
            dmg = 0;
        } else {
            dmg -= target.getDifesa();
            msg = target.getNome() + " è stato attaccato con " + super.getNomeATK1();
        }
        super.setStamina(super.getStamina() - stm);
        target.setPuntiVita(target.getPuntiVita() - dmg);
        return msg;
    }

    @Override
    public String attacco2(Player target) {
        String msg = "empty";
        int dmg = super.getDannoATK2(), stm = super.getConsumoATK2();
        if (super.getStamina() < stm)
            return "Non hai abbastanza stamina";
        if (target.getDifesa() >= dmg) {
            dmg = 0;
            msg = target.getNome() + " è stato attaccato ma non ha ricevuto danno";
        } else {
            dmg -= target.getDifesa();
            msg = target.getNome() + " è stato attaccato con " + super.getNomeATK2();
        }
        super.setStamina(super.getStamina() - stm);
        super.buffStmMod(20);
        target.setPuntiVita(target.getPuntiVita() - dmg);
        return msg;
    }

    @Override
    public String toString() {
        return 
        "Nome: " + super.getNome() + ", Vita: " + super.getPuntiVita() + ", Stamina: " + super.getStamina() + ", Difesa: " + super.getDifesa() + "\n" + 
        "Info attacco base: " + ", Danno: " + super.getDannoATK() + ", Stamina: " + super.getConsumoATK() + "\n" +
        "Info " + super.getNomeATK1() + ": Danno: " + super.getDannoATK1() + ", Stamina: " + super.getConsumoATK1() + ", Descrizione: " + Arabic.ATK1Description + "\n"+
        "Info " + super.getNomeATK2() + ": Danno: " + super.getDannoATK2() + ", Stamina: " + super.getConsumoATK2() + ", Descrizione: " + Arabic.ATK2Description + "\n";
    }
}
