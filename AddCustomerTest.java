package com.nimap.tests;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.nimap.base.BaseTest;
import com.nimap.pages.CustomerPage;
import com.nimap.pages.DashboardPage;
import com.nimap.pages.LoginPage;

import org.testng.Assert;

public class AddCustomerTest extends BaseTest{
	@DataProvider(name = "customerData")
    public Object[][] customerData() {
        return new Object[][] {
            {"Akshay", "Akshay@example.com"},
            {"Bhushan", "Bhushan@example.com"}
        };
    }

    @Test(dataProvider = "customerData")
    public void testAddCustomer(String name, String email) {
        LoginPage loginPage = new LoginPage(driver);
        DashboardPage dashboard = loginPage.login("user1@example.com", "password1");

        CustomerPage customerPage = new CustomerPage(driver);
        customerPage.addCustomer(name, email);

        String successMsg = customerPage.getSuccessMessage();
        Assert.assertEquals(successMsg, "Customer added successfully", "Add Customer failed");
    }

}
