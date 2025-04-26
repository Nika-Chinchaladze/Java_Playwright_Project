package com.helper;

import com.microsoft.playwright.Locator;
import com.microsoft.playwright.Page;

public class Waiters extends BaseHelp {
    public Waiters(Page page) {
        super(page);
    }

    public void waitForTimeOut(Integer time) {
        page.waitForTimeout(time);
    }

    public void waitForSelector(Locator element) {
        element.waitFor();
    }

    public void waitForPageUrl(String url) {
        page.waitForURL(url);
    }
}
