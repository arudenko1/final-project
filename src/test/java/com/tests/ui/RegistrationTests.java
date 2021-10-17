package com.tests.ui;

import com.company.pageObjects.HomePage;
import com.company.pageObjects.RegisterPage;
import com.github.javafaker.Faker;
import com.github.javafaker.Name;
import org.testng.Assert;
import org.testng.annotations.Test;

public class RegistrationTests extends BaseTest {

    Faker faker = new Faker();

    @Test(description = "Registration test")
    public void registrationTest() throws InterruptedException {
        driver.get("https://freelance.lsrv.in.ua/home");
        HomePage homePage = new HomePage(driver);
        homePage.goToRegisterPage();
        RegisterPage registerPage = new RegisterPage(driver);
        Name fakename = faker.name();
        registerPage
                .setUserName(fakename.username())
                .setName(fakename.name())
                .setLastName(fakename.lastName())
                .setPassword("passwordN")
                .setConfirmPassword("passwordN")
                .clickRegisterButton();
        Assert.assertTrue(registerPage.getMessage().contains("successfully!"));
    }
}
