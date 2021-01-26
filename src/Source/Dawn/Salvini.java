package Dawn;

public class Salvini extends Player implements European {
    public Salvini() {
        super("Capitan Salvini", European.nameATK1, European.nameATK2, European.jointOpSTM, European.politicalReformSTM, European.jointOpDMG, European.politicalReformDMG);
    }

    @Override
    public String attacco1(Player target) {
        String msg = "empty";
        int dmg = super.getDannoATK1(), stm = super.getConsumoATK1();
        if (super.getStamina() < stm)
            return "Non hai abbastanza stamina";
        if (target.getDifesa() >= dmg) {
            msg = "\nè stato attaccato ma non ha ricevuto danno, hai ricevuto 5 danni per via della McNucleare";
            dmg = 0;
        } else {
            dmg -= target.getDifesa();
            msg = "\nè stato attaccato con " + super.getNomeATK1() + ", hai guadagnato 5 difesa";
        }
        super.setStamina(super.getStamina() - stm);
        super.buffDefMod(5);
        target.setPuntiVita(target.getPuntiVita() - dmg);
        return target + msg;
    }

    @Override
    public String attacco2(Player target) {
        String msg = "empty";
        int dmg = super.getDannoATK2(), stm = super.getConsumoATK2();
        if (super.getStamina() < stm)
            return "Non hai abbastanza stamina";
        if (target.getDifesa() >= dmg) {
            msg = "\nè stato attaccato ma non ha ricevuto danno";
            dmg = 0;
        } else {
            dmg -= target.getDifesa();
            msg = "\nè stato attaccato con " + super.getNomeATK2();
        }
        super.setStamina(super.getStamina() - stm);
        super.buffVitaMod(25);
        target.setPuntiVita(target.getPuntiVita() - dmg);
        return target + msg;
    }

    @Override
    public String toString() {
        return 
        "Nome: " + super.getNome() + ", Vita: " + super.getPuntiVita() + ", Stamina: " + super.getStamina() + ", Difesa: " + super.getDifesa() + "\n" + 
        "Info attacco base: " + "Danno: " + super.getDannoATK() + ", Stamina: " + super.getConsumoATK() + "\n" +
        "Info " + super.getNomeATK1() + ": Danno: " + super.getDannoATK1() + ", Stamina: " + super.getConsumoATK1() + ", Descrizione: " + European.ATK1Description + "\n"+
        "Info " + super.getNomeATK2() + ": Danno: " + super.getDannoATK2() + ", Stamina: " + super.getConsumoATK2() + ", Descrizione: " + European.ATK2Description;
    }
}
