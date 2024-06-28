package Gruppenaufgabe;

import java.io.*;

import Gruppenaufgabe.Generator.HuntandKill;
import javafx.util.Pair;

public class Labyrinth implements java.io.Serializable{
    private final int height;
    private final int width;
    public Cell[][] cells;

    public Labyrinth(int height, int width) {
        this.height = height;
        this.width = width;
        cells = new Cell[width][height];
        for (int y = 0; y < height; ++y) {
            for (int x = 0; x < width; ++x) {
                cells[x][y] = new Cell(x, y);
            }
        }
    }

    public void setAllWalls() {
        for (int y = 0; y < height; ++y) {
            for (int x = 0; x < width; ++x) {
                cells[x][y].setAllWalls();
            }
        }
    }

    public void removeAllWalls() {
        for (int y = 0; y < height; ++y) {
            for (int x = 0; x < width; ++x) {
                cells[x][y].removeAllWalls();
            }
        }
    }

    public int getHeight() {
        return height;
    }

    public int getWidth() {
        return width;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();

        // Print the top border
        for (int x = 0; x < width; ++x) {
            sb.append("+---");
        }
        sb.append("+\n");

        for (int y = 0; y < height; ++y) {
            StringBuilder top = new StringBuilder("|");
            StringBuilder bottom = new StringBuilder("+");

            for (int x = 0; x < width; ++x) {
                top.append("   ");
                try {
                    if (cells[x][y].isWallSet(Cell.WallsOrientation.Right)) {
                        top.append("|");
                    } else {
                        top.append(" ");
                    }
                } catch (Exception e) {
                    e.printStackTrace();
                }

                try {
                    if (cells[x][y].isWallSet(Cell.WallsOrientation.Bottom)) {
                        bottom.append("---+");
                    } else {
                        bottom.append("   +");
                    }
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }

            sb.append(top).append("\n");
            sb.append(bottom).append("\n");
        }

        return sb.toString();
    }
    
    public class Cell {
        public Pair<Integer, Integer> coordinates;

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

        public Cell(int x, int y) {
            coordinates = new Pair<Integer,Integer>(x, y);
            Walls = 0;
        }

        public Cell getNeighbor(WallsOrientation orientation){
            switch (orientation) {
                case Top:
                    return getTopCell();

                case Left:
                    return getLeftCell();

                case Right:
                    return getRightCell();

                case Bottom:
                    return getBottomCell();
            }
            return null;
        }

        public Cell getTopCell() {
            if (this.coordinates.getValue() == 0) return null;
            return cells[this.coordinates.getKey()][this.coordinates.getValue()-1];
        }
    
        public Cell getRightCell() {
            if (this.coordinates.getKey() == width-1) return null;
            return cells[this.coordinates.getKey()+1][this.coordinates.getValue()];
        }
    
        public Cell getBottomCell() {
            if (this.coordinates.getValue() == height-1) return null;
            return cells[this.coordinates.getKey()][this.coordinates.getValue()+1];
        }
    
        public Cell getLeftCell() {
            if (this.coordinates.getKey() == 0) return null;
            return cells[this.coordinates.getKey()-1][this.coordinates.getValue()];
        }

        public void setAllWalls() {
            Walls = 15;
        }

        public void removeAllWalls() {
            Walls = 0;
        }

        public void placeWall(WallsOrientation orientation) throws Exception {
            switch (orientation) {
                case Top:
                    Walls |= WALL_TOP;
                    if (this.getTopCell() != null) {
                        this.getTopCell().Walls |= WALL_BOTTOM;
                    }
                    break;

                case Left:
                    Walls |= WALL_RIGHT;
                    if (this.getRightCell() != null) {
                        this.getRightCell().Walls |= WALL_LEFT;
                    }
                    break;

                case Right:
                    Walls |= WALL_BOTTOM;
                    if (this.getBottomCell() != null) {
                        this.getBottomCell().Walls |= WALL_TOP;
                    }
                    break;

                case Bottom:
                    Walls |= WALL_LEFT;
                    if (this.getLeftCell() != null) {
                        this.getLeftCell().Walls |= WALL_RIGHT;
                    }
                    break;

                default:
                    throw new Exception("no valid orientation");
            }
        }

        public void removeWall(WallsOrientation orientation) {
            switch (orientation) {
                case Top:
                    Walls ^= WALL_TOP;
                    if (this.getTopCell() != null) {
                        this.getTopCell().Walls ^= WALL_BOTTOM;
                    }
                    break;

                case Left:
                    Walls ^= WALL_RIGHT;
                    if (this.getRightCell() != null) {
                        this.getRightCell().Walls ^= WALL_LEFT;
                    }
                    break;

                case Right:
                    Walls ^= WALL_BOTTOM;
                    if (this.getBottomCell() != null) {
                        this.getBottomCell().Walls ^= WALL_TOP;
                    }
                    break;

                case Bottom:
                    Walls ^= WALL_LEFT;
                    if (this.getLeftCell() != null) {
                        this.getLeftCell().Walls ^= WALL_RIGHT;
                    }
                    break;
            }
        }

        public boolean isWallSet(WallsOrientation orientation) throws Exception {
            int WallsShifted = Walls;
            switch (orientation) {
                case Top:
                    return (WallsShifted & 1) == 1;

                case Left:
                    return ((WallsShifted >>= 1) & 1) == 1;

                case Right:
                    return ((WallsShifted >>= 2) & 1) == 1;

                case Bottom:
                    return ((WallsShifted >>= 3) & 1) == 1;
            }
            throw new Exception("no valid orientation");
        }
    }
    public class main {
        public static void main(String[] args) {
            HuntandKill HAK = new HuntandKill();
            Labyrinth lb = HAK.generateLabyrinth(10, 10);
        }
    }
}