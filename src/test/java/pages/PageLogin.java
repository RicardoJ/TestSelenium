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

        Helpers helper = new Helpers();
        helper.sleepSeconds(5);
    }
}
