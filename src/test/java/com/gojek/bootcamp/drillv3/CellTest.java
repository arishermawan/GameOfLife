package com.gojek.bootcamp.drillv3;

import org.junit.Test;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.*;

public class CellTest {
    @Test
    public void cellShouldReturnStatus(){
        Cell cell = new Cell();
        assertThat(cell.isAlive(), is(equalTo(false)));
    }

    @Test
    public void cellShouldReturnStatusWhenAlive(){
        Cell cell = new Cell();
        cell.reviveCell();
        assertThat(cell.isAlive(), is(equalTo(true)));
    }

}