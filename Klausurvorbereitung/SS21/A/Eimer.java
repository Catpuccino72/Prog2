public class Eimer implements Comparable<Eimer>{
    private double volume;

    public double getVolume() {
        return volume;
    }

    public Eimer(double volume) {this.volume = volume;}

    public int compareTo(Eimer eimer){
        if (volume == eimer.volume) return 0;
        else if (volume < eimer.volume) return -1;
        else return 1;
    }

    @Override
    public String toString() {
        return "Eimer mit Volumen " + volume;
    }
}
