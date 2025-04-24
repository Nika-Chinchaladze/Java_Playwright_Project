package com.demoqa.tests;

import com.demoqa.base.BaseTest;
import com.demoqa.pages.LinksPage;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class LinksPageTest extends BaseTest {
    private LinksPage linksPage;

    @BeforeMethod(description = "Navigate User to Links Page")
    public void navigateToLinksPage() {
        homePage.verifyHomePage();
        linksPage = homePage.transferToSpecificPage("Elements", homePage.links, LinksPage.class);
        linksPage.assertions.verifyElementIsVisible(linksPage.title);
        linksPage.assertions.verifyElementIsEnabled(linksPage.badRequest);
    }

    @Test(description = "Test Bad Request scenario")
    public void testBadRequest() {
        linksPage.actions.clickOnElement(linksPage.badRequest);
        linksPage.waiters.waitForTimeOut(1000);
        linksPage.assertions.verifyElementIsVisible(linksPage.linkResponse);
        linksPage.assertions.verifyElementHasText(linksPage.linkResponse, Integer.toString(linksPage.statusCode));
        linksPage.assertions.verifyElementHasText(linksPage.linkResponse, linksPage.message);
    }
}
