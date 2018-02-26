package com.gojek.bootcamp.drillv3;
/*
 Represent cell dead or alive in universe
 */

public class Cell {
    private int status;

    public Cell() {
        this.status = 0;
    }

    public boolean isAlive() {
        if(status == 1){
            return true;
        } else {
            return false;
        }
    }

    public void reviveCell(){
        this.status = 1;
    }

}
