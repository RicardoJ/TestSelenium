/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pages;

import com.mycompany.aprendiendoseleniumtests.helpers.Helpers;
import java.util.concurrent.TimeUnit;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

/**
 *
 * @author DiazHerrera
 */
public class PageLogin {
    private WebDriver driver;
    private By userField;
    private By passwordField;
    private By loginButton;
    public PageLogin(WebDriver driver){
        this.driver=driver;
        userField = By.name("userName");
        passwordField = By.name("password");
        loginButton =By.name("login");
    }
    public void login (String user , String pass){
      
        driver.findElement(userField).sendKeys(user);
        driver.findElement(passwordField).sendKeys(pass);
        driver.findElement(loginButton).click();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        
//        Helpers helper = new Helpers();
//        helper.sleepSeconds(5);
    }
}
