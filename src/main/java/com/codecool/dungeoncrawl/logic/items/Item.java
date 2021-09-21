package com.codecool.dungeoncrawl.logic.items;

import com.codecool.dungeoncrawl.logic.Cell;
import com.codecool.dungeoncrawl.logic.Drawable;

public abstract class Item implements Drawable {
    protected Cell cell;


    public Item(Cell cell) {
        this.cell = cell;
        if (cell != null) {
            this.cell.setItem(this);
        }
    }


    public Cell getCell() {
        return cell;
    }
}