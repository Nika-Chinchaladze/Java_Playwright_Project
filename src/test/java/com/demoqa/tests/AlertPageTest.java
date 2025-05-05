package com.demoqa.tests;

import com.demoqa.pages.AlertPage;
import com.demoqa.base.BaseTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import static org.testng.Assert.assertTrue;

public class AlertPageTest extends BaseTest {
    protected AlertPage alertPage;

    @BeforeMethod(description = "Navigate user to alerts page")
    public void testUserIsRedirectedToAlertPage() {
        homePage.actions.navigateToUrl(homePage.url);
        homePage.assertions.verifyPageUrl(homePage.url);
        homePage.verifyHomePage();
        alertPage = homePage.transferToSpecificPage("Alerts", homePage.getSectionLocator("Alerts"), AlertPage.class);
    }

    @Test(description = "Verify AlertPage is opened")
    public void testAlertPage() {
        alertPage.verifyAlertPage();
    }

    @Test(description = "Verify simple alert by type & text Content")
    public void testSimpleAlert() {
        alertPage.verifyAlertPage();
        assertTrue(alertPage.assertions.verifyAlertByTextContent(alertPage.simpleAlertBtn, "You clicked a button", true, ""));
    }

    @Test(description = "Verify confirmation alert - Ok scenario")
    public void testConfirmationAlertPositive() {
        alertPage.verifyAlertPage();
        assertTrue(alertPage.assertions.verifyAlertByTextContent(alertPage.confirmAlertBtn, "Do you confirm action?", true, ""));
        alertPage.assertions.verifyElementHasText(alertPage.confirmationResult, "You selected Ok");
    }

    @Test(description = "Verify confirmation alert - Cancel scenario")
    public void testConfirmationAlertNegative() {
        alertPage.verifyAlertPage();
        assertTrue(alertPage.assertions.verifyAlertByTextContent(alertPage.confirmAlertBtn, "Do you confirm action?", false, ""));
        alertPage.assertions.verifyElementHasText(alertPage.confirmationResult, "You selected Cancel");
    }

    @Test(description = "Verify prompt alert - Ok scenario")
    public void testPromptAlertPositive() {
        alertPage.verifyAlertPage();
        assertTrue(alertPage.assertions.verifyAlertByTextContent(alertPage.promptAlertBtn, "Please enter your name", true, "nika"));
        alertPage.assertions.verifyElementHasText(alertPage.promptResult, "You entered nika");
    }

    @Test(description = "Verify prompt alert - Cancel scenario")
    public void testPromptAlertNegative() {
        alertPage.verifyAlertPage();
        assertTrue(alertPage.assertions.verifyAlertByTextContent(alertPage.promptAlertBtn, "Please enter your name", false, ""));
        alertPage.assertions.verifyElementIsNotVisible(alertPage.promptResult);
    }
}
