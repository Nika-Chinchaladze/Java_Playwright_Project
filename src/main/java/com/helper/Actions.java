package com.helper;

import com.data.enums.ClickOptions;
import com.data.enums.ScrollOptions;
import com.microsoft.playwright.Dialog;
import com.microsoft.playwright.Locator;
import com.microsoft.playwright.Page;
import com.microsoft.playwright.options.SelectOption;

public class Actions extends BaseHelp {
    public Actions(Page page) {
        super(page);
    }

    public void navigateToUrl(String url) {
        page.navigate(url);
        page.waitForURL(url);
    }

    public void clickOnElement(Locator element) {
        element.click();
    }

    public void clickJS(Locator element) {
        element.evaluate("element => element.click()");
    }

    public void scrollToElement(Locator element) {
        element.scrollIntoViewIfNeeded();
    }

    public void scrollToElementJS(Locator element) {
        element.evaluate("element => element.scrollIntoView()");
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
            clickJS(element);
        }
    }

    public void unClickOnCheckBox(Locator element) {
        if (element.isChecked()) {
            clickJS(element);
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

    public void acceptAlert() {
        page.onDialog(Dialog::accept);
    }

    public void dismissAlert() {
        page.onDialog(Dialog::dismiss);
    }

    public void fillAlert(String alertText) {
        page.onDialog(dialog -> {
            dialog.accept(alertText);
        });
    }
}
