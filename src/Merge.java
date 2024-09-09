public class Merge implements Runnable {
    /**
     *
     * @param daten  Die daten die zu sortieren sind
     * @param leftindex index der Linken seite
     * @param middelindex index der mitte
     * @param rightindex rechter index
     * @param heatmap
     */
    static void merge(int[] daten, int leftindex, int middelindex, int rightindex, int heatmap[]) {
        int laenge1 = middelindex - leftindex + 1;
        int laenge2 = rightindex - middelindex;

        int[] left = new int[laenge1];
        int[] right = new int[laenge2];
        int[] hright = new int[laenge2];
        int[] hleaft = new int[laenge1];
        System.arraycopy(daten, leftindex, left, 0, laenge1);
        System.arraycopy(heatmap, leftindex, hleaft, 0, laenge1);
        for (int j = 0; j < laenge2; ++j) {
            right[j] = daten[middelindex + 1 + j];
            hright[j] = heatmap[middelindex + 1 + j];

        }

        int i = 0, j = 0;

        int k = leftindex;
        while (i < laenge1 && j < laenge2) {
            if (left[i] <= right[j]) {
                daten[k] = left[i];
                heatmap[k] = hleaft[i];
                ++heatmap[k];
                i++;
            } else {
                daten[k] = right[j];
                heatmap[k] = hright[j];
                ++heatmap[k];
                j++;
            }
            k++;
        }
        while (i < laenge1) {
            daten[k] = left[i];
            heatmap[k] = hleaft[i];
            ++heatmap[k];
            i++;
            k++;
        }
        while (j < laenge2) {
            daten[k] = right[j];
            heatmap[k] = hright[j];
            ++heatmap[k];
            j++;
            k++;
        }
    }

    /**
     * rekursive sortiefunktion mergesort
     * @param daten  Die daten die zu sortieren sind
     * @param leftindex index der Linken seite
     * @param rightindex index der rechten seite
     * @param heatmap
     */
    static void sort(int[] daten, int leftindex, int rightindex, int[] heatmap) {
        if (leftindex < rightindex) {

            int middelindex = leftindex + (rightindex - leftindex) / 2;
            if (dealy) {
                try {
                    Thread.sleep(10);
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
            }
            sort(daten, leftindex, middelindex, heatmap);
            sort(daten, middelindex + 1, rightindex, heatmap);

            merge(daten, leftindex, middelindex, rightindex, heatmap);
        }
    }

    public static int[] daten0;
    public static boolean dealy = true;
    public static int[] heatmap0;

    @Override
    public void run() {
        sort(daten0, 0, daten0.length - 1, heatmap0);
    }
}
