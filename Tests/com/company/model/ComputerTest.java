package com.company.model;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class ComputerTest {

    Computer computer;
    @Before
    public void before(){
        computer = new Computer();
    }

    @Test
    public void recordComposition(){
        computer.setCurrentDisk("disk1");
        computer.recordCompositionOnDisk("Song1");
        Assert.assertFalse(computer.getCompositions().isEmpty());
    }

    @Test (expected = IllegalArgumentException.class)
    public void recordCompositionWithWrongArg(){
        computer.setCurrentDisk("disk1");
        computer.recordCompositionOnDisk("Song1", "Song2");

    }

}