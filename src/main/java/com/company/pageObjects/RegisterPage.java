package com.company.pageObjects;

import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class RegisterPage extends BasePage {

    public RegisterPage(WebDriver driver) {
        super(driver);
        PageFactory.initElements(driver, this);
        wait.until(ExpectedConditions.visibilityOf(lastNameInput));
    }

    @FindBy(xpath = "//input[@formcontrolname='username']")
    private WebElement userNameInput;

    @FindBy(xpath = "//input[@formcontrolname='name']")
    private WebElement nameInput;

    @FindBy(xpath = "//input[@formcontrolname='lastname']")
    private WebElement lastNameInput;

    @FindBy(xpath = "//input[@formcontrolname='password']")
    private WebElement passwordInput;

    @FindBy(xpath = "//input[@formcontrolname='confirmPassword']")
    private WebElement confirmPasswordInput;

    @FindBy(xpath = "//button[@class='mat-focus-indicator mat-flat-button mat-button-base mat-primary']")
    private WebElement registerButton;

    @FindBy(xpath = "//*[text()[contains(.,'successfully!')]]")
    private WebElement message;

    @Step("Set UserName")
    public RegisterPage setUserName(String userName) {
        setValue(userNameInput, userName);
        return this;
    }

    @Step("Set name")
    public RegisterPage setName(String name) {
        setValue(nameInput, name);
        return this;
    }

    @Step("Set lastName")
    public RegisterPage setLastName(String lastName) {
        setValue(lastNameInput, lastName);
        return this;
    }

    @Step("Set Password")
    public RegisterPage setPassword(String password) {
        setValue(passwordInput, password);
        return this;
    }

    @Step("Set Confirm Password")
    public RegisterPage setConfirmPassword(String confirmPassword) {
        setValue(confirmPasswordInput, confirmPassword);
        return this;
    }

    @Step("Click Register button")
    public LoginPage clickRegisterButton() throws InterruptedException {
        JavascriptExecutor ex = (JavascriptExecutor)driver;
        ex.executeScript("arguments[0].click();", registerButton);
        return new LoginPage(driver);
    }

    @Step("Get message")
    public String getMessage() {
        WebDriverWait wait = new WebDriverWait(driver, 15);
        wait.until(ExpectedConditions.visibilityOfAllElements(message));
        return message.getText();
    }
}
