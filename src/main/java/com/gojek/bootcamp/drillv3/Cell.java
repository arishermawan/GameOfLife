package com.gojek.bootcamp.drillv3;
/*
 Represent cell dead or alive in universe
 */

public class Cell {

    private int status;
T
    public Cell() {
        this.status = 0;
    }

    public boolean isAlive() {
        if (status == 1) {
            return true;
        } else {
            return false;
        }
    }

    public void revive() {
        this.status = 1;
    }

    public Cell evolve(int neighbours) {
        int newCell = 0;
        if (status == 1) {
            if (neighbours >= 2 && neighbours <= 3) newCell = 1;
        } else {
            if (neighbours == 3) newCell = 1;
        }
        Cell cell = new Cell();
        if (newCell == 1) {
            cell.revive();
            return cell;
        } else {
            return cell;
        }
    }

}
