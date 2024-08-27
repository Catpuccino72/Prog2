import java.util.ArrayList;
import java.util.Random;

public class Applikation {
    public static <T extends Comparable<T>> ArrayList<T> genericMergeSort(ArrayList<T> l) {
        ArrayList<T> result = new ArrayList<T>();

        if (l.size() <= 1) {return l;}

        // in zwei Listen aufteilen
        ArrayList<T> firstHalf = new ArrayList<T>();
        ArrayList<T> secondHalf = new ArrayList<T>();

        for (int i = 0; i < l.size()/2; i++) {
            firstHalf.add(l.get(i));
        }
        firstHalf = genericMergeSort(firstHalf);

        for (int i = l.size()/2; i < l.size(); i++) {
            secondHalf.add(l.get(i));
        }
        secondHalf = genericMergeSort(secondHalf);

        // Zusammenführen der Listen
        int i = 0, j = 0;
        // Solange es Elemente in beiden Listen gibt, werden die kleineren Elemente zuerst in die Ergebnisliste eingefügt
        while (i < firstHalf.size() && j < secondHalf.size()) {
            if (firstHalf.get(i).compareTo(secondHalf.get(j)) <= 0) {
                result.add(firstHalf.get(i));
                i++;
            } else {
                result.add(secondHalf.get(j));
                j++;
            }
        }
        while (i < firstHalf.size()) {
            result.add(firstHalf.get(i));
            i++;
        }
        while (j < secondHalf.size()) {
            result.add(secondHalf.get(j));
            j++;
        }

        return result;
    }

    public static void main(String[] args) {
        ArrayList<Eimer> l = new ArrayList<Eimer>();
        Random r = new Random();
        for (int n = 0; n < 10; n++) {
            Eimer eimer = new Eimer(r.nextInt(1000));
            l.add(eimer);
        }

        System.out.println("unsortierte Eimer:");
        for (Eimer eimer : l) {
            System.out.println(eimer.toString());
        }

        l = genericMergeSort(l);

        System.out.println("\nsortierte Eimer:");
        for (Eimer eimer : l) {
            System.out.println(eimer.toString());
        }
    }
}
