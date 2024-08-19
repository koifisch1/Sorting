public class Selection {
    private int i = 0;

    public void step(int[] daten) {
        int min = Integer.MAX_VALUE;
        int index = 0;
        for (int j = i; j < daten.length; j++) {
            if (daten[j] <min) {
                min = daten[j];
                index = j;
            }

        }
        daten[index] = daten[i];
        daten[i] = min;
        i++;
    }
}
