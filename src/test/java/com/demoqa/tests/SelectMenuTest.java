package com.demoqa.tests;

import com.demoqa.base.BaseTest;
import com.demoqa.pages.SelectMenuPage;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class SelectMenuTest extends BaseTest {
    private SelectMenuPage selectMenuPage;

    @BeforeMethod(description = "transferToSelectMenuPage")
    public void navigateToSelectMenuPage() {
        homePage.verifyHomePage();
        selectMenuPage = homePage.transferToSpecificPage("Widgets", homePage.selectMenu, SelectMenuPage.class);
        selectMenuPage.verifySelectMenuPage();
    }

    @AfterMethod(description = "slow downs the test execution")
    public void slowDownExecution() {
        selectMenuPage.waiters.waitForTimeOut(3000);
    }

    @Test(description = "Test - select by visible text")
    public void testSelectByTextOld() {
        selectMenuPage.actions.selectByVisibleText(selectMenuPage.oldSelect, "Blue");
        selectMenuPage.assertions.verifyDropDownSelectedElement(selectMenuPage.oldSelect, "Blue");
    }

    @Test(description = "Test - select by hidden value")
    public void testSelectByValueOld() {
        selectMenuPage.actions.selectByHiddenValue(selectMenuPage.oldSelect, "1");
        selectMenuPage.assertions.verifyDropDownSelectedElement(selectMenuPage.oldSelect, "Blue");
    }

    @Test(description = "Test - select by index")
    public void testSelectByIndexOld() {
        selectMenuPage.actions.selectByIndex(selectMenuPage.oldSelect, 1);
        selectMenuPage.assertions.verifyDropDownSelectedElement(selectMenuPage.oldSelect, "Blue");
    }
}
