package org.blackcat.Application.Plane;

import org.blackcat.Application.Plane.Exception.NonExistentCellException;
import org.blackcat.Entity.Cell;
import org.blackcat.Entity.Plane;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Random;

public class SelectRandomUnverifiedCell {
    Plane plane;
    List<Cell> cellList;

    public SelectRandomUnverifiedCell(Plane plane) {
        this.plane = plane;
        initialize();
    }

    private void initialize() {
        cellList = new ArrayList<Cell>();

        Iterator<Cell> itr = plane.getLinealListOfCells().getList().iterator();



        while (itr.hasNext()) {
            Cell cell = itr.next();
//            System.out.println(cell.getX() + ", " + cell.getY());

            if (cell.getVerified() == false) {
                cellList.add(itr.next());
            }
        }
    }

    public Cell getCell() {

        if (cellList.size() == 0) {
            throw new NonExistentCellException();
        }

        Random randomMethod = new Random();
        int index = randomMethod.nextInt(cellList.size());
        return cellList.get(index);

//        Collections.shuffle(cellList);
//        return cellList.get(0);
    }
}
