public class MPoint implements Point{
    private int Y;
    private int X;

    public void setX(int x) {this.X = x;}
    public void setY(int x) {this.X = x;}

    public int getX() {return this.X;}
    public int getY() {return this.Y;}

    public MPoint(int x, int y) {
        this.X = x;
        this.Y = y;
    }

    public double getDistance() {
        return (double) Math.abs(this.X) + (double) Math.abs(this.Y);
    }

    public int compareTo(Point point) {
        if (getDistance() == point.getDistance()) return 0;
        else if (getDistance() < point.getDistance()) return -1;
        else return 1;
    }

    @Override
    public String toString() {
        return "Punkt: ( " +X+ " ; " +Y+ " ) Dist: " + getDistance();
    }
}

