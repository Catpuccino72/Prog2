package Gruppenaufgabe.Generator;
import Gruppenaufgabe.*;
import Gruppenaufgabe.Labyrinth.Cell;
import Gruppenaufgabe.Labyrinth.Cell.WallsOrientation;
import javafx.util.Pair;
import java.util.ArrayList;

import java.util.Random;

public class HuntandKill implements LabyrinthGenerator{

    //Pair<Integer, Integer>[] visitedCells;
    ArrayList<Labyrinth.Cell> visitedCells;

    public HuntandKill() {
        visitedCells = null;
    }

    public Labyrinth generateLabyrinth(int height, int width) {
        Labyrinth labyrinth = new Labyrinth(width, height);
        visitedCells = new ArrayList<Labyrinth.Cell>();

        Random rand = new Random();

        Labyrinth.Cell currCell = labyrinth.cells[rand.nextInt(width)][rand.nextInt(height)];

        return labyrinth;
    }

    public void carveRandomPath(Labyrinth.Cell startingCell) {
        Labyrinth.Cell currCell = startingCell;
        ArrayList<Labyrinth.Cell> nextAvailableCells = new ArrayList<Labyrinth.Cell>();

        while (true) {
            for (WallsOrientation orientation : WallsOrientation.values()) {
                if (currCell.getNeighbor(orientation) != null) {
                    nextAvailableCells.add(currCell.getNeighbor(orientation));
                }
            }
            // break condition
            if (nextAvailableCells.size() == 0) return;
            
            rand.nextInt(nextAvailableCells.size())
        }
    }
}