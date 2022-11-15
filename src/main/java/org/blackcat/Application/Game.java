package org.blackcat.Application;

import org.blackcat.Application.Plane.Exception.NonExistentCellException;
import org.blackcat.Application.Plane.NeighboursCell;
import org.blackcat.Application.Plane.PrintPlane;
import org.blackcat.Application.Plane.SelectRandomUnverifiedCell;
import org.blackcat.Application.Plane.UnverifiedAllCells;
import org.blackcat.Entity.Cell;
import org.blackcat.Entity.Coordinate;
import org.blackcat.Entity.Plane;

public class Game {
    Plane plane;
    int numGenerations;
    int timeSleep;

    public Game(Plane plane, int numGenerations, int timeSleep) {
        this.plane = plane;
        this.numGenerations = numGenerations;
        this.timeSleep = timeSleep;
        ClearConsoleScreen.clear();
    }

    public void play() {

        print();

        for(int i = 0; i < numGenerations; i++) {

            try {
                iterateGenerators();
            } catch (NonExistentCellException e) {}

            UnverifiedAllCells.unverified(plane);
        }
    }

    private void print() {
        PrintPlane print = new PrintPlane(plane);
        print.print();
    }

    private void iterateGenerators() {
        while (true) {
            Cell cell = selectUnverifiedRandomCell();
            evaluateCell(cell);

            try {
                Thread.sleep(20);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            ClearConsoleScreen.clear();

            System.out.println("Game of life");
            print();
        }
    }

    private void evaluateCell(Cell cell) {
        NeighboursCell neighbours = new NeighboursCell(plane, cell);
        cell.getCoordinate().print();

        if (cell.getState() == 1) {
            if (neighbours.numNeighboursAlive() >= 2 && neighbours.numNeighboursAlive() <= 3) {
//                return;
            } else if (neighbours.numNeighboursAlive() < 2) {
                cell.kill();
            } else if (neighbours.numNeighboursAlive() > 3){
                cell.kill();
            }
        } else {
            if (neighbours.numNeighboursAlive() == 3) {
                cell.aliveAgain();
            }
        }

        cell.setVerified(true);
    }

    private Cell selectUnverifiedRandomCell() {
        SelectRandomUnverifiedCell select = new SelectRandomUnverifiedCell(plane);
        return select.getCell();
    }
}
