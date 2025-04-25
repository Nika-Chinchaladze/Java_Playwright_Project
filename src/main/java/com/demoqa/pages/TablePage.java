package com.demoqa.pages;

import com.base.BasePage;
import com.data.enums.ClickOptions;
import com.data.enums.ScrollOptions;
import com.demoqa.windows.AddModalWindow;
import com.demoqa.windows.EditModalWindow;
import com.microsoft.playwright.Page;
import com.microsoft.playwright.Locator;

public class TablePage extends BasePage {
    // Locators
    public Locator title = page.locator("h1.text-center");
    public Locator deleteIcon3 = page.locator("#delete-record-3");
    public Locator addBtn = page.locator("#addNewRecordButton");
    // Data
    protected String address = "//div[@class='rt-td' and normalize-space(text())='";

    public TablePage(Page page) {
        super(page);
    }

    // Method
    public Locator getEditIconLocator(String email) {
        return page.locator(address + email + "']/..//span[@title=\"Edit\"]");
    }

    public Locator getTableRowLocator(String value) {
        return page.locator(address + value + "']/..");
    }

    public EditModalWindow openEditModalWindow(String email) {
        actions.scrollToElementAndClick(getEditIconLocator(email), ScrollOptions.PLAYWRIGHT, ClickOptions.PLAYWRIGHT);
        return new EditModalWindow(page);
    }

    public AddModalWindow openAddModalWindow() {
        actions.scrollToElementAndClick(addBtn, ScrollOptions.PLAYWRIGHT, ClickOptions.PLAYWRIGHT);
        return new AddModalWindow(page);
    }
}
