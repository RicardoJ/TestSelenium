/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pages;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;

import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

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

    public PageReservation(WebDriver driver) {
        this.driver = driver;
        paragraphText = By.xpath("/html/body/div/table/tbody/tr/td[2]/table/tbody/tr[4]/td/table/tbody/tr/td[2]/table/tbody/tr[3]/td/font");
        passengersDrop = By.name("passCount");
        fromDrop = By.name("fromPort");
        toPort = By.name("toPort");
    }

    public void assertPage() {

        Assert.assertTrue(driver.findElement(paragraphText).getText().contains("Flight Finder to search"));

    }

    public void selectPassengers(int cantidad) {
        WebDriverWait wait = new WebDriverWait(driver, 5);
        WebElement passengerAmount = wait.until(ExpectedConditions.presenceOfElementLocated(passengersDrop));
        Select selectPasajeros = new Select(passengerAmount);
        selectPasajeros.selectByVisibleText(Integer.toString(cantidad));
    }

    public void selectFromPort(int index) {
        WebDriverWait wait = new WebDriverWait(driver, 5);
        WebElement elementSelectFrom = wait.until(ExpectedConditions.presenceOfElementLocated(fromDrop));
        Select selectFrom = new Select(elementSelectFrom);
        selectFrom.selectByIndex(index);
    }

    public void selectToPort(String valor) {
        WebDriverWait wait = new WebDriverWait(driver, 5);
        WebElement elementSelectToPort = wait.until(ExpectedConditions.presenceOfElementLocated(toPort));
        Select selectToPort = new Select(elementSelectToPort);
        selectToPort.selectByValue(valor);

    }
}
