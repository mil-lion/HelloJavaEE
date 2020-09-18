/*
 * File:    TinyCalculator2IT.java
 * Project: TinyCalculator
 * Date:    Dec 27, 2018 11:25:57 PM
 * Author:  Igor Morenko <morenko at lionsoft.ru>
 * 
 * Copyright 2005-2018 LionSoft LLC. All rights reserved.
 */
package ru.lionsoft.javaee.jsf.tinycalculator;

import org.junit.jupiter.api.AfterAll;
import static org.junit.jupiter.api.Assertions.assertEquals;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;

/**
 *
 * @author Igor Morenko <morenko at lionsoft.ru>
 */
public class TinyCalculator2IT {
    
    private static WebDriver driver;
    
    public TinyCalculator2IT() {
    }

    @BeforeAll
    public static void setUpClass() {
        System.setProperty("webdriver.gecko.driver", "/Users/mil/bin/geckodriver");
        // Create a new instance of the Firefox driver
        // Notice that the remainder of the code relies on the interface, 
        // not the implementation.
        driver = new FirefoxDriver();
    }
    
    @AfterAll
    public static void tearDownClass() {
        // Close the browser
        if (driver != null) {
            driver.quit();
        }
    }
    
    @BeforeEach
    public void setUp() {
        driver.get("http://localhost:8080/Calculator/index.html");
        setValue("form:param1", "6");
        setValue("form:param2", "4");
    }

    private void setValue(String id, String value) {
        WebElement element = driver.findElement(By.id(id));
        element.clear();
        element.sendKeys(value);
    }

    /**
     * Test of add method, of class TinyCalculator.
     */
    @Test
    public void testAdd() {
        driver.findElement(By.id("form:add")).click();
        String text = driver.findElement(By.id("form:result")).getText();
        assertEquals("10.0", text);
    }
    
    /**
     * Test of subtract method, of class TinyCalculator.
     */
    @Test
    public void testSubtract() {
        driver.findElement(By.id("form:sub")).click();
        String text = driver.findElement(By.id("form:result")).getText();
        assertEquals("2.0", text);
    }
    
    /**
     * Test of multiply method, of class TinyCalculator.
     */
    @Test
    public void testMultiply() {
        driver.findElement(By.id("form:mul")).click();
        String text = driver.findElement(By.id("form:result")).getText();
        assertEquals("24.0", text);
    }
    
    /**
     * Test of divide method, of class TinyCalculator.
     */
    @Test
    public void testDivide() {
        driver.findElement(By.id("form:div")).click();
        String text = driver.findElement(By.id("form:result")).getText();
        assertEquals("1.5", text);
    }
        
}
