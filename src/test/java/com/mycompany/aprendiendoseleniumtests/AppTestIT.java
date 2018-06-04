/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.aprendiendoseleniumtests;

import com.mycompany.aprendiendoseleniumtests.helpers.Helpers;
import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.junit.Assert;
import pages.PageLogin;
import pages.PageReservation;
import pages.PageVerificarLogin;

/**
 *
 * @author DiazHerrera
 */
public class AppTestIT {

    private static WebDriver driver;

    public AppTestIT() {
    }

    @BeforeClass
    public static void setUp() {
        DesiredCapabilities caps = new DesiredCapabilities();
        System.setProperty("webdriver.chrome.driver", "Drivers/chromedriver.exe");
        driver = new ChromeDriver();
        driver.manage().window();
        driver.navigate().to("http://newtours.demoaut.com/");
        Helpers helper = new Helpers();
        helper.sleepSeconds(2);

    }

    @Test
    public void testLogin() {

        PageLogin pageLogin = new PageLogin(driver);
        PageVerificarLogin verificarLogin = new PageVerificarLogin(driver);
        pageLogin.login("user", "user");
        verificarLogin.assertVerificarLoginPage();
            
    }
    @Test
    public void testLoginPassed() {

        PageLogin pageLogin = new PageLogin(driver);
        PageReservation pageReservation = new PageReservation(driver);
        pageLogin.login("mercury", "mercury");
        pageReservation.assertPage();
      

    }
    @Test
    public void testSeleecionarPasajeros(){
        PageLogin pageLogin = new PageLogin(driver);
        PageReservation pageReservation = new PageReservation(driver);
        pageLogin.login("mercury", "mercury");
        pageReservation.selectPassengers(2);
        pageReservation.selectFromPort(3);
        pageReservation.selectToPort("London");
    }

    @AfterClass
    public static void tearDown() {
        driver.close();

    }

}
