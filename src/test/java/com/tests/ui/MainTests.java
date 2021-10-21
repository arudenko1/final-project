package com.tests.ui;

import com.company.api.AuthControllerApi;
import com.company.api.JobControllerApi;
import com.company.entity.AuthControllerData;
import com.company.entity.JobControllerData;
import com.company.pageObjects.Header;
import com.company.pageObjects.MainPage;
import com.github.javafaker.Faker;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.io.IOException;

public class MainTests extends BaseTest {

    Faker faker = new Faker();

    @Test(description = "Open job & leave comment test")
    public void openJobAndLeaveCommentTest() throws InterruptedException, IOException {
        AuthControllerData authControllerData = new AuthControllerData();
        authControllerData.setUsername("Nastya");
        authControllerData.setPassword("passwordN");

        AuthControllerApi authControllerApi = new AuthControllerApi();
        authControllerApi.postSignIn(authControllerData);

        String title = faker.job().title();
        String description = faker.job().position();
        int price = (int) faker.number().randomNumber(2, true) * 100;

        JobControllerData jobControllerData = new JobControllerData();
        jobControllerData.setTitle(title);
        jobControllerData.setDescription(description);
        jobControllerData.setPrice(price);

        JobControllerApi jobControllerApi = new JobControllerApi();
        jobControllerApi.postCreateJob(jobControllerData);

        signIn();
        MainPage mainPage = new MainPage(driver);

        String comment = faker.job().keySkills();
        mainPage
                .clickViewInfoButton(title, description, price)
                .setComment(comment)
                .clickLeaveCommentButton();
        Assert.assertTrue(mainPage.getComment().equals(comment));
        Header header = new Header(driver);
        header
                .clickUserIcon()
                .clickLogoutButton();
    }
}
