package com.demoqa.windows;

import com.base.BasePage;
import com.microsoft.playwright.Page;
import com.microsoft.playwright.Locator;

public class LargeDialogModalWindow extends BasePage {
    // Constructor
    public LargeDialogModalWindow(Page page) {
        super(page);
    }

    // Locators
    public Locator window = page.locator(".modal-content");
    public Locator title = page.locator(".modal-title");
    public Locator body = page.locator(".modal-body");
    public Locator closeBtn = page.locator("#closeLargeModal");

    // Assertions
    public void verifyLargeDialogModalWindow() {
        Locator[] locators = { window, title, body, closeBtn };
        assertions.verifyMultipleElementsAreVisible(locators);
    }
}
