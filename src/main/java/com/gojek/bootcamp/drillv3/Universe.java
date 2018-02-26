package com.gojek.bootcamp.drillv3;
/*
 This class represent generation of cell in game of life
 */
public class Universe {
    private int[][] grid;

    public Universe(int height, int width) {
        this.grid = new int[height][width];
        initializeGrid();
    }

    public String viewGrid() {
        String gridString = "";
        for (int height = 0; height < grid.length; height++) {
            for (int width = 0; width < grid[height].length; width++) {
                gridString += grid[height][width];
            }
            gridString += "\n";
        }
        return gridString;
    }

    public void initializeGrid() {
        for (int height = 0; height < grid.length; height++) {
            for (int width = 0; width < grid[height].length; width++) {
                grid[height][width] = 0;
            }
        }
    }

    public void printGrid(){
        for (int i = 0; i < grid.length; i++){
            System.out.print("|");
            for(int j = 0; j< grid[i].length; j++){
                if (grid[i][j] == 1 ){
                    System.out.print("0");
                }else{
                    System.out.print(" ");
                }
            }
            System.out.println("|");
        }
    }

    public int countNeighbours(int height, int width) {
        int neighbours = 0;
        if (height > 0 && height < grid.length - 1 && width > 0 && width < grid[height].length - 1) {
            if (grid[height][width + 1] == 1) neighbours += 1;
            if (grid[height][width - 1] == 1) neighbours += 1;

            if (grid[height - 1][width - 1] == 1) neighbours += 1;
            if (grid[height - 1][width] == 1) neighbours += 1;
            if (grid[height - 1][width + 1] == 1) neighbours += 1;

            if (grid[height + 1][width - 1] == 1) neighbours += 1;
            if (grid[height + 1][width] == 1) neighbours += 1;
            if (grid[height + 1][width + 1] == 1) neighbours += 1;
        }
        return neighbours;
    }

    public int rules(int cell, int neighbours) {
        int newCell = 0;
        if (cell == 1){
            if (neighbours >= 2 && neighbours <=3) newCell = 1;
        }else{
            if(neighbours == 3) newCell = 1;
        }
        return newCell;
    }

    public void nextGeneration() {
        int height = grid.length;
        int width = grid[0].length;

        boolean cellReachMaxWidth = false;
        boolean cellReachMaxHeight = false;
        int newWidth = width;
        int newHeigth = height;
        for (int i = 0; i < height; i++) {
            if (grid[i][width - 2] == 1) cellReachMaxWidth = true;
        }

        for (int i = 0; i < width; i++) {
            if (grid[height - 2][i] == 1) cellReachMaxHeight = true;
        }

        if (cellReachMaxWidth || cellReachMaxHeight) {
            if (cellReachMaxHeight) newHeigth = height + 1;
            if (cellReachMaxWidth) newWidth = width + 1;
            Universe newWorld = new Universe(newHeigth, newWidth);
            for (int i = 0; i < height; i++) {
                for (int j = 0; j < width; j++) {
                    newWorld.grid[i][j] = grid[i][j];
                }
            }

            this.grid = newWorld.grid;
        }

        height = grid.length;
        width = grid[0].length;

        Universe tempUniverse = new Universe(height, width);
        for (int i = 0; i < height; i++) {
            for (int j = 0; j < width; j++) {
                int neighbours = countNeighbours(i, j);
                tempUniverse.grid[i][j] = rules(grid[i][j], neighbours);
            }
        }

        for (int i = 0; i < height; i++) {
            for (int j = 1; j < width; j++) {
                grid[i][j] = tempUniverse.grid[i][j];
            }
        }
    }

    @Override
    public boolean equals(Object obj) {
        if(obj == null || this.getClass() != obj.getClass()) return false;
        Universe otherUniverse = (Universe) obj;
        return this.grid.length == otherUniverse.grid.length && this.grid[0].length == otherUniverse.grid[0].length;
    }

    @Override
    public int hashCode() {
        int prime = 31;
        return prime * grid.length * grid[0].length;
    }

    public void blinker() {
        this.grid[2][1] = 1;
        this.grid[2][2] = 1;
        this.grid[2][3] = 1;
    }

    public void block() {
        this.grid[3][2] = 1;
        this.grid[3][3] = 1;
        this.grid[2][2] = 1;
        this.grid[2][3] = 1;
    }

    public void glider() {
        grid[1][1] = 1;
        grid[2][2] = 1;
        grid[2][3] = 1;
        grid[3][1] = 1;
        grid[3][2] = 1;
    }
}
