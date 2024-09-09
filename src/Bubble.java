public class Bubble {
    /**
     * Implementiert den BubbleSort Algorithmus
     *
     * @param heatmap anzahl der Tausaktionen pro element
     * @param daten   Die daten die zu sortieren sind
     */
    public static void step(int[] heatmap, int[] daten) {
        for (int i = 1; i < daten.length; i++) {
            //daten entlang gehen bei bedarf benachbarte elemente tauschen
            if (daten[i] < daten[i - 1]) {
                int a = daten[i];
                int b = heatmap[i];
                daten[i] = daten[i - 1];
                heatmap[i] = ++heatmap[i - 1];
                daten[i - 1] = a;
                heatmap[i - 1] = ++b;

            }
        }

    }


}
