/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pages;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import org.openqa.selenium.support.ui.Select;


/**
 *
 * @author DiazHerrera
 */
public class PageReservation {
      private WebDriver driver;
      private By paragraphText;
      private By passengersDrop;
      private By fromDrop;
      private By toPort;
      public PageReservation (WebDriver driver){
        this.driver= driver;
        paragraphText = By.xpath("/html/body/div/table/tbody/tr/td[2]/table/tbody/tr[4]/td/table/tbody/tr/td[2]/table/tbody/tr[3]/td/font");
        passengersDrop = By.name("passCount");
        fromDrop = By.name("fromPort");
        toPort = By.name("toPort");
    }
      
    
    public void assertPage(){
     
      
         Assert.assertTrue(driver.findElement(paragraphText).getText().contains("Flight Finder to search"));
        
    }
    public void selectPassengers(int cantidad){
        Select selectPasajeros = new Select(driver.findElement(passengersDrop));
        selectPasajeros.selectByVisibleText(Integer.toString(cantidad));
    }
    public void selectFromPort(int index){
        Select selectFrom = new Select(driver.findElement(fromDrop));
        selectFrom.selectByIndex(index);
    }
    public void selectToPort(String valor){
        Select selectToPort = new Select(driver.findElement(toPort));
        selectToPort.selectByValue(valor
        );
        
    }
}
