package org.blackcat.Application.Plane;

import org.blackcat.Application.Plane.Exception.NonExistentCellException;
import org.blackcat.Entity.AxisXCell;
import org.blackcat.Entity.Cell;
import org.blackcat.Entity.Plane;

import java.util.*;

public class RandomUnverifiedCell {
    static Plane plane;


    public RandomUnverifiedCell(Plane plane) {
        this.plane = plane;
    }


    public Cell getCell() {

        List<Cell> listToOrder = buildListOfUnverified();

        Random randomMethod = new Random();
        int index = randomMethod.nextInt(listToOrder.size());

        Cell cell = listToOrder.get(index);

        return cell;
    }

    private List<Cell> buildListOfUnverified() {
        List<Cell> listToOrder = new ArrayList<>();

        AxisXCell linealCells = plane.getLinealCells();

        Iterator<Cell> itr = linealCells.getList().iterator();

        while (itr.hasNext()) {
            Cell cell = itr.next();
            if (cell.getVerified() == false) {
                listToOrder.add(cell);
            }
        }

        if (listToOrder.size() == 0) {
            throw new NonExistentCellException();
        }

        return listToOrder;
    }
}
