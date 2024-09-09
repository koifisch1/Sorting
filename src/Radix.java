import java.util.Arrays;

public class Radix {
    /**
     * Implentiert den radix Sort algoritmus
     */

    private int iteration = 1;

    /**
     * i ist der aktuelle schritt
     * Fuehrt einen schritt durch
     *
     * @param daten Die daten die zu sortieren sind
     */
    public void step(int[] daten) {

        countSort(daten, iteration);
        iteration *= 10;

    }


    /**
     * count sort für die sortierung innerhalb der einezelnen schritte
     *
     * @param daten Die daten die zu sortieren sind
     * @param exp   der exponent anhand dessen gerade sortiert weden soll
     */
    static void countSort(int daten[], int exp) {
        int output[] = new int[daten.length];
        int i;
        int count[] = new int[10];
        Arrays.fill(count, 0);

        for (i = 0; i < daten.length; i++)
            count[(daten[i] / exp) % 10]++;


        for (i = 1; i < 10; i++)
            count[i] += count[i - 1];


        for (i = daten.length - 1; i >= 0; i--) {
            output[count[(daten[i] / exp) % 10] - 1] = daten[i];
            count[(daten[i] / exp) % 10]--;
        }


        for (i = 0; i < daten.length; i++)
            daten[i] = output[i];
    }


}
