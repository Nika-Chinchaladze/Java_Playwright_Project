package com.helper;

import com.data.enums.ClickOptions;
import com.data.enums.ScrollOptions;
import com.microsoft.playwright.Page;
import com.microsoft.playwright.Locator;
import com.microsoft.playwright.options.SelectOption;

public class Actions extends BaseHelp {
    public Actions(Page page) {
        super(page);
    }

    public void clickOnElement(Locator element) {
        element.click();
    }

    public void clickJS(Locator element) {
        page.evaluate("arguments[0].click()", element);
    }

    public void scrollToElement(Locator element) {
        element.scrollIntoViewIfNeeded();
    }

    public void scrollToElementJS(Locator element) {
        page.evaluate("arguments[0].click()", element);
    }

    public void scrollToElementAndClick(Locator element, ScrollOptions scrollOptions, ClickOptions clickOptions) {
        switch (scrollOptions) {
            case JAVASCRIPT -> scrollToElementJS(element);
            case PLAYWRIGHT -> scrollToElement(element);
        }
        switch (clickOptions) {
            case JAVASCRIPT -> clickJS(element);
            case PLAYWRIGHT -> clickOnElement(element);
        }
    }

    public void clickOnCheckBox(Locator element) {
        if (!element.isChecked()) {
            scrollToElementAndClick(element, ScrollOptions.JAVASCRIPT, ClickOptions.JAVASCRIPT);
        }
    }

    public void unClickOnCheckBox(Locator element) {
        if (element.isChecked()) {
            scrollToElementAndClick(element, ScrollOptions.JAVASCRIPT, ClickOptions.JAVASCRIPT);
        }
    }

    public void setValueInField(Locator element, String text) {
        element.fill("");
        element.fill(text);
    }

    public void selectByVisibleText(Locator element, String visibleText) {
        scrollToElement(element);
        element.selectOption(new SelectOption().setLabel(visibleText));
    }

    public void selectByHiddenValue(Locator element, String hiddenValue) {
        scrollToElementJS(element);
        element.selectOption(new SelectOption().setValue(hiddenValue));
    }

    public void selectByIndex(Locator element, Integer index) {
        scrollToElementJS(element);
        element.selectOption(new SelectOption().setIndex(index));
    }
}
