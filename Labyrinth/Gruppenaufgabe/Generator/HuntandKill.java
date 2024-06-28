package Gruppenaufgabe.Generator;

import Gruppenaufgabe.*;
import Gruppenaufgabe.Labyrinth;
import Gruppenaufgabe.Labyrinth.Cell;
import Gruppenaufgabe.Labyrinth.Cell.WallsOrientation;
import javafx.util.Pair;
import java.util.ArrayList;

import java.util.Random;

public class HuntandKill implements LabyrinthGenerator{

    ArrayList<Labyrinth.Cell> visitedCells;
    Random rand = new Random();

    public HuntandKill() {
        visitedCells = null;
    }

    public Labyrinth generateLabyrinth(int height, int width) {
        Labyrinth labyrinth = new Labyrinth(width, height);
        labyrinth.setAllWalls();
        
        visitedCells = new ArrayList<Labyrinth.Cell>();

        // random starting location
        Labyrinth.Cell currCell = labyrinth.cells[rand.nextInt(width)][rand.nextInt(height)];

        carveRandomPath(currCell);

        // scans over labyrinth
        for (int y = 0; y < height; ++y) {
            for (int x = 0; x < width; ++x) {

                // scan over all cells until an unvisited cell is found that is adjacent to a visited cell

                // unvisited cell
                if (!visitedCells.contains(labyrinth.cells[x][y])) {
                    for (WallsOrientation orientation : WallsOrientation.values()) {
                        // adjacent cell has been visited yet
                        if (visitedCells.contains(labyrinth.cells[x][y].getNeighbor(orientation))) {

                            // set next starting location (visited cell)

                            currCell = labyrinth.cells
                            [labyrinth.cells[x][y].getNeighbor(orientation).coordinates.getKey()]
                            [labyrinth.cells[x][y].getNeighbor(orientation).coordinates.getValue()];

                            System.out.println("carving new path from cell x: " + x + " y: " + y + " in direction: " + orientation 
                            + " number of visited cells: " + visitedCells.size());
                            // carve path
                            carveRandomPath(currCell);
                        }
                    }
                }
            }
        }
        return labyrinth;
    }

    private WallsOrientation oppositeOrientation(WallsOrientation orientation) {
        switch (orientation) {
            case Top:
                return WallsOrientation.Bottom;
            case Left:
                return WallsOrientation.Right;
            case Right:
                return WallsOrientation.Left;
            case Bottom:
                return WallsOrientation.Top;
            default:
                throw new IllegalArgumentException("Invalid orientation: " + orientation);
        }
    }

    public void carveRandomPath(Labyrinth.Cell startingCell) {
        Labyrinth.Cell currCell = startingCell;
        Labyrinth.Cell adjacentCell;
        WallsOrientation relativePositionToCurrCell = null;
        ArrayList<Labyrinth.Cell> nextAvailableCells = new ArrayList<Labyrinth.Cell>();

        while (true) {
            // adds the current cell to the list of visited cells
            if (!visitedCells.contains(currCell)) visitedCells.add(currCell);
            

            // gets valid neighbours (adjacent cells that haven't been visited yet)
            for (WallsOrientation orientation : WallsOrientation.values()) {
                if (currCell.getNeighbor(orientation) != null && !visitedCells.contains(currCell.getNeighbor(orientation))) {
                    nextAvailableCells.add(currCell.getNeighbor(orientation));
                }
            }

            // break condition (dead end)
            if (nextAvailableCells.isEmpty()) return;
            
            // selects one valid neighbour
            adjacentCell = nextAvailableCells.get(rand.nextInt(nextAvailableCells.size()));

            // get relative Position to current cell
            for (WallsOrientation orientation : WallsOrientation.values()) {
                if (currCell.getNeighbor(orientation) == adjacentCell) {
                    relativePositionToCurrCell = orientation;
                }
            }

            // carve path to neighbour
            currCell.removeWall(relativePositionToCurrCell);
            adjacentCell.removeWall(oppositeOrientation(relativePositionToCurrCell));
            System.out.println("CARVING: path from cell x: " + currCell.coordinates.getKey() + " y " + currCell.coordinates.getValue()
            + " in direction: " + relativePositionToCurrCell);

            // set currCell to adjacent cell
            currCell = adjacentCell;

            // clears nextAvailableCells for next selection
            nextAvailableCells.clear();

            // clears relative position and adjacent cell
            relativePositionToCurrCell = null;
            adjacentCell = null;
        }
    }
}