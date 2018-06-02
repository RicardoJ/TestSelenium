/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pages;

import com.mycompany.aprendiendoseleniumtests.helpers.Helpers;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

/**
 *
 * @author DiazHerrera
 */
public class PageLogin {
    private WebDriver driver;
    public PageLogin(WebDriver driver){
        this.driver=driver;
    }
    public void login (String user , String pass){
        driver.findElement(By.name("userName")).sendKeys(user);
        driver.findElement(By.name("password")).sendKeys(pass);
        driver.findElement(By.name("login")).click();

        Helpers helper = new Helpers();
        helper.sleepSeconds(2);
    }
}