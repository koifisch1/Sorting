public class Selection {
    private int i = 0;

    /**
     * implenentiert den Selection sort Algorithmus
     *
     * @param heatmap
     * @param daten   Die daten die zu sortieren sind
     *                i ist der index des aktuellen elements
     */
    public void step(int[] heatmap, int[] daten) {
        int min = Integer.MAX_VALUE;
        int hmin = 0;
        int index = 0;
        for (int j = i; j < daten.length; j++) {
            if (daten[j] < min) {
                min = daten[j];
                hmin = heatmap[i];

                index = j;
            }

        }
        daten[index] = daten[i];
        daten[i] = min;
        heatmap[index] = heatmap[i] + 1;
        heatmap[i] = hmin;
        heatmap[i]++;
        i++;
    }
}
