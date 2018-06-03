/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pages;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

/**
 *
 * @author DiazHerrera
 */
public class PageVerificarLogin {
    private WebDriver driver;
    private By paragraphText;
    public PageVerificarLogin (WebDriver driver){
        this.driver= driver;
        paragraphText = By.xpath("/html/body/div/table/tbody/tr/td[2]/table/tbody/tr[4]/td/table/tbody/tr/td[2]/table/tbody/tr[3]/td/p/font/b");
    }
    
    public void assertVerificarLoginPage(){
         Assert.assertTrue(driver.findElement(paragraphText).getText().contains("Welcome back to"));
        
    }
}
