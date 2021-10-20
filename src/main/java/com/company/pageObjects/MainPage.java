package com.company.pageObjects;

import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;

import java.util.zip.ZipEntry;

public class MainPage extends BasePage {
    public MainPage(WebDriver driver) {
        super(driver);
        PageFactory.initElements(driver, this);
        wait.until(ExpectedConditions.visibilityOf(jobCard));
    }

    @FindBy(xpath = "//mat-card[1]")
    private WebElement jobCard;

    private String viewInfoButtonOnJobCardFormat = "//mat-card-title[contains(., '%s')]/ancestor::mat-card[1]" +
            "/descendant::mat-card-subtitle[@class='mat-card-subtitle price' and contains(., '%s')]/ancestor::mat-card[1]" +
            "/descendant::mat-card-content/p[contains(., '%s')]/ancestor::mat-card[1]" +
            "/mat-card-actions/button/span[contains(., 'View info')]";

    @Step("Click View Info button")
    public MainPage clickViewInfoButton(String title, String description, int price) {
        String viewInfoButtonXPath = String.format(viewInfoButtonOnJobCardFormat, title, price, description);
        WebElement viewInfoButton = driver.findElement(By.xpath(viewInfoButtonXPath));
        viewInfoButton.click();
//        WebElement createdJobCard = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(viewInfoButtonOnJobCardFormat)));
//        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", viewInfoButtonOnJobCardFormat);
        return this;
    }
}


//    @Step("Click Create job button")
//    public ProfilePage clickCreateJobButton() {
//        wait.until(ExpectedConditions.visibilityOf(createJobButton));
//        JavascriptExecutor ex = (JavascriptExecutor) driver;
//        ex.executeScript("arguments[0].click();", createJobButton);
//        return this;
//    }
//
//    @Step("Check created job card is displayed")
//    public boolean isCreatedJobCardDisplayed(String title, String price, String description) {
//        String createdJobCardXpath = String.format(createdJobCardFormat, title, price, description);
//        WebElement createdJobCard = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(createdJobCardXpath)));
//        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", createdJobCard);
//        return isDisplayed(createdJobCard);
//    }