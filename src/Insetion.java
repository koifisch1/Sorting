public class Insetion {
    private int i = 1;

    /**
     * Implementiert insertion sort
     *
     * @param heatmap
     * @param daten   Die daten die zu sortieren sind
     *                i stellt den index des Aktuellen elements dar
     */
    public void step(int[] heatmap, int[] daten) {
        int key = daten[i];
        int hkey = heatmap[i];
        int j = i - 1;
        while (j >= 0 && daten[j] > key) {
            daten[j + 1] = daten[j];
            heatmap[j + 1] = ++heatmap[j];
            j = j - 1;
        }
        daten[j + 1] = key;
        heatmap[j + 1] = ++hkey;
        i++;
    }
}
