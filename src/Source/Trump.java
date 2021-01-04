package Source;

public class Trump extends Player implements American {
    public Trump() {
        super("Donaldo Trombetta", American.nameATK1, American.nameATK2, American.mcNukeSTM, American.borderCtrlSTM, American.mcNukeDMG, American.borderCtrlDMG);
    }

    @Override
    public String attacco1(Player target) {
        String msg = "empty";
        int dmg = American.mcNukeDMG, stm = American.mcNukeSTM;
        if (super.getStamina() < stm)
            return "Non hai abbastanza stamina";
        if (target.getDifesa() >= dmg) {
            msg = target.getNome() + " è stato attaccato ma non ha ricevuto danno, hai ricevuto 5 danni per via della McNucleare";
            dmg = 0;
        } else {
            dmg -= target.getDifesa();
            msg = target.getNome() + " è stato attaccato con " + American.nameATK1 + ", hai ricevuto 5 danni per via della McNucleare";
        }
        super.setStamina(super.getStamina() - stm);
        super.setPuntiVita(super.getPuntiVita() - 5);
        target.setPuntiVita(target.getPuntiVita() - dmg);
        return msg;
    }

    @Override
    @Override
    public String attacco2(Player target) {
        int stm = American.borderCtrlSTM;
        if (super.getStamina() < stm)
            return "Non hai abbastanza stamina";
        super.setStamina(super.getStamina() - stm);
        super.setDefMod(40);
        return super.getNome() + " ha attivato " + American.nameATK2;
    }
    
    @Override
    public String toString() {
        return 
        "Nome: " + super.getNome() + ", Vita: " + super.getPuntiVita() + ", Stamina: " + super.getStamina() + ", Difesa: " + super.getDifesa() + "\n" + 
        "Info attacco base: " + ", Danno: " + super.getDannoATK() + ", Stamina: " + super.getConsumoATK() + "\n" +
        "Info " + super.getNomeATK1() + ": Danno: " + super.getDannoATK1() + ", Stamina: " + super.getConsumoATK1() + ", Descrizione: " + American.ATK1Description + "\n"+
        "Info " + super.getNomeATK2() + ": Danno: " + super.getDannoATK2() + ", Stamina: " + super.getConsumoATK2() + ", Descrizione: " + American.ATK2Description + "\n";
    }
}
