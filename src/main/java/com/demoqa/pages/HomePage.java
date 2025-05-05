package com.demoqa.pages;

import com.base.BasePage;
import com.data.enums.ClickOptions;
import com.data.enums.ScrollOptions;
import com.microsoft.playwright.Locator;
import com.microsoft.playwright.Page;

public class HomePage extends BasePage {
    // Locators
    public Locator cards = page.locator(".category-cards");
    public String url = "https://demoqa.com/";

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
        return page.locator("//h5[contains(text(), '" + cardName + "')]");
    }

    public Locator getSectionLocator(String sectionName) {
        return page.locator("//span[text()='" + sectionName + "']");
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
