package com.company.pageObjects;

import io.qameta.allure.Step;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class Header extends BasePage {

    public Header(WebDriver driver) {
        super(driver);
        PageFactory.initElements(driver, this);
        wait.until(ExpectedConditions.visibilityOf(userIcon));
    }

    @FindBy(xpath = "//mat-icon[@class='mat-icon notranslate mat-accent material-icons']")
    private WebElement userIcon;

    @FindBy(xpath = "//button[text()='Profile']")
    private WebElement profileButton;

    @FindBy(xpath = "//button[text()='Logout']")
    private WebElement logoutButton;

    @Step("Click user icon")
    public Header clickUserIcon() {
        userIcon.click();
        return this;
    }

    @Step("Click Profile button")
    public ProfilePage clickProfileButton() {
        profileButton.click();
        return new ProfilePage(driver);
    }

    @Step("Click Logout button")
    public HomePage clickLogoutButton() {
        logoutButton.click();
        return new HomePage(driver);
    }
}
