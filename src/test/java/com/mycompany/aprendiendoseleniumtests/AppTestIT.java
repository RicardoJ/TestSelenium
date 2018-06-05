/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.aprendiendoseleniumtests;



import java.util.concurrent.TimeUnit;
import org.junit.After;
import org.junit.Test;
import org.junit.Before;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.htmlunit.HtmlUnitDriver;
import com.gargoylesoftware.htmlunit.BrowserVersion;
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

    @Before
    public  void setUp() {
        DesiredCapabilities caps = new DesiredCapabilities();
      
        
        System.setProperty("webdriver.chrome.driver", "Drivers/chromedriver.exe");
        driver = new ChromeDriver();
        
       driver.manage().window();
        driver.navigate().to("http://newtours.demoaut.com/");
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);

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

    @After
    public  void tearDown() {
        driver.close();

    }

}
