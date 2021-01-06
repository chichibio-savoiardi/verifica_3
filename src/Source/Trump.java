package Source;

public class Trump extends Player implements American {
    public Trump() {
        super("Donaldo Trombetta", American.nameATK1, American.nameATK2, American.mcNukeSTM, American.borderCtrlSTM, American.mcNukeDMG, American.borderCtrlDMG);
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
            msg = "\nè stato attaccato con " + super.getNomeATK1() + ", hai ricevuto 5 danni per via della McNucleare";
        }
        super.setStamina(super.getStamina() - stm);
        super.setPuntiVita(super.getPuntiVita() - 5);
        target.setPuntiVita(target.getPuntiVita() - dmg);
        return target + msg;
    }

    @Override
    public String attacco2(Player target) {
        int stm = super.getConsumoATK2();
        if (super.getStamina() < stm)
            return "Non hai abbastanza stamina";
        super.setStamina(super.getStamina() - stm);
        super.buffDefMod(20);
        return super.getNome() + " ha attivato " + super.getNomeATK2();
    }
    
    @Override
    public String toString() {
        return 
        "Nome: " + super.getNome() + ", Vita: " + super.getPuntiVita() + ", Stamina: " + super.getStamina() + ", Difesa: " + super.getDifesa() + "\n" + 
        "Info attacco base: " + "Danno: " + super.getDannoATK() + ", Stamina: " + super.getConsumoATK() + "\n" +
        "Info " + super.getNomeATK1() + ": Danno: " + super.getDannoATK1() + ", Stamina: " + super.getConsumoATK1() + ", Descrizione: " + American.ATK1Description + "\n"+
        "Info " + super.getNomeATK2() + ": Danno: " + super.getDannoATK2() + ", Stamina: " + super.getConsumoATK2() + ", Descrizione: " + American.ATK2Description;
    }
}
