package com.base;

import com.helper.Actions;
import com.helper.Assertions;
import com.helper.Waiters;
import com.microsoft.playwright.Page;

public class BasePage {
    public Page page;
    public Actions actions;
    public Assertions assertions;
    public Waiters waiters;

    public BasePage(Page page) {
        this.page = page;
        this.actions = new Actions(page);
        this.assertions = new Assertions(page);
        this.waiters = new Waiters(page);
    }
}
