package com.nimap.pages;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class DashboardPage {
	private WebDriver driver;
    private WebDriverWait wait;

    // Example locator for PunchIn button and toast message
    private By punchInButton = By.id("punchInBtn");
    private By toastMessage  = By.cssSelector(".toast-message");

    public DashboardPage(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(10));
    }

    public void punchIn() {
        wait.until(ExpectedConditions.elementToBeClickable(punchInButton)).click();
    }

    public String getToastMessage() {
        return wait.until(ExpectedConditions.visibilityOfElementLocated(toastMessage)).getText();
    }

}
