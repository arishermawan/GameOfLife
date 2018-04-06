package com.gojek.bootcamp.drillv3;

/*
* Handle re-generation of population based on neighbours quantity
 */

public class Evolution {

    private Cell[][] grid;

    public Evolution(Cell[][] grid) {
        this.grid = grid;
    }

    public int countNeighbours(int height, int width) {
        int totalNeighbours = 0;
            int[][] neighboursLocation = { {0,1}, {0,-1}, {-1,-1}, {-1,0}, {-1,1}, {1,-1}, {1,0}, {1,1} };
            for (int[] neighbour : neighboursLocation) {
                int positionX = height + neighbour[0];
                int positionY = width + neighbour[1];
                if (isValidAndAliveCell(positionX, positionY)) {
                     totalNeighbours += 1;
                }
            }
        return totalNeighbours;
    }

    private boolean isValidAndAliveCell(int newHeight, int newWidth) {
        return isValidCell(newHeight, newWidth) && isAliveCell(grid[newHeight][newWidth]);
    }

    private boolean isAliveCell(Cell cell) {
        return cell.isAlive();
    }

    private boolean isValidCell(int newHeight, int newWidth) {
        return newHeight > 0 && newHeight < grid.length - 1 && newWidth > 0 && newWidth < grid[0].length - 1;
    }

    private boolean isCellReachMaxWidth() {
        boolean cellAlmostReachMaxWidth = false;
        for (Cell[] cell : grid) {
            if (isAliveCell(cell[grid[0].length - 1])) cellAlmostReachMaxWidth = true;
        }
        return cellAlmostReachMaxWidth;
    }

    private boolean isCellReachMaxHeight() {
        boolean cellAlmostReachMaxHeight = false;
        for (int i = 0; i < grid[0].length; i++) {
            if (isAliveCell(grid[grid.length - 1][i])) cellAlmostReachMaxHeight = true;
        }
        return cellAlmostReachMaxHeight;
    }

    private void expandGrid(int newHeight, int newWidth) {
        Universe newWorld = new Universe(newHeight, newWidth);
        for (int i = 0; i < grid.length; i++) {
            System.arraycopy(grid[i], 0, newWorld.grid[i], 0, grid[0].length);
        }
        this.grid = newWorld.grid;
    }

    public Cell[][] nextGeneration() {
        int newWidth = grid[0].length;
        int newHeight = grid.length;

        if (isCellReachMaxWidth() || isCellReachMaxHeight()) {
            if (isCellReachMaxHeight()) newHeight += 1;
            if (isCellReachMaxWidth()) newWidth += 1;
            expandGrid(newHeight, newWidth);
        }

        Universe tempUniverse = new Universe(grid.length, grid[0].length);
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                int neighbours = countNeighbours(i, j);
                tempUniverse.grid[i][j] = grid[i][j].evolve(neighbours);
            }
        }
        return tempUniverse.grid;
    }
}
