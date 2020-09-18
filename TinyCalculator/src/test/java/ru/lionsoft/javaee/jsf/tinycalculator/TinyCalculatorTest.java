/*
 * File:    TinyCalculatorTest.java
 * Project: TinyCalculator
 * Date:    Dec 29, 2018 12:05:58 AM
 * Author:  Igor Morenko <morenko at lionsoft.ru>
 * 
 * Copyright 2005-2018 LionSoft LLC. All rights reserved.
 */
package ru.lionsoft.javaee.jsf.tinycalculator;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author Igor Morenko <morenko at lionsoft.ru>
 */
public class TinyCalculatorTest {
    
    TinyCalculator calculator;
    
    public TinyCalculatorTest() {
    }
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }
    
    @Before
    public void setUp() {
        calculator = new TinyCalculator();
        calculator.setParam1(6.0);
        calculator.setParam2(4.0);
    }
    
    @After
    public void tearDown() {
    }

    /**
     * Test of add method, of class TinyCalculator.
     */
    @Test
    public void testAdd() {
        System.out.println("add");
        double expResult = 10.0;
        calculator.add();
        double result = calculator.getResult();
        assertEquals(expResult, result, 0.0);
    }

    /**
     * Test of subtract method, of class TinyCalculator.
     */
    @Test
    public void testSubtract() {
        System.out.println("subtract");
        double expResult = 2.0;
        calculator.subtract();
        double result = calculator.getResult();
        assertEquals(expResult, result, 0.0);
    }

    /**
     * Test of multiply method, of class TinyCalculator.
     */
    @Test
    public void testMultiply() {
        System.out.println("multiply");
        double expResult = 24.0;
        calculator.multiply();
        double result = calculator.getResult();
        assertEquals(expResult, result, 0.0);
    }

    /**
     * Test of divide method, of class TinyCalculator.
     */
    @Test
    public void testDivide() {
        System.out.println("divide");
        double expResult = 1.5;
        calculator.divide();
        double result = calculator.getResult();
        assertEquals(expResult, result, 0.0);
    }

}
