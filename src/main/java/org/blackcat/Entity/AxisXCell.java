package org.blackcat.Entity;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class AxisXCell {
    List<Cell> list;

    public AxisXCell() {
        this.list = new ArrayList<Cell>();
    }

    public List<Cell> getList() {
        return list;
    }

    public void addList(List<Cell> list) {

        Iterator<Cell> itr = this.list.iterator();

        while (itr.hasNext()) {
            this.list.add(itr.next());
        }
    }

    public void add(Cell cell) {
        list.add(cell);
    }

    public void addAll(AxisXCell list) {
        list.addAll(list);
    }

    public void remove(Cell cell) {
        list.remove(cell);
    }

    public Cell getCellInX(int x){
        return list.get(x);
    }
}
