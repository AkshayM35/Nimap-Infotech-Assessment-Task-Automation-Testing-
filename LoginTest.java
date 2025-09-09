package com.nimap.tests;

import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.nimap.base.BaseTest;
import com.nimap.pages.DashboardPage;
import com.nimap.pages.LoginPage;

public class LoginTest extends BaseTest {

    @DataProvider(name = "loginData")
    public Object[][] loginData() {
        return new Object[][] {
            {"user1@example.com", "password1"},
            {"user2@example.com", "password2"}
        };
    }

    @Test(dataProvider = "loginData")
    public void testValidLogin(String username, String password) {
        LoginPage loginPage = new LoginPage(driver);
        DashboardPage dashboard = loginPage.login(username, password);

        String expectedUrl = "https://testffc.nimapinfotech.com/dashboard";
        Assert.assertEquals(driver.getCurrentUrl(), expectedUrl, "Login failed: URL mismatch!");
    }
}
