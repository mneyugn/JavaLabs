package main.zad5;

import org.junit.Test;

public class TestSuite5 {


    @Test(timeout = 1500)
    public void testWithTimeout() {
        new SortAlg();
    }
}