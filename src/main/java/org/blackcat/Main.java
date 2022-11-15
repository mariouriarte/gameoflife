package org.blackcat;

import org.blackcat.Application.ClearConsoleScreen;
import org.blackcat.Application.Game;
import org.blackcat.Application.Plane.NeighboursCell;
import org.blackcat.Application.Plane.PrintPlane;
import org.blackcat.Entity.Plane;
import org.blackcat.Entity.Cell;
import org.blackcat.Entity.Coordinate;

import java.io.IOException;

// esto es un cambio de ejemplo
public class Main {
    public static void main(String[] args) throws IOException {
        System.out.println("Game of life");

        Plane plane = new Plane(40);

        Game game = new Game(plane, 1000000, 10);
        game.play();

//        PrintPlane print = new PrintPlane(plane);
//        print.print();
//
//        Cell cell = plane.getCellPosXY(new Coordinate(1, 2));
//        System.out.println();
//        System.out.println(cell.getState() + " in pos (" + cell.getX() + ", "+ cell.getY()+")");
//
//        NeighboursCell neighboursCell = new NeighboursCell(plane, cell);
//        neighboursCell.print();
//        System.out.println(neighboursCell.numNeighboursAlive() + " vivas");


    }
}
