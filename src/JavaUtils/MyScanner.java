package JavaUtils;

import java.util.Scanner;

public class MyScanner {
    private Scanner myIn;

    public MyScanner() {
        myIn = new Scanner(System.in);
    }

    public int int_() {
        myIn = new Scanner(System.in);
        return myIn.nextInt();
    }

    public double double_() {
        myIn = new Scanner(System.in);
        return myIn.nextDouble();
    }

    public String string_() {
        myIn = new Scanner(System.in);
        return myIn.nextLine();
    }

    public void reset() {
        myIn.reset();
        myIn.remove();
    }

    public void onOff() {
        myIn.close();
        myIn = new Scanner(System.in);
    }
}
