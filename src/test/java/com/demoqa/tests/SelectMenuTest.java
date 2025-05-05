package com.demoqa.tests;

import com.demoqa.base.BaseTest;
import com.demoqa.pages.SelectMenuPage;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import static org.testng.Assert.assertTrue;

public class SelectMenuTest extends BaseTest {
    private SelectMenuPage selectMenuPage;

    @BeforeMethod(description = "transferToSelectMenuPage")
    public void testUserIsRedirectedToSelectMenuPage() {
        homePage.actions.navigateToUrl(homePage.url);
        homePage.verifyHomePage();
        selectMenuPage = homePage.transferToSpecificPage("Widgets", homePage.getSectionLocator("Select Menu"), SelectMenuPage.class);
        selectMenuPage.verifySelectMenuPage();
    }

    @AfterMethod(description = "slow downs the test execution")
    public void slowDownExecution() {
        selectMenuPage.waiters.waitForTimeOut(3000);
    }

    @Test(description = "Test - select by visible text")
    public void testSelectByTextOld() {
        selectMenuPage.actions.selectByVisibleText(selectMenuPage.oldSelect, "Blue");
        assertTrue(selectMenuPage.assertions.verifyDropDownSelectedElement(selectMenuPage.oldSelect, "Blue"));
    }

    @Test(description = "Test - select by hidden value")
    public void testSelectByValueOld() {
        selectMenuPage.actions.selectByHiddenValue(selectMenuPage.oldSelect, "1");
        assertTrue(selectMenuPage.assertions.verifyDropDownSelectedElement(selectMenuPage.oldSelect, "Blue"));
    }

    @Test(description = "Test - select by index")
    public void testSelectByIndexOld() {
        selectMenuPage.actions.selectByIndex(selectMenuPage.oldSelect, 1);
        assertTrue(selectMenuPage.assertions.verifyDropDownSelectedElement(selectMenuPage.oldSelect, "Blue"));
    }
}
