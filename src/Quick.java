import java.util.ArrayList;
import java.util.Arrays;

public class Quick {
    public static void step(int[] daten) {
        if (daten.length > 1) {

            ArrayList<Integer> list2 = new ArrayList<>();
            ArrayList<Integer> list1 = new ArrayList<>();
            ArrayList<Integer> datenlist = new ArrayList<>();
            for (int i = 0; i < daten.length; i++) {
                datenlist.add(daten[i]);
            }
            int x = (int) (Math.random() * datenlist.size());
            int pivot = datenlist.get(x);
            datenlist.remove(x);

            while (!datenlist.isEmpty()) {
                if (datenlist.get(0) < pivot) {
                    list2.add(datenlist.get(0));
                } else {
                    list1.add(datenlist.get(0));
                }
                datenlist.remove(0);
            }

            for (int i = 0; i < list2.size(); i++) {
                daten[i] = list2.get(i);
            }
            daten[list2.size()] = pivot;
            for (int i = list2.size() + 1; i < list2.size() + list1.size() + 1; i++) {
                daten[i] = list1.get((i - list2.size()) - 1);
            }
        }


    }

}
