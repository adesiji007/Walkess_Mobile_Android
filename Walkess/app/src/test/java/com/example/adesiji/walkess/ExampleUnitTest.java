package com.example.adesiji.Walkess;

import org.junit.Test;

import static org.junit.Assert.*;

/**
 * To work on unit tests, switch the Test Artifact in the Build Variants view.
 */
public class ExampleUnitTest {
    protected double fValue1;
    protected double fValue2;

    protected void setUp() {
        fValue1= 2.0;
        fValue2= 3.0;
    }

    public void testAdd() {
        double result= fValue1 + fValue2;
        assertTrue(result == 5.0);
    }

    TestCase test= new MathTest("testAdd");
    test.run();
}