package com.nimap.tests;

import org.testng.annotations.Test;

import com.nimap.base.BaseTest;
import com.nimap.pages.DashboardPage;
import com.nimap.pages.LoginPage;

import org.testng.Assert;

public class PunchInTest extends BaseTest{
	@Test
    public void testPunchInToast() {
        LoginPage loginPage = new LoginPage(driver);
        DashboardPage dashboard = loginPage.login("user1@example.com", "password1");

        dashboard.punchIn();
        String toast = dashboard.getToastMessage();
        Assert.assertEquals(toast, "PunchIn successful", "PunchIn toast message mismatch");
    }
}
