package com.company.pageObjects;

import io.qameta.allure.Step;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class HomePage extends BasePage {

    @FindBy(linkText = "Create account")
    private WebElement createAccountLink;

    @FindBy(linkText = "Log in")
    private WebElement logInLink;

    public HomePage(WebDriver driver) {
        super(driver);
        PageFactory.initElements(driver, this);
    }

    @Step("GoToRegister Page")
    public RegisterPage goToRegisterPage() {
        createAccountLink.click();
        return new RegisterPage(driver);
    }

    @Step("GoToLogin Page")
    public LoginPage goToLoginPage() {
        logInLink.click();
        return new LoginPage(driver);
    }
}