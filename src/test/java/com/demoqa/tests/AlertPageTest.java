package com.demoqa.tests;

import com.demoqa.pages.AlertPage;
import com.pojo.alert.AlertWrapper;
import com.utils.JsonHandler;
import com.demoqa.base.BaseTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import static org.testng.Assert.assertTrue;

public class AlertPageTest extends BaseTest {
    protected AlertPage alertPage;
    protected AlertWrapper alertData;

    @BeforeClass(description = "Loads alert data")
    public void loadAlertData() {
        alertData = JsonHandler.readJsonFile("src/test/java/com/demoqa/resources/alerts_test_data.json", AlertWrapper.class);
    }

    @BeforeMethod(description = "Navigate user to alerts page")
    public void testUserIsRedirectedToAlertPage() {
        homePage.actions.navigateToUrl(homePage.url);
        homePage.assertions.verifyPageUrl(homePage.url);
        homePage.page.reload();
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
        assertTrue(
                alertPage.assertions.verifyAlertByTextContent(alertPage.simpleAlertBtn,
                alertData.getAlerts().getSimpleAlert().getQuestion(), true, "")
        );
    }

    @Test(description = "Verify confirmation alert - Ok scenario")
    public void testConfirmationAlertPositive() {
        alertPage.verifyAlertPage();
        assertTrue(alertPage.assertions.verifyAlertByTextContent(
                alertPage.confirmAlertBtn,
                alertData.getAlerts().getConfirmationAlert().getQuestion(), true, "")
        );
        alertPage.assertions.verifyElementHasText(
                alertPage.confirmationResult,
                alertData.getAlerts().getConfirmationAlert().getTextOk()
        );
    }

    @Test(description = "Verify confirmation alert - Cancel scenario")
    public void testConfirmationAlertNegative() {
        alertPage.verifyAlertPage();
        assertTrue(alertPage.assertions.verifyAlertByTextContent(
                alertPage.confirmAlertBtn,
                alertData.getAlerts().getConfirmationAlert().getQuestion(), false, "")
        );
        alertPage.assertions.verifyElementHasText(
                alertPage.confirmationResult,
                alertData.getAlerts().getConfirmationAlert().getTextCancel()
        );
    }

    @Test(description = "Verify prompt alert - Ok scenario")
    public void testPromptAlertPositive() {
        alertPage.verifyAlertPage();
        assertTrue(alertPage.assertions.verifyAlertByTextContent(
                alertPage.promptAlertBtn,
                alertData.getAlerts().getPromptAlert().getQuestion(), true,
                alertData.getAlerts().getPromptAlert().getValue()
                )
        );
        alertPage.assertions.verifyElementHasText(
                alertPage.promptResult,
                alertData.getAlerts().getPromptAlert().getText()
        );
    }

    @Test(description = "Verify prompt alert - Cancel scenario")
    public void testPromptAlertNegative() {
        alertPage.verifyAlertPage();
        assertTrue(alertPage.assertions.verifyAlertByTextContent(
                alertPage.promptAlertBtn,
                alertData.getAlerts().getPromptAlert().getQuestion(), false,
                alertData.getAlerts().getPromptAlert().getBlank()
            )
        );
        alertPage.assertions.verifyElementIsNotVisible(alertPage.promptResult);
    }
}
