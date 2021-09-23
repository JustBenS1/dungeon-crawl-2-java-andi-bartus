package com.codecool.dungeoncrawl.logic.actors;

import com.codecool.dungeoncrawl.logic.Cell;

public class Gangsta extends Actor {
    public Gangsta(Cell cell) {
        super(cell);
        this.damage = 5;
        this.coinValue = 25;
        this.health = 30;
    }

    @Override
    public String getTileName() {
        return "gangsta";
    }

    @Override
    public void move(){
        cell.gangstaMovement(this);
    }
}
