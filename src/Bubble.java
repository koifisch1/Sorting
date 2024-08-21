public class Bubble  {

    public static void step(int [] heatmap,int[] daten) {
        for (int i = 1; i < daten.length; i++) {
            if (daten[i] < daten[i - 1]) {
                int a = daten[i];
                int b=heatmap[i];
                daten[i] = daten[i - 1];
                heatmap[i]=++heatmap[i-1];
                daten[i - 1] = a;
                heatmap[i-1]=++b;

            }
        }

    }


}
