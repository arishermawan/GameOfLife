package com.gojek.bootcamp.drillv3;

import org.junit.Test;
import static org.hamcrest.CoreMatchers.*;
import static org.junit.Assert.*;

public class UniverseTest {
    @Test
    public void gridShouldBeRetunString(){
        Universe world = new Universe(3,3);
        assertThat(world.viewGrid(), equalTo("000\n000\n000\n"));
    }

    @Test
    public void zeroGridShouldBeReturnEmptyString(){
        Universe world = new Universe(0,0);
        assertThat(world.viewGrid(), equalTo(""));
    }

    @Test
    public void anotherSizeOfGridShouldBeReturnString(){
        Universe world = new Universe(2,2);
        assertThat(world.viewGrid(), equalTo("00\n00\n"));
    }

    @Test
    public void GridShouldBeInitializedWithString(){
        Universe world = new Universe(2,2);
        assertThat(world.viewGrid(), equalTo("00\n00\n"));
    }
    @Test
    public void blinkerShouldBeSetGridWithBlinkerPattern(){
        Universe world = new Universe(5,5);
        world.blinker();
        assertThat(world.viewGrid(), equalTo("00000\n00000\n01110\n00000\n00000\n"));
    }

    @Test
    public void blockShouldBeSetGridWithBlockPattern(){
        Universe world = new Universe(5,5);
        world.block();
        assertThat(world.viewGrid(), equalTo("00000\n00000\n00110\n00110\n00000\n"));
    }

    @Test
    public void cellInGridShouldCountItsNeighbours(){
        Universe world = new Universe(5,5);
        world.blinker();
        assertThat(world.countNeighbours(2,2), equalTo(2));
    }

    @Test
    public void cellInGridShouldCountItsNeighboursInTopRow(){
        Universe world = new Universe(5,5);
        world.blinker();
        assertThat(world.countNeighbours(3,2), equalTo(3));
    }

    @Test
    public void cellInGridShouldCountItsNeighboursInBottomRow(){
        Universe world = new Universe(5,5);
        world.blinker();
        assertThat(world.countNeighbours(1,2), equalTo(3));
    }

    @Test
    public void topMarginGridShouldNotBeCountNeighbour(){
        Universe world = new Universe(5,5);
        world.blinker();
        assertThat(world.countNeighbours(0,2), equalTo(0));
    }

    @Test
    public void bottomMarginGridShouldNotBeCountNeighbour(){
        Universe world = new Universe(5,5);
        world.blinker();
        assertThat(world.countNeighbours(4,2), equalTo(0));
    }

    @Test
    public void leftMarginGridShouldNotBeCountNeighbour(){
        Universe world = new Universe(5,5);
        world.blinker();
        assertThat(world.countNeighbours(2,0), equalTo(0));
    }

    @Test
    public void rightMarginGridShouldNotBeCountNeighbour(){
        Universe world = new Universe(5,5);
        world.blinker();
        assertThat(world.countNeighbours(2,4), equalTo(0));
    }

    @Test
    public void aliveCellWithLessThanTwoNeighboursShouldBeDeadInNextGeneration(){
        Universe world = new Universe(5,5);
        world.blinker();
        int cell = 1;
        int neightbours = world.countNeighbours(2,1);
        int newCell = world.rules(cell, neightbours);
        assertThat(newCell, equalTo(0));
    }

    @Test
    public void aliveCellWithBetweenTwoAndThreeNeighboursShouldBeAliveInNextGeneration(){
        Universe world = new Universe(5,5);
        world.blinker();
        int cell = 1;
        int neightbours = world.countNeighbours(2,2);
        int newCell = world.rules(cell, neightbours);
        assertThat(newCell, equalTo(1));
    }

    @Test
    public void aliveCellGreaterThanThreeNeighboursShouldBeDeadInNextGeneration(){
        Universe world = new Universe(5,5);
        world.block();
        world.blinker();
        int cell = 1;
        int neightbours = world.countNeighbours(2,2);
        int newCell = world.rules(cell, neightbours);
        assertThat(newCell, equalTo(0));
    }

    @Test
    public void deadCellWithThreeNeighboursShouldBeAliveInNextGeneration(){
        Universe world = new Universe(6,6);
        world.block();
        world.blinker();
        int cell = 0;
        int neightbours = world.countNeighbours(3,1);
        int newCell = world.rules(cell, neightbours);
        assertThat(newCell, equalTo(1));
    }

    @Test
    public void blickerShouldBeRotate90DeegreWhenGeneration(){
        Universe world = new Universe(5,5);
        world.blinker();
        world.nextGeneration();
        assertThat(world.viewGrid(), equalTo("00000\n00100\n00100\n00100\n00000\n"));
    }

    @Test
    public void UniverseObjectWithSameSizeShoudBeEqual(){
        Universe world1 = new Universe(5,5);
        Universe world2 = new Universe(5,5);
        assertThat(world1.equals(world2), equalTo(true));
    }

    @Test
    public void NullWithUniverseObjectShoudNotBeEqual(){
        Universe world1 = new Universe(5,5);
        assertThat(world1.equals(null), equalTo(false));
    }

    @Test
    public void StringWithUniverseObjectShoudNotBeEqual(){
        Universe world1 = new Universe(5,5);
        assertThat(world1.equals("Grid"), equalTo(false));
    }

    @Test
    public void UniverseObjectWithDifferentHeightSizeShoudNotBeEqual(){
        Universe world1 = new Universe(4,4);
        Universe world2 = new Universe(5,5);
        assertThat(world1.equals(world2), equalTo(false));
    }

    @Test
    public void UniverseObjectWithDifferentWidthSizeShoudNotBeEqual(){
        Universe world1 = new Universe(5,4);
        Universe world2 = new Universe(5,5);
        assertThat(world1.equals(world2), equalTo(false));
    }

    @Test
    public void UniverseObjectWithDifferentSizeShoudHaveDifferentHashcode(){
        Universe world1 = new Universe(5,4);
        Universe world2 = new Universe(5,5);
        assertThat(world1.hashCode(), not(equalTo((world2.hashCode()))));
    }

    @Test
    public void UniverseObjectWithSameSizeShoudHaveSameHashcode(){
        Universe world1 = new Universe(5,5);
        Universe world2 = new Universe(5,5);
        assertThat(world1.hashCode(), is(equalTo((world2.hashCode()))));
    }
}
