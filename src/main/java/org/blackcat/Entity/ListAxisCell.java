package org.blackcat.Entity;

import java.util.ArrayList;
import java.util.List;

public class ListAxisCell {
    private List<ListCell> axis = new ArrayList<ListCell>();

    public ListAxisCell(int sides) {
        for (int i = 0; i < sides; i++) {
            axis.add(new ListCell());
        }
    }

    public void addCellInCoordinateY(int y, Cell cell) {
        ListCell list = getListInCoordinateY(y);
        list.add(cell);
    }

    public Cell getCellPosXY(Coordinate coordinate) {
        ListCell ejeY = axis.get(coordinate.getY());
        Cell cell = ejeY.getCellInX(coordinate.getX());
        return cell;
    }

    public ListCell getListInCoordinateY(int y){
        return axis.get(y);
    }

    public List<ListCell> getAxis() {
        return axis;
    }
}
