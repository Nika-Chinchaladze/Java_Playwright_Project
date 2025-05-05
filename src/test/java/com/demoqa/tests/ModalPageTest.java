package com.demoqa.tests;

import com.demoqa.suites.ModalPageBaseTest;
import com.demoqa.pages.ModalDialogPage;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class ModalPageTest extends ModalPageBaseTest {
    protected ModalDialogPage modalDialogPage;

    @BeforeMethod(description = "Navigate user to ModalPage")
    public void testUserIsRedirectedToModalPage() {
        homePage.actions.navigateToUrl(homePage.url);
        homePage.verifyHomePage();
        modalDialogPage = homePage.transferToSpecificPage("Alerts", homePage.getSectionLocator("Modal Dialogs"), ModalDialogPage.class);
    }

    @Test(description = "Test ModalPage is opened and elements are displayed")
    public void testModalPage() {
        modalDialogPage.verifyModalDialogPage();
    }

    @Test(description = "Test Small Modal Window")
    public void testSmallModalWindow() {
        modalDialogPage.actions.clickOnElement(modalDialogPage.smallModalBtn);
        smallDialogModalWindow.verifySmallDialogModalWindow();
    }

    @Test(description = "Test Large Modal window")
    public void testLargeModalWindow() {
        modalDialogPage.actions.clickJS(modalDialogPage.largeModalBtn);
        largeDialogModalWindow.verifyLargeDialogModalWindow();
    }
}
