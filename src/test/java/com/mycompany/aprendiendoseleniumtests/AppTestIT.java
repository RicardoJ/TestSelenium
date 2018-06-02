/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.aprendiendoseleniumtests;

import com.mycompany.aprendiendoseleniumtests.helpers.Helpers;
import org.junit.AfterClass;

import static org.junit.Assert.*;
import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.junit.Assert;
import pages.PageLogin;

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
        driver.get("http://newtours.demoaut.com/");
        Helpers helper = new Helpers();
        helper.sleepSeconds(2);

    }

    @Test
    public void testLogin() {

        PageLogin pageLogin = new PageLogin(driver);
        pageLogin.login("user", "user");
        Assert.assertTrue(driver.findElement(By.xpath("/html/body/div/table/tbody/tr/td[2]/table/tbody/tr[4]/td/table/tbody/tr/td[2]/table/tbody/tr[3]/td/p/font/b")).getText().contains("Welcome back to"));

    }

    @AfterClass
    public static void tearDown() {
        driver.close();

    }

}
