package com.gojek.bootcamp.drillv3;

public class Universe {
    private int[][] grid;

    public Universe(int height, int width) {
        this.grid = new int[height][width];
        initializeGrid();
    }

    public String viewGrid(){
        String gridString = "";
        for(int height = 0; height < grid.length; height++){
            for (int width = 0; width< grid[height].length; width++){
                gridString += grid[height][width];
            }
            gridString += "\n";
        }
        return gridString;
    }

    public void initializeGrid(){
        for(int height = 0; height < grid.length; height++){
            for (int width = 0; width< grid[height].length; width++){
                grid[height][width] = 0;
            }
        }
    }
}
