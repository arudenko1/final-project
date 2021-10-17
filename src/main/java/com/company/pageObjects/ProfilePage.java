package com.company.pageObjects;

import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class ProfilePage extends BasePage {

    public ProfilePage(WebDriver driver) {
        super(driver);
        PageFactory.initElements(driver, this);
        wait.until(ExpectedConditions.visibilityOf(editInfoButton));
    }

    @FindBy(xpath = "//span[text()='Edit Info']")
    private WebElement editInfoButton;

    @FindBy(xpath = "//input[@formcontrolname='name']")
    private WebElement userNameInput;

    @FindBy(xpath = "//input[@formcontrolname='lastname']")
    private WebElement lastNameInput;

    @FindBy(xpath = "//span[text()=' Update ']")
    private WebElement updateButton;

    @FindBy(xpath = "//h3[text()='New Name']")
    private WebElement editedName;

    @FindBy(xpath = "//div[@class='user-profile ng-star-inserted']/div[@class='row']/div[@class='col']/h3")
    private WebElement fullName;

    @FindBy(xpath = "//span[text()='Add job']")
    private WebElement addJobButton;

    @FindBy(xpath = "//input[@formcontrolname='title']")
    private WebElement jobTitleInput;

    @FindBy(xpath = "//textarea[@formcontrolname='description']")
    private WebElement jobDescriptionInput;

    @FindBy(xpath = "//input[@formcontrolname='price']")
    private WebElement jobPriceInput;

    @FindBy(xpath = "//span[text()=' Create job ']")
    private WebElement createJobButton;

    @FindBy(xpath = "//div[@class='mat-card-header-text']/mat-card-title")
    private WebElement jobTitle;

    @FindBy(xpath = "//p[@_ngcontent-xde-c58]")
    private WebElement jobDescription;

    @FindBy(xpath = "//mat-card-subtitle[@class='mat-card-subtitle price']")
    private WebElement jobPrice;

    private String createdJobCardFormat = "//mat-card/mat-card-header/div/mat-card-title[contains(., '%s')]" +
            "//following::mat-card-subtitle[@class='mat-card-subtitle price' and contains(., '%s')]" +
            "//following::mat-card-content/p[contains(., '%s')]";

    @Step
    public boolean isEditInfoButtonDisplayed() {
        return editInfoButton.isDisplayed();
    }

    @Step("Click Edit Info button")
    public ProfilePage clickEditInfoButton() {
        editInfoButton.click();
        return this;
    }

    @Step("Click Update button")
    public ProfilePage clickUpdateButton() {
        wait.until(ExpectedConditions.visibilityOf(updateButton));
        updateButton.click();
        return this;
    }

    @Step("Click Add job button")
    public ProfilePage clickAddJobButton() {
        wait.until(ExpectedConditions.visibilityOf(addJobButton));
        addJobButton.click();
        return this;
    }

    @Step("Set UserName")
    public ProfilePage setUserName(String userName) {
        wait.until(ExpectedConditions.visibilityOf(userNameInput));
        userNameInput.clear();
        setValue(userNameInput, userName);
        return this;
    }

    @Step("Set LastName")
    public ProfilePage setLastName(String lastName) {
        wait.until(ExpectedConditions.visibilityOf(lastNameInput));
        lastNameInput.clear();
        setValue(lastNameInput, lastName);
        return this;
    }

    @Step("Get name")
    public String getName() {
        return fullName.getText();
    }

    @Step("Set job title")
    public ProfilePage setJobTitle(String jobTitle) {
        wait.until(ExpectedConditions.visibilityOf(jobTitleInput));
        jobTitleInput.clear();
        setValue(jobTitleInput, jobTitle);
        return this;
    }

    @Step("Set job description")
    public ProfilePage setJobDescription(String jobDescription) {
        wait.until(ExpectedConditions.visibilityOf(jobDescriptionInput));
        jobDescriptionInput.clear();
        setValue(jobDescriptionInput, jobDescription);
        return this;
    }

    @Step("Set price for a job")
    public ProfilePage setJobPrice(String jobPrice) {
        wait.until(ExpectedConditions.visibilityOf(jobPriceInput));
        jobPriceInput.clear();
        setValue(jobPriceInput, jobPrice);
        return this;
    }

    @Step("Click Create job button")
    public ProfilePage clickCreateJobButton() {
        wait.until(ExpectedConditions.visibilityOf(createJobButton));
        JavascriptExecutor ex = (JavascriptExecutor) driver;
        ex.executeScript("arguments[0].click();", createJobButton);
        return this;
    }

    @Step("Check created job card is displayed")
    public boolean isCreatedJobCardDisplayed(String title, String price, String description) {
        String createdJobCardXpath = String.format(createdJobCardFormat, title, price, description);
        WebElement createdJobCard = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(createdJobCardXpath)));
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", createdJobCard);
        return isDisplayed(createdJobCard);
    }
}