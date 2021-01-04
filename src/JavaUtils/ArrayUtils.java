package JavaUtils;

public class ArrayUtils {
    BasicUtils basicUtils = new BasicUtils();

    public void print(int[] array) {
        System.out.print("[ ");
        for (int value : array) {
            System.out.print(value + ", ");
        }
        System.out.println("]");
    }

    public void print(char[] array) {
        System.out.print("[ ");
        for (char c : array) {
            System.out.print(c + ", ");
        }
        System.out.println("]");
    }

    public void print(String[] array) {
        System.out.print("[ ");
        for (String c : array) {
            System.out.print(c + ", ");
        }
        System.out.println("]");
    }

    public void print(Object[] array) {
        System.out.print("[ ");
        for (Object c : array) {
            System.out.print(c + "; ");
        }
        System.out.println("]");
    }

    public void fill0123(int[] arr) {
        for (int i = 0; i < arr.length; i++) {
            arr[i] = i;
        }
    }

    public void randomFill(int[] array, int min, int max) {
        for (int i = 0; i < array.length; i++)
            array[i] = basicUtils.randInt(min, max);
    }

    public void bubbleSort(int[] array) {
        for (int i = 0; i < array.length; i++) {
            boolean flag = false;
            for (int j = 0; j < array.length - 1; j++) {
                // Se l' elemento j e maggiore del successivo allora scambiamo i valori
                if (array[j] > array[j + 1]) {
                    int k = array[j];
                    array[j] = array[j + 1];
                    array[j + 1] = k;
                    flag = true; // Lo setto a true per indicare che é avvenuto uno scambio
                }
            }
            if (!flag)
                break;
            /*
             * Se flag=false allora vuol dire che nell' ultima iterazione non ci sono stati
             * scambi, quindi il metodo può terminare poiché l' array risulta ordinato
             */
        }
    }

    public void bubbleSort(Object[] array) {
        for (int i = 0; i < array.length; i++) {
            boolean flag = false;
            for (int j = 0; j < array.length - 1; j++) {
                // Se l' elemento j e maggiore del successivo allora scambiamo i valori
                if (array[j].hashCode() > array[j + 1].hashCode()) {
                    Object k = array[j];
                    array[j] = array[j + 1];
                    array[j + 1] = k;
                    flag = true; // Lo setto a true per indicare che é avvenuto uno scambio
                }
            }
            if (!flag)
                break;
            /*
             * Se flag=false allora vuol dire che nell' ultima iterazione non ci sono stati
             * scambi, quindi il metodo può terminare poiché l' array risulta ordinato
             */
        }
    }

    public void invBubbleSort(int[] array) {
        for (int i = 0; i < array.length; i++) {
            boolean flag = false;
            for (int j = 0; j < array.length - 1; j++) {
                // Se l' elemento j e maggiore del successivo allora scambiamo i valori
                if (array[j] < array[j + 1]) {
                    int k = array[j];
                    array[j] = array[j + 1];
                    array[j + 1] = k;
                    flag = true; // Lo setto a true per indicare che é avvenuto uno scambio
                }
            }
            if (!flag)
                break;
            /*
             * Se flag=false allora vuol dire che nell' ultima iterazione non ci sono stati
             * scambi, quindi il metodo può terminare poiché l' array risulta ordinato
             */
        }
    }

    public void insertSort(int[] array) {
        double num;
        int x;
        int pos;
        int[] array2 = new int[array.length];
        for (x = 0; x < array2.length; x++) // zeroing vector
            array2[x] = 0;
        // start of the algorithm
        for (x = 0; x < array2.length; x++) {
            num = array[x]; // nuovo numero
            pos = 0;
            while ((array2[pos] < num) && (array2[pos] != 0))
                pos++; // trova il posto per inserimento
            shiftR(array2, pos); // crea un buco dove inserire
            array2[pos] = (int) num;
        }
        System.arraycopy(array2, 0, array, 0, array.length);
    }

    public void shiftR(int[] array, int hole) {
        int x;
        for (x = array.length - 2; x >= hole; x--) { // sposta a destra
            array[x + 1] = array[x]; // posto libero in buco
        }
    }

    public void seleSort(int[] array) {
        int x, y, i_min;
        int temp;
        for (x = 0; x < array.length - 1; x++) { // ricerca del minimo
            i_min = x; // hp primo come minimo
            for (y = x + 1; y < array.length; y++) { // x la parte dx del vettore
                if (array[y] < array[i_min]) // se l'elemento � minore
                    i_min = y; // indice nuovo minimo
            }
            // scambia elemento corrente con il minore trovato
            temp = array[i_min];
            array[i_min] = array[x];
            array[x] = temp;
        }
    }

