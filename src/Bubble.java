public class Bubble extends Thread {
    public static void step(int[] daten) {
        for (int i = 1; i < daten.length; i++) {
            if (daten[i] < daten[i - 1]) {
                int a = daten[i];
                daten[i] = daten[i - 1];
                daten[i - 1] = a;

            }
        }

    }


}
