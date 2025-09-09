package com.nimap.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.time.Duration;

public class CustomerPage {
	private WebDriver driver;
    private WebDriverWait wait;

    private By addCustomerButton = By.id("addCustomerBtn");
    private By nameField        = By.name("customerName");
    private By emailField       = By.name("customerEmail");
    private By saveButton       = By.cssSelector("button[type='submit']");
    private By successMsg       = By.cssSelector(".toast-message");

    public CustomerPage(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(10));
    }

    public void clickAddCustomer() {
        wait.until(ExpectedConditions.elementToBeClickable(addCustomerButton)).click();
    }

    public void addCustomer(String name, String email) {
        clickAddCustomer();
        wait.until(ExpectedConditions.visibilityOfElementLocated(nameField)).sendKeys(name);
        driver.findElement(emailField).sendKeys(email);
        driver.findElement(saveButton).click();
    }

    public String getSuccessMessage() {
        return wait.until(ExpectedConditions.visibilityOfElementLocated(successMsg)).getText();
    }

}
