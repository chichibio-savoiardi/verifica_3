package Source;

public class Trump extends Player implements American {
    public Trump() {
        super("Donaldo Trombetta", American.nameATK1, American.nameATK2, American.mcNukeSTM, American.borderCtrlSTM, American.mcNukeDMG, American.borderCtrlDMG);
    }

    @Override
    public String attacco1(Player player) {
        return "McNuke";
    }

    @Override
    public String attacco2(Player player) {
        return "Controllo Bordi";
    }
    
    @Override
    public String toString() {
        return super.getNome();
    }
}
