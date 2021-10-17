package com.tests.ui;

import com.company.pageObjects.*;
import com.github.javafaker.Faker;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.io.IOException;

public class ProfileTests extends BaseTest {

    Faker faker = new Faker();

    @Test(description = "Edit profile test")
    public void editProfileTest() throws InterruptedException, IOException {
        signIn();
        driver.get("https://freelance.lsrv.in.ua/profile");
        Header header = new Header(driver);
        header
                .clickUserIcon()
                .clickProfileButton();
        ProfilePage profilePage = new ProfilePage(driver);
        Assert.assertTrue(profilePage.isEditInfoButtonDisplayed());
        profilePage
                .clickEditInfoButton()
                .setUserName("New")
                .setLastName("Name")
                .clickUpdateButton();
        Assert.assertTrue(profilePage.getName().equals("New Name"));
        profilePage
                .clickEditInfoButton()
                .setUserName("Nastya")
                .setLastName("Rudenko")
                .clickUpdateButton();
        Assert.assertTrue(profilePage.getName().equals("Nastya Rudenko"));
        header
                .clickUserIcon()
                .clickLogoutButton();
    }

    @Test(description = "Create job test")
    public void createJobTest() throws InterruptedException, IOException {
        signIn();
        driver.get("https://freelance.lsrv.in.ua/profile");
        ProfilePage profilePage = new ProfilePage(driver);
        String jobTitle = faker.job().title();
        String jobDescription = faker.job().field();
        String jobPrice = Integer.toString((int) faker.number().randomNumber(2, true) * 100);
        profilePage
                .clickAddJobButton()
                .setJobTitle(jobTitle)
                .setJobPrice(jobPrice)
                .setJobDescription(jobDescription)
                .clickCreateJobButton();
        Assert.assertTrue(profilePage.isCreatedJobCardDisplayed(jobTitle, jobPrice, jobDescription));
        Header header = new Header(driver);
        header
                .clickUserIcon()
                .clickLogoutButton();
    }
}
