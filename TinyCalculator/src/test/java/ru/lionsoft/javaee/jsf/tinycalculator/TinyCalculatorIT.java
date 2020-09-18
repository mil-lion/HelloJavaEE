/*
 * File:    TinyCalculatorIT.java
 * Project: TinyCalculator
 * Date:    Dec 27, 2018 11:25:57 PM
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
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

/**
 *
 * @author Igor Morenko <morenko at lionsoft.ru>
 */
public class TinyCalculatorIT {
    
    private static WebDriver driver;
    
    public TinyCalculatorIT() {
    }

    @BeforeClass
    public static void setUpClass() {
        System.setProperty("webdriver.gecko.driver", "/Users/mil/bin/geckodriver");
        // Create a new instance of the Firefox driver
        // Notice that the remainder of the code relies on the interface, 
        // not the implementation.
        driver = new FirefoxDriver();
    }
    
    @AfterClass
    public static void tearDownClass() {
        // Close the browser
        if (driver != null) {
            driver.quit();
        }
    }
    
    @Before
    public void setUp() {
        driver.get("http://localhost:8080/Calculator/index.xhtml");
        setValue("form:param1", "6");
        setValue("form:param2", "4");
    }

    @After
    public void tearDown() {
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
//        WebElement element = driver.findElement(By.id("form:result"));
//        System.out.println("result = " + element);
//        String text = driver.findElement(By.id("form:result")).getText();
        // Anticipate web browser response, with an explicit wait
        WebDriverWait wait = new WebDriverWait(driver, 10);
        WebElement resultElement = wait.until(
            ExpectedConditions.presenceOfElementLocated(By.id("form:result"))
        );
        String text = resultElement.getText();
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
    
    // Sample
    
//    @Test
//    public void testSimple() throws Exception {
//        // Create a new instance of the Firefox driver
//        // Notice that the remainder of the code relies on the interface, 
//        // not the implementation.
//        WebDriver driver = new FirefoxDriver();
//
//        // And now use this to visit NetBeans
//        driver.get("http://www.netbeans.org");
//        // Alternatively the same thing can be done like this
//        // driver.navigate().to("http://www.netbeans.org");
//
//        // Check the title of the page
//        // Wait for the page to load, timeout after 10 seconds
//        (new WebDriverWait(driver, 10)).until(new ExpectedCondition<Boolean>() {
//            @Override
//            public Boolean apply(WebDriver d) {
//                return d.getTitle().contains("NetBeans");
//            }
//        });
//
//        //Close the browser
//        driver.quit();
//    }
    
}
