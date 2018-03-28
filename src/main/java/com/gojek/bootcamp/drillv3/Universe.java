package com.gojek.bootcamp.drillv3;
/*
 This class represent generation of cell in game of life
 */
public class Universe {
    private Cell[][] grid;

    public Universe(int height, int width) {
        this.grid = new Cell[height][width];
        initializeGrid();
    }

    public String viewGrid() {
        String gridString = "";
        for (int height = 0; height < grid.length; height++) {
            for (int width = 0; width < grid[height].length; width++) {
                if (grid[height][width].isAlive()) {
                    gridString += "1";
                } else {
                    gridString += "0";
                }
            }
            gridString += "\n";
        }
        return gridString;
    }

    public void initializeGrid() {
        for (int height = 0; height < grid.length; height++) {
            for (int width = 0; width < grid[height].length; width++) {
                grid[height][width] = new Cell();
            }
        }
    }

    public void printGrid() {
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[i].length; j++) {
                if (grid[i][j].isAlive()) {
                    System.out.print("00");
                } else {
                    System.out.print("''");
                }
            }
            System.out.println("");
        }
    }

    public int countNeighbours(int height, int width) {
        int neighbours = 0;
        if (height > 0 && height < grid.length - 1 && width > 0 && width < grid[height].length - 1) {
            if (grid[height][width + 1].isAlive()) neighbours += 1;
            if (grid[height][width - 1].isAlive()) neighbours += 1;
            if (grid[height - 1][width - 1].isAlive()) neighbours += 1;
            if (grid[height - 1][width].isAlive()) neighbours += 1;
            if (grid[height - 1][width + 1].isAlive()) neighbours += 1;
            if (grid[height + 1][width - 1].isAlive()) neighbours += 1;
            if (grid[height + 1][width].isAlive()) neighbours += 1;
            if (grid[height + 1][width + 1].isAlive()) neighbours += 1;
        }
        return neighbours;
    }

    public boolean cellReachMaxWidth() {
        boolean cellAlmostReachMaxWidth = false;
        for (int i = 0; i < grid.length; i++) {
            if (grid[i][grid[0].length - 2].isAlive()) cellAlmostReachMaxWidth = true;
        }
        return cellAlmostReachMaxWidth;
    }

    public boolean cellReachMaxHeight() {
        boolean cellAlmostReachMaxHeight = false;
        for (int i = 0; i < grid[0].length; i++) {
            if (grid[grid.length - 2][i].isAlive()) cellAlmostReachMaxHeight = true;
        }
        return cellAlmostReachMaxHeight;
    }

    public void evolveGrid(int newHeight, int newWidth) {
        Universe newWorld = new Universe(newHeight, newWidth);
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                newWorld.grid[i][j] = grid[i][j];
            }
        }
        this.grid = newWorld.grid;
    }

    public void nextGeneration() {
        int newWidth = grid[0].length;
        int newHeight = grid.length;

        if (cellReachMaxWidth() || cellReachMaxHeight()) {
            if (cellReachMaxHeight()) newHeight = grid.length + 1;
            if (cellReachMaxWidth()) newWidth = grid[0].length + 1;
            evolveGrid(newHeight, newWidth);
        }

        Universe tempUniverse = new Universe(grid.length, grid[0].length);
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                int neighbours = countNeighbours(i, j);
                tempUniverse.grid[i][j] = grid[i][j].evolve(neighbours);
            }
        }
        this.grid = tempUniverse.grid;
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

    public void blinker() {
        this.grid[2][1].reviveCell();
        this.grid[2][2].reviveCell();
        this.grid[2][3].reviveCell();
    }

    public void block() {
        this.grid[3][2].reviveCell();
        this.grid[3][3].reviveCell();
        this.grid[2][2].reviveCell();
        this.grid[2][3].reviveCell();
    }

    public void glider() {
        grid[1][1].reviveCell();
        grid[2][2].reviveCell();
        grid[2][3].reviveCell();
        grid[3][1].reviveCell();
        grid[3][2].reviveCell();
    }

    public void setSeed(int i, int j){
        grid[i][j].reviveCell();
    }
}
