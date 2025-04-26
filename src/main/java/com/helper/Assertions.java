package com.helper;

import com.microsoft.playwright.Locator;
import com.microsoft.playwright.Page;

import static com.microsoft.playwright.assertions.PlaywrightAssertions.assertThat;

public class Assertions extends BaseHelp {
    public Assertions(Page page) {
        super(page);
    }

    public void verifyPageUrl(String url) {
        assertThat(page).hasURL(url);
    }

    public void verifyElementIsVisible(Locator element) {
        assertThat(element).isVisible();
    }

    public void verifyMultipleElementsAreVisible(Locator[] elements) {
        for (Locator element : elements) {
            verifyElementIsVisible(element);
        }
    }

    public void verifyElementIsNotVisible(Locator element) {
        assertThat(element).not().isVisible();
    }

    public void verifyElementIsEnabled(Locator element) {
        assertThat(element).isEnabled();
    }

    public void verifyElementHasText(Locator element, String text) {
        assertThat(element).containsText(text);
    }

    public void verifyElementHasValue(Locator element, String value) {
        assertThat(element).hasValue(value);
    }

    public void verifyElementIsChecked(Locator element) {
        assertThat(element).isChecked();
    }

    public void verifyElementIsNotChecked(Locator element) {
        assertThat(element).not().isChecked();
    }

    public boolean verifyDropDownSelectedElement(Locator element, String value) {
        return element.inputValue().contains(value);
    }
}
