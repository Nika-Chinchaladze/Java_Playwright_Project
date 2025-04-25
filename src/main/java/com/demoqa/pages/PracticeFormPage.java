package com.demoqa.pages;

import com.base.BasePage;
import com.microsoft.playwright.Page;
import com.microsoft.playwright.Locator;

public class PracticeFormPage extends BasePage {
    // Locators
    public Locator practiceFormTitle = page.locator("//h1[text()=\"Practice Form\"]");
    public Locator femaleRadioBtn = page.locator("input#gender-radio-2.custom-control-input");
    public Locator sportsCheckBox = page.locator("input#hobbies-checkbox-1.custom-control-input");

    public PracticeFormPage(Page page) {
        super(page);
    }
}
