package com.demoqa.pages;

import com.base.BasePage;
import com.data.enums.ClickOptions;
import com.data.enums.ScrollOptions;
import com.microsoft.playwright.Locator;
import com.microsoft.playwright.Page;

public class DatePage extends BasePage {
    // Locators
    public Locator title = page.locator("h1.text-center");
    public Locator date = page.locator("#datePickerMonthYearInput");
    public Locator time = page.locator("#dateAndTimePickerInput");
    public Locator calendar = page.locator("div.react-datepicker__month-container");
    public Locator monthDropDown = page.locator("select.react-datepicker__month-select");
    public Locator yearDropDown = page.locator("select.react-datepicker__year-select");
    // Constructor
    public DatePage(Page page) {
        super(page);
    }

    // Assertions
    public void verifyDatePage() {
        Locator[] locators = {title, date, time};
        assertions.verifyMultipleElementsAreVisible(locators);
    }

    // Actions
    public void chooseDayFromCalendar(Integer day) {
        // We need logic for repeated day number, when it resolves 2 values
        Locator dayLocator = page.locator(
                "//div[@class='react-datepicker__month']//div[@class='react-datepicker__week']//div[text()='" + day + "']"
        );
        actions.scrollToElementAndClick(dayLocator, ScrollOptions.PLAYWRIGHT, ClickOptions.PLAYWRIGHT);
    }
}