    public void countingSort(int[] arr) {
        int max = arr[0];
        int min = arr[0];
        int i = 1;
        for (; i < arr.length; i++) { // Calcolo degli elementi max e min
            if (arr[i] > max)
                max = arr[i];
            else if (arr[i] < min)
                min = arr[i];
        }
        int[] arr2 = new int[max - min + 1];
        for (i = 0; i < arr2.length; i++)
            arr2[i] = 0; // inizializza a zero gli elementi di arr2
        for (i = 0; i < arr.length; i++)
            arr2[arr[i] - min]++; // aumenta il numero di volte che si è incontrato il valore
        // Ordinamento in base al contenuto dell'array delle frequenze arr2
        int k = 0; // indice per l'array arr
        for (i = 0; i < arr2.length; i++) {
            while (arr2[i] > 0) { // scrive arr2[i] volte il valore (i+min) nell'array arr
                arr[k] = i + min;
                k++;
                arr2[i]--;
            }
        }
    }

    public int findMin(int[] vet) {
        int x, num1;
        num1 = vet[0]; // inzializzo il min
        for (x = 0; x < vet.length; x++)
            if (vet[x] < num1)
                num1 = vet[x]; // il minore
        return num1;
    }

    public int findMax(int[] vet) {
        int x, num2;
        num2 = vet[0]; // inzializzo il max
        for (x = 0; x < vet.length; x++)
            if (vet[x] > num2)
                num2 = vet[x]; // il maggiore
        return num2;
    }

    public void quickSort(int[] vett, int e_sx, int e_dx) {
        int q; // nuovo indice pivot
        if (e_sx < e_dx) { // ctr termine vettore
            q = partition(vett, e_sx, e_dx);
            // -- chiamata sui sotto vettori sinistro e destro
            quickSort(vett, e_sx, q - 1); // vet di sinistra
            quickSort(vett, q + 1, e_dx); // vet di destra
        }
    }

    public int partition(int[] vett, int sx, int dx) {
        int pivot, ipivot; // valore di pivot, indice posizione pivot
        ipivot = sx; // scegli indice per il pivot: Hoare usa il primo
        pivot = vett[ipivot]; // valore_pivot <- [posizione_iniziale_pivot]
        // effettua il partizionamento in due sotto vettori individuando q
        // (posizione_effettiva_pivot)
        while (sx < dx) {
            while ((vett[sx] <= pivot) && (sx < dx)) // cerco elemento di sinistra > pivot
                sx++;
            while (vett[dx] > pivot) // cerco elemento di destra < pivot
                dx--;
            if (sx < dx) { // se non ho finito di ordinare
                swap(vett, sx, dx); // scambio i due elementi
            }
        }
        swap(vett, ipivot, dx); // posiziona il pivot nella sua cella q
        return dx;
    }

    public void swap(int[] vet, int x, int y) {
        int tmp = vet[x];
        vet[x] = vet[y];
        vet[y] = tmp;
    }

    public void stalinSort(int[] vect) {
        // this sort is very easy comrade
        // if number is out of order number is removed
        for (int i = 0; i < vect.length - 1; i++) {
            for (int j = i; j < vect.length; j++) {
                if (vect[i] > vect[j]) {
                    vect[j] = 0;
                }
            }
        }
    }

    public void parPrintVect(int[]... args) {
        for (int[] arg : args) {
            System.out.print("[ ");
            for (int j = 0; j < arg.length; j++) {
                System.out.print(arg[j] + " ");
            }
            System.out.println("]");
        }
    }

    public void parPrintVectTable(String[]... args) {
        for (int i = 0; i < args[0].length; i++) {
            System.out.print("[ ");
            for (String[] arg : args) {
                System.out.print(arg[i] + " | ");
            }
            System.out.println("]");
        }
    }

    public void compactArray(Object[] Array, int pos) {
        for (int i = pos; i < Array.length - 1; i++) {
            Array[i] = Array[i + 1];
        }
    }

    public int findNull(Object[] Array) {
        for (int i = 0; i < Array.length; i++)
            if (Array[i] == null)
                return i;
        return -1;
    }

    public int findNull(Object[] Array, int startPos) {
        for (int i = startPos; i < Array.length; i++)
            if (Array[i] == null)
                return i;
        return -1;
    }

    public int findNotNull(Object[] Array) {
        for (int i = 0; i < Array.length; i++)
            if (Array[i] != null)
                return i;
        return -1;
    }

    public int findNotNull(Object[] Array, int startPos) {
        for (int i = startPos; i < Array.length; i++)
            if (Array[i] != null)
                return i;
        return -1;
    }

    public int search(int[] array, int toSearch) {
        for (int i = 0; i < array.length; i++)
            if (array[i] == toSearch)
                return i;
        return -1;
    }
}
/* fin */