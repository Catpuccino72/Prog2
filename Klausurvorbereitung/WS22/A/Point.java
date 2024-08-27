public interface Point extends Comparable<Point>{
    public void setX(int x);
    public void setY(int y);

    public int getX();
    public int getY();

    public double getDistance();

    public int compareTo(Point point);
}