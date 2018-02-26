package com.gojek.bootcamp.drillv3;

public class Universe {
    private int[][] grid;

    public Universe(int height, int width) {
        this.grid = new int[height][width];
    }

    public String viewGrid(){
        String gridString = "";
        if(grid.length>0) gridString += "000\n000\n000\n";
        return gridString;
    }
}
