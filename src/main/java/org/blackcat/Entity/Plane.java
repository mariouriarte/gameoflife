package org.blackcat.Entity;

public class Plane {
    private ListCell linealListCells = new ListCell();
    private ListAxisCell listAxisCell;
    private int sides;

    public Plane(int sides) {
        this.sides = sides;
        listAxisCell = new ListAxisCell(sides);
        initializeSides();
    }

    private void initializeSides() {
        for (int j = 0; j < sides; j++) {
            for (int i = 0; i < sides; i++) {
                Cell cell = new Cell(i, j);
                listAxisCell.addCellInCoordinateY(j, cell);
                linealListCells.add(cell);
            }
        }
    }

    public Cell getCellPosXY(Coordinate coordinate) {
        return listAxisCell.getCellPosXY(coordinate);
    }

    public int getSides() {
        return sides;
    }

    public ListCell getLinealListOfCells() {
        return linealListCells;
    }

    public ListAxisCell getListAxisCell() {
        return listAxisCell;
    }
}
