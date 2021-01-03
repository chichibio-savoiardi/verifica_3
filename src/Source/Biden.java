package Source;

public class Biden extends Player implements American {

    public Biden() {
        super("Giovanni Bidone", American.nameATK1, American.nameATK2, American.mcNukeSTM, American.borderCtrlSTM, American.mcNukeDMG, American.borderCtrlDMG);
    }

    @Override
    public String attacco1(Player player) {
        return American.nameATK1;
    }

    @Override
    public String attacco2(Player player) {
        return American.nameATK2;
    }

    @Override
    public String toString() {
        return super.getNome();
    }
}
