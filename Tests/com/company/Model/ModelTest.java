package com.company.Model;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class ModelTest {

    Model model;
    @Before
    public void before(){
        model = new Model();
    }

    @Test
    public void recordComposition(){
        model.setCurrentDisk("disk1");
        model.recordCompositionOnDisk("Song1");
        Assert.assertFalse(model.getCompositions().isEmpty());
    }

    @Test (expected = IllegalArgumentException.class)
    public void recordCompositionWithWrongArg(){
        model.setCurrentDisk("disk1");
        model.recordCompositionOnDisk("Song1", "Song2");

    }

}