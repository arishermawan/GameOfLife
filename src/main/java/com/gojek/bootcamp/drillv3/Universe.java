package com.gojek.bootcamp.drillv3;
/*
 This class represent generation of cell in game of life
 */
public class Universe {
    public Cell[][] grid;

    public Universe(int height, int width) {
        this.grid = new Cell[height][width];
        initializeGrid();
    }

    public String viewGrid() {
        StringBuilder gridString = new StringBuilder();
        for (Cell[] cells : grid) {
            for (Cell cell : cells) {
                if (cell.isAlive()) {
                    gridString.append("1");
                } else {
                    gridString.append("0");
                }
            }
            gridString.append("\n");
        }
        return gridString.toString();
    }

    private void initializeGrid() {
        for (int height = 0; height < grid.length; height++) {
            for (int width = 0; width < grid[height].length; width++) {
                grid[height][width] = new Cell();
            }
        }
    }

    public void printGrid() {
        for (Cell[] cells : grid) {
            for (Cell cell : cells) {
                if (cell.isAlive()) {
                    System.out.print("0");
                } else {
                    System.out.print("'");
                }
            }
            System.out.println("");
        }
    }


    @Override
    public boolean equals(Object obj) {
        if (obj == null || this.getClass() != obj.getClass()) return false;
        Universe otherUniverse = (Universe) obj;
        return this.grid.length == otherUniverse.grid.length && this.grid[0].length == otherUniverse.grid[0].length;
    }

    @Override
    public int hashCode() {
        int prime = 31;
        return prime * grid.length * grid[0].length;
    }

    public void nextGeneration(){
        Evolution evolution = new Evolution(this.grid);
        this.grid = evolution.nextGeneration();
    }

    public void setPattern(int[][] pattern){
        int xMax = 0;
        int yMax = 0;
        for (int[] aPattern : pattern) {
            if (xMax < aPattern[1]) {
                xMax = aPattern[1];
            }
            if (yMax < aPattern[0]) {
                yMax = aPattern[0];
            }
        }

        Universe world = new Universe(xMax+2,yMax+2);
        for (int[] patterns : pattern) {
            world.setSeed(patterns[1], patterns[0]);
        }
        this.grid = world.grid;
    }

    private void setSeed(int i, int j){
        grid[i][j].revive();
    }
}
