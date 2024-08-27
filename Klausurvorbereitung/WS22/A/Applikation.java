import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class Applikation {
    static <T extends Point> void sortPoints(List<T> l) {
        boolean finished = false;

        while (true) {
            if (l.isEmpty()) break;
            finished = true;
            for (int i = 0; i < l.size()-1; i++) {
                if (l.get(i).getDistance() > l.get(i+1).getDistance()) {
                    Collections.swap(l, i, i+1);
                    finished = false;
                }
            }
            if (finished) break;
        }
    }

    public static void main (String[] args) {
        Scanner s = new Scanner(System.in);
        List<MPoint> l = new ArrayList<MPoint>();

        System.out.println("Neuer Punkt x y :");

        for(String input = s.nextLine(); !input.equals("E"); input = s.nextLine()){

            l.add(new MPoint(Integer.valueOf(input), Integer.valueOf(s.nextLine())));
            System.out.println("Neuer Punkt x y :");
        }
        s.close();
        
        System.out.println("eingegebene Punkte:");
        for (MPoint m : l) {
            System.out.println(m.toString());
        }

        sortPoints(l);

        System.out.println("sortierte Punkte:");
        for (MPoint m : l) {
            System.out.println(m.toString());
        }
    }
}
