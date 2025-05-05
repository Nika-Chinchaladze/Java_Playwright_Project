package com.demoqa.tests;

import com.demoqa.base.BaseTest;
import io.qameta.allure.Feature;
import org.testng.annotations.Test;

@Feature("HomePageTest")
public class HomePageTest extends BaseTest {
    @Test(description = "test Home Page Functionality")
    public void testUserIsRedirectedToHomePage() {
        homePage.actions.navigateToUrl(homePage.url);
        homePage.verifyHomePage();
    }
}
