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
    public void cellInGridShouldCountItsNeighbours(){
        Universe world = new Universe(5,5);
        world.blinker();
        assertThat(world.countNeighbours(2,2), equalTo(2));
    }

}
