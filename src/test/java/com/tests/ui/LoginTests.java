package com.tests.ui;

import com.company.pageObjects.HomePage;
import com.company.pageObjects.LoginPage;
import org.testng.Assert;
import org.testng.annotations.Test;

public class LoginTests extends BaseTest {

    @Test(description = "Login test")
    public void loginTest() {
        driver.get("https://freelance.lsrv.in.ua/home");
        HomePage homePage = new HomePage(driver);
        homePage.goToLoginPage();
        LoginPage loginPage = new LoginPage(driver);
        loginPage
                .setUserName("Nastya")
                .setPassword("passwordN")
                .clickLoginButton();
        String URL = driver.getCurrentUrl();
        Assert.assertEquals(URL, "https://freelance.lsrv.in.ua/main" );
    }
}
