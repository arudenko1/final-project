package com.company.pageObjects;

import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class MainPage extends BasePage {
    public MainPage(WebDriver driver) {
        super(driver);
        PageFactory.initElements(driver, this);
        wait.until(ExpectedConditions.visibilityOf(jobCard));
    }

    @FindBy(xpath = "//mat-card[1]")
    private WebElement jobCard;

    @FindBy(xpath = "//textarea")
    private WebElement commentInput;

    @FindBy(xpath = "//span[text()=' Leave comment ']")
    private WebElement leaveCommentButton;

    @FindBy(xpath = "//mat-card[contains(@class, 'comment-card')]/mat-card-content/p")
    private WebElement comment;

    private String viewInfoButtonOnJobCardFormat = "//mat-card-title[contains(., '%s')]/ancestor::mat-card[1]" +
            "/descendant::mat-card-subtitle[@class='mat-card-subtitle price' and contains(., '%s')]/ancestor::mat-card[1]" +
            "/descendant::mat-card-content/p[contains(., '%s')]/ancestor::mat-card[1]" +
            "/mat-card-actions/button/span[contains(., 'View info')]";

    @Step("Click View Info button")
    public MainPage clickViewInfoButton(String title, String description, int price) {
        String viewInfoButtonXPath = String.format(viewInfoButtonOnJobCardFormat, title, price, description);
        WebElement viewInfoButton = driver.findElement(By.xpath(viewInfoButtonXPath));
        viewInfoButton.click();
        return this;
    }

    @Step("Set comment")
    public MainPage setComment(String comment) {
        setValue(commentInput, comment);
        return this;
    }

    @Step("Click Leave comment button")
    public MainPage clickLeaveCommentButton() {
        leaveCommentButton.click();
        return this;
    }

    @Step("Get comment")
    public String getComment() {
        wait.until(ExpectedConditions.visibilityOf(comment));
        return comment.getText();
    }
}
