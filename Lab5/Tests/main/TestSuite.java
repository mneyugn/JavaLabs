package main;

import main.zad2.TestSuite2_ExceptionTest;
import main.zad3.TestSuite3;
import main.zad4.TestSuite4;
import main.zad5.TestSuite5;
import org.junit.runner.RunWith;
import main.zad1.TestSuit1;
import main.zad2.TestSuite2;
import org.junit.runners.Suite;

@RunWith(Suite.class)

@Suite.SuiteClasses({
        TestSuit1.class,
        TestSuite2.class,
        TestSuite2_ExceptionTest.class,
        TestSuite3.class,
        TestSuite4.class,
        TestSuite5.class

})

public class TestSuite {
}