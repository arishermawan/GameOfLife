package com.gojek.bootcamp.drillv3;

public class Main {
    public static void main(String[] args) throws InterruptedException {
        int[][] pattern = new Pattern().glider();

        Universe world = new Universe(0,0);
        world.setPattern(pattern);
        world.printGrid();
        System.out.println();
        System.out.println();
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
