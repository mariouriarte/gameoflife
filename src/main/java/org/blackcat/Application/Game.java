package org.blackcat.Application;

import org.blackcat.Application.Plane.*;
import org.blackcat.Application.Plane.Exception.NonExistentCellException;
import org.blackcat.Entity.AxisXCell;
import org.blackcat.Entity.Cell;
import org.blackcat.Entity.Plane;

public class Game {
    Plane plane;
    int numGenerations;
    int timeSleep;

    RandomUnverifiedCell randomUnverifiedCell;

    public Game(Plane plane, int numGenerations, int timeSleep) {
        this.plane = plane;
        this.numGenerations = numGenerations;
        this.timeSleep = timeSleep;

        randomUnverifiedCell = new RandomUnverifiedCell(plane);
    }

    public void play() {

        for (int i = 0; i < numGenerations; i++) {

            try {
                Thread.sleep(timeSleep);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

            try {
                iterateGenerators();
            } catch (NonExistentCellException e) {
            }

            print(i);

            UnverifiedAllCells.unverified(plane);
            ChangeGenerationCells.evolve(plane);
        }
    }

    private void iterateGenerators() {

        while (true) {
            try {
                Cell cell = randomUnverifiedCell();
                evaluateCell(cell);
            } catch (NonExistentCellException e) {
                break;
            }
        }
    }

    private void evaluateCell(Cell cell) {
        NeighboursCell neighbours = new NeighboursCell(plane, cell);

        if (cell.getState() == 1) {
            if (neighbours.numNeighboursAlive() == 2 || neighbours.numNeighboursAlive() == 3) {

            } else if (neighbours.numNeighboursAlive() < 2) {
                cell.kill();
            } else if (neighbours.numNeighboursAlive() > 3) {
                cell.kill();
            }
        } else {
            if (neighbours.numNeighboursAlive() == 3) {
                cell.aliveAgain();
            }
        }

        cell.setVerified(true);
    }

    private Cell randomUnverifiedCell() {
        return randomUnverifiedCell.getCell();
    }

    private void print(int generation) {
        ClearConsoleScreen.clear();
        System.out.println("Conway's Game of life, generation: " + generation);

        PrintPlane print = new PrintPlane(plane);
        print.print();
    }
}
