package com.gojek.bootcamp.drillv3;

public class Main {
    public static void main(String[] args) throws InterruptedException {
        Universe world = new Universe(10,10);

        world.glider();

        world.printGrid();
        boolean x = true;
        while (x){
            world.nextGeneration();
            world.printGrid();
            Thread.sleep(350);
            System.out.println("--------------------->");
        }
    }
}
