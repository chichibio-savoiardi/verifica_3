package Source;

public interface European {
    int jointOpDMG = 45;
    int jointOpSTM = 50;
    int politicalReformDMG = 25;
    int politicalReformSTM = 70;
    String jointOperation(Player player);
    String politicalReform(Player player);
}
