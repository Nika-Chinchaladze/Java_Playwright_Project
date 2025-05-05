package com.demoqa.tests;

import com.data.enums.ClickOptions;
import com.data.enums.ScrollOptions;
import com.demoqa.base.BaseTest;
import com.demoqa.pages.DatePage;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class DatePageTest extends BaseTest {
    private DatePage datePage;

    @BeforeMethod(description = "Navigate user to Date Picker Page")
    public void testUserIsRedirectedToDatePage() {
        homePage.actions.navigateToUrl(homePage.url);
        homePage.verifyHomePage();
        datePage = homePage.transferToSpecificPage("Widgets", homePage.getSectionLocator("Date Picker"), DatePage.class);
        datePage.verifyDatePage();
    }

    @Test(description = "Test date functionality")
    public void testDateFunctionality() {
        datePage.actions.scrollToElementAndClick(datePage.date, ScrollOptions.PLAYWRIGHT, ClickOptions.PLAYWRIGHT);
        datePage.assertions.verifyElementIsVisible(datePage.calendar);
        datePage.actions.selectByVisibleText(datePage.monthDropDown, "May");
        datePage.actions.selectByVisibleText(datePage.yearDropDown, "1997");
        datePage.chooseDayFromCalendar(31);
        datePage.assertions.verifyElementIsNotVisible(datePage.calendar);
        datePage.assertions.verifyElementHasValue(datePage.date, "05/31/1997");
        datePage.waiters.waitForTimeOut(2000);
    }
}
