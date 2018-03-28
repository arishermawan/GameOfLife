package com.gojek.bootcamp.drillv3;

public class Main {
    public static void main(String[] args) throws InterruptedException {
        int[][] seedsMap = {
                {1, 5}, {2, 5}, {1, 6}, {2, 6}, {11, 5}, {11, 6}, {11, 7}, {12, 4}, {13, 3}, {14, 3},
                {12, 8}, {13, 9}, {14, 9}, {15, 6}, {16, 4}, {17, 5}, {17, 6}, {17, 7}, {18, 6}, {16, 8},
                {21, 3}, {21, 4}, {21, 5}, {22, 3}, {22, 4}, {22, 5}, {23, 2}, {23, 6}, {25, 1}, {25, 2},
                {25, 6}, {25, 7}, {35, 3}, {35, 4}, {36, 3}, {36, 4}
        };

        Universe world = new Universe(10,40);
        for (int i = 0; i < seedsMap.length; i++ ){
            world.setSeed(seedsMap[i][1], seedsMap[i][0]);
        }
        world.printGrid();
        boolean x = true;
        while (x){
            world.nextGeneration();
            world.printGrid();
            Thread.sleep(400);
            System.out.println();
            System.out.println();
        }
    }
}
