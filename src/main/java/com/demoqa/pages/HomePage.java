package com.demoqa.pages;

import com.base.BasePage;
import com.data.enums.ClickOptions;
import com.data.enums.ScrollOptions;
import com.microsoft.playwright.Locator;
import com.microsoft.playwright.Page;

public class HomePage extends BasePage {
    // Locators
    public Locator cards = page.locator(".category-cards");
    public Locator practiceForm = page.locator("//span[text()='Practice Form']");
    public Locator webTables = page.locator("//span[text()='Web Tables']");
    public Locator links = page.locator("//span[text()='Links']");
    public Locator selectMenu = page.locator("//span[text()='Select Menu']");
    public Locator datePicker = page.locator("//span[text()='Date Picker']");
    // Constructor
    public HomePage(Page page) {
        super(page);
    }

    // Assertions
    public void verifyHomePage() {
        assertions.verifyElementIsVisible(cards);
    }

    // Actions
    protected Locator getCardLocator(String cardName) {
        return page.locator("//h5[text()='" + cardName + "']");
    }

    public <T> T transferToSpecificPage(String cardName, Locator element, Class<T> pageClassName) {
        actions.scrollToElementAndClick(getCardLocator(cardName), ScrollOptions.PLAYWRIGHT, ClickOptions.PLAYWRIGHT);
        actions.scrollToElementAndClick(element, ScrollOptions.PLAYWRIGHT, ClickOptions.PLAYWRIGHT);
        try {
            return pageClassName.getDeclaredConstructor(Page.class).newInstance(page);
        } catch (Exception e) {
            throw new RuntimeException("Failed to instantiate page: " + pageClassName.getSimpleName(), e);
        }
    }
}
