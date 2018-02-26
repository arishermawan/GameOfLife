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

}
