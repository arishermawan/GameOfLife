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
        cell.revive();
        assertThat(cell.isAlive(), is(equalTo(true)));
    }

    @Test
    public void aliveCellWithLessThanTwoNeighboursShouldBeDeadInNextGeneration(){
        Cell cell = new Cell();
        Cell deadCell = new Cell();
        cell.revive();
        int neightbours = 1;
        Cell newCell = cell.evolve(neightbours);
        assertThat(newCell.isAlive(), equalTo(deadCell.isAlive()));
    }

    @Test
    public void aliveCellWithBetweenTwoAndThreeNeighboursShouldBeAliveInNextGeneration(){
        Cell cell = new Cell();
        cell.revive();
        int neightbours = 2;
        Cell newCell = cell.evolve(neightbours);
        assertThat(cell.isAlive(), equalTo(newCell.isAlive()));
    }

    @Test
    public void aliveCellGreaterThanThreeNeighboursShouldBeDeadInNextGeneration(){
        Cell cell = new Cell();
        Cell deadCell = new Cell();
        cell.revive();
        int neightbours = 4;
        Cell newCell = cell.evolve(neightbours);
        assertThat(deadCell.isAlive(), equalTo(newCell.isAlive()));
    }

    @Test
    public void deadCellWithThreeNeighboursShouldBeAliveInNextGeneration(){
        Cell cell = new Cell();
        Cell aliveCell = new Cell();
        aliveCell.revive();
        int neightbours = 3;
        Cell newCell = cell.evolve(neightbours);
        assertThat(aliveCell.isAlive(), equalTo(newCell.isAlive()));
    }

}