import java.util.Arrays;

public class Radix {


private int iteration=1;


    public void step(int[] daten) {

        countSort(daten, iteration);
        iteration*=10;

    }


    static int getMax(int[] daten) {
        int max = Integer.MIN_VALUE;
        for (int j : daten)
            if (j > max)
                max = j;
        return max;
    }

    // A function to do counting sort of daten[] according to
    // the digit represented by exp.
    static void countSort(int daten[], int exp) {
        int output[] = new int[daten.length]; // output array
        int i;
        int count[] = new int[10];
        Arrays.fill(count, 0);

        // Store count of occurrences in count[]
        for (i = 0; i < daten.length; i++)
            count[(daten[i] / exp) % 10]++;

        // Change count[i] so that count[i] now contains
        // actual position of this digit in output[]
        for (i = 1; i < 10; i++)
            count[i] += count[i - 1];

        // Build the output array
        for (i = daten.length - 1; i >= 0; i--) {
            output[count[(daten[i] / exp) % 10] - 1] = daten[i];
            count[(daten[i] / exp) % 10]--;
        }


        for (i = 0; i < daten.length; i++)
            daten[i] = output[i];
    }




}
