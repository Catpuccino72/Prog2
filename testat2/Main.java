package testat2;

interface TwoLegged {
    String getName();
    void setName(String s);
}

class Human implements TwoLegged{
    String name;
    @Override
    public String toString() {
        return this.name;
    }
    public String getName() {
        return toString();
    }
    public void setName(String s) {
        name = s;
    }
}

class Smurf implements TwoLegged{
    String name;

    @Override
    public String toString() {
        return this.name;
    }
    public String getName() {
        return toString();
    }
    public void setName(String s) {
        name = s;
    }
}

public class Main {
    public static void main(String[] args) {
        Human[] hannover = new Human[2];
        Smurf[] schlumpfhausen = new Smurf[2];
        TwoLegged[] bicycleClub = new TwoLegged[4];

        Human h1 = new Human();
        h1.setName("Erwin");
        Human h2 = new Human();
        h2.setName("Sabine");
        hannover[0] = h1;
        hannover[1] = h2;

        Smurf s1 = new Smurf();
        s1.setName("SchlaubiSchlumpf");
        Smurf s2 = new Smurf();
        s2.setName("Schlumpfine");
        schlumpfhausen[0] = s1;
        schlumpfhausen[1] = s2;

        bicycleClub[0] = h1;
        bicycleClub[1] = h2;
        bicycleClub[2] = s1;
        bicycleClub[3] = s2;

        System.out.println("\nSchlumpfhausen:");
        for (Smurf x : schlumpfhausen) {
            System.out.println(x.getName());
        }

        System.out.println("\nHannover:");
        for (Human x : hannover) {
            System.out.println(x.getName());
        }

        System.out.println("\nBicycleClub:");
        for (TwoLegged x : bicycleClub) {
            System.out.println(x.getName());
        }
    }
}