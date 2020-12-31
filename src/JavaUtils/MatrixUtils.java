package JavaUtils;

import java.util.*;
import java.lang.*;

public class MatrixUtils {
    private Scanner matrIn = new Scanner(System.in);

    public void print(int[][] matr) {
        for (int i = 0; i < matr.length; i++) { // Loop through all rows
            System.out.print("[ ");
            for (int j = 0; j < matr[i].length; j++) { // Loop through all elements of current row
                System.out.print(matr[i][j] + " ");
            }
            System.out.println("]");
        }
    }

    public void print(char[][] matr) {
        for (int i = 0; i < matr.length; i++) { // Loop through all rows
            System.out.print("[ ");
            for (int j = 0; j < matr[i].length; j++) { // Loop through all elements of current row
                System.out.print(matr[i][j] + " ");
            }
            System.out.println("]");
        }
    }

    public void print(double[][] matr) {
        for (int i = 0; i < matr.length; i++) { // Loop through all rows
            System.out.print("[ ");
            for (int j = 0; j < matr[i].length; j++) { // Loop through all elements of current row
                System.out.print(matr[i][j] + " ");
            }
            System.out.println("]");
        }
    }

    public void printColumn(int[][] matr) {
        for (int i = 0; i < matr[0].length; i++) {
            System.out.print("[ ");
            for (int[] ints : matr) {
                System.out.print(ints[i] + " ");
            }
            System.out.println("]");
        }
    }

    public void printColumn(char[][] matr) {
        for (int i = 0; i < matr[0].length; i++) {
            System.out.print("[ ");
            for (char[] chars : matr) {
                System.out.print(chars[i] + " ");
            }
            System.out.println("]");
        }
    }

    public void randomFill(int[][] matr, int min, int max) {
        Random rand = new Random();
        for (int i = 0; i < matr.length; i++) {
            for (int j = 0; j < matr[i].length; j++) {
                matr[i][j] = rand.nextInt((max - min) + 1) + min;
            }
        }
    }

    public void randomBoolFill(int[][] matr) {
        Random randNum = new Random();
        for (int i = 0; i < matr.length; i++) {
            for (int j = 0; j < matr[i].length; j++) {
                matr[i][j] = randNum.nextInt(1);
            }
        }
    }

    public void randomBoolFill(char[][] matr) {
        Random randNum = new Random();
        for (int i = 0; i < matr.length; i++) {
            for (int j = 0; j < matr[i].length; j++) {
                if (randNum.nextInt(2) == 1) {
                    matr[i][j] = '#';
                }
            }
        }
    }

    public void fill0123(int[][] matr) {
        int count = 0;
        for (int i = 0; i < matr.length; i++) {
            for (int j = 0; j < matr[i].length; j++) {
                matr[i][j] = count;
                count++;
            }
        }
    }

    public void fill(int[][] matr, int filler) {
        for (int[] ints : matr) {
            Arrays.fill(ints, filler);
        }
    }

    public void fill(char[][] matr, char filler) {
        for (char[] chars : matr) {
            Arrays.fill(chars, filler);
        }
    }

    public int mulDiag(int[][] mat) {
        int dp = 1, ds = 1, det;
        for (int i = 0; i < mat.length; i++) {
            dp = mat[i][i] * dp;
            ds = mat[mat.length - 1 - i][i] * ds;
        }
        det = dp - ds;
        return det;
    }

    public void copy(char[][] matr0, char[][] matr1) {
        for (int i = 1; i < 10; i++) {
            System.arraycopy(matr0[i], 1, matr1[i], 1, 9);
        }
    }
}
