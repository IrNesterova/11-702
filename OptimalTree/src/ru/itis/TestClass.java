package ru.itis;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class TestClass {
    private int[][] nodes;

    @Before
    public void setUp() {
        nodes = new int[4][];
        nodes[0] = new int[]{8, 0, 0, 0, 0, 0, 0, 0, 0};
        nodes[1] = new int[]{3, 2, 0, 4, 0, 0, 0, 0, 0, 0};
        nodes[2] = new int[]{2, 0, 0, 0, 0, 4, 0};
        nodes[3] = new int[]{2, 0, 0};
    }

    @Test
    public void optimize() {
        Assert.assertEquals(2, Main.optimize(nodes[0], 4));
        Assert.assertEquals(3, Main.optimize(nodes[1], 2));
        Assert.assertEquals(2, Main.optimize(nodes[2], 2));
        Assert.assertEquals(0, Main.optimize(nodes[3], 3));
    }

    @Test (expected = IllegalArgumentException.class)
    public void badOptimize() {
        Main.optimize(nodes[0], 1);
    }
}

