import java.io.*;

public class Labyrinth implements java.io.Serializable{
    private final int height;
    private final int width;
    Cell[][] cells;

    public Labyrinth(int height, int width) {
        this.height = height;
        this.width = width;
        cells = new Cell[height][width];
    }

    public void setAllWalls() {
        for (int y = 0; y < height; ++y) {
            for (int x = 0; x < width; ++x) {
                cells[y][x].setAllWalls();
            }
        }
    }

    public void removeAllWalls() {
        for (int y = 0; y < height; ++y) {
            for (int x = 0; x < width; ++x) {
                cells[y][x].removeAllWalls();
            }
        }
    }

    public int getHeight() {
        return height;
    }

    public int getWidth() {
        return width;
    }

    class Cell {
        public static enum WallsOrientation{
            Top,
            Left,
            Right,
            Bottom
        }

        final int NO_WALLS = 0; // 0000
        final int WALL_TOP = 1; // 0001
        final int WALL_RIGHT = 2; // 0010
        final int WALL_BOTTOM = 4; // 0100
        final int WALL_LEFT = 8; // 1000

        int Walls;

        public Cell() {
            Walls = 0;
        }

        public void setAllWalls() {
            Walls = 15;
        }

        public void removeAllWalls() {
            Walls = 0;
        }

        public void placeWall(WallsOrientation orientation) {
            switch (orientation) {
                case Top:
                    Walls |= WALL_TOP;
                    break;

                case Left:
                    Walls |= WALL_RIGHT;
                    break;

                case Right:
                    Walls |= WALL_BOTTOM;
                    break;

                case Bottom:
                    Walls |= WALL_LEFT;
                    break;
            }
        }

        public void removeWall(WallsOrientation orientation) {
            switch (orientation) {
                case Top:
                    Walls ^= WALL_TOP;
                    break;

                case Left:
                    Walls ^= WALL_RIGHT;
                    break;

                case Right:
                    Walls ^= WALL_BOTTOM;
                    break;

                case Bottom:
                    Walls ^= WALL_LEFT;
                    break;
            }
        }

        public boolean isWallSet(WallsOrientation orientation) {
            int WallsShifted = Walls;
            switch (orientation) {
                case Top:
                    break;

                case Left:
                    WallsShifted >>= 1;
                    break;

                case Right:
                    WallsShifted >>= 2;
                    break;

                case Bottom:
                    WallsShifted >>= 3;
                    break;
            }
            return ((WallsShifted & 1) == 1);
        }
    }
}