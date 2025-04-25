package com.demoqa.windows;

import com.demoqa.pages.TablePage;
import com.microsoft.playwright.Page;
import com.microsoft.playwright.Locator;

public class EditModalWindow extends TablePage {
    // Locators
    public Locator window = page.locator("div.modal-content");
    public Locator firstName = page.locator("#firstName");
    public Locator lastName = page.locator("#lastName");
    public Locator email = page.locator("#userEmail");
    public Locator age = page.locator("#age");
    public Locator salary = page.locator("#salary");
    public Locator department = page.locator("#department");
    public Locator submitBtn = page.locator("#submit");

    public EditModalWindow(Page page) {
        super(page);
    }

    // Assertions
    public void verifyEditModalWindow() {
        Locator[] locators = {window, firstName, lastName, email, age, salary, department, submitBtn};
        assertions.verifyMultipleElementsAreVisible(locators);
    }

    // Actions
    public void editRecord(
            String firstName, String lastName, Integer age, Integer salary, String department) {
        actions.setValueInField(this.firstName, firstName);
        actions.setValueInField(this.lastName, lastName);
        actions.setValueInField(this.age, Integer.toString(age));
        actions.setValueInField(this.salary, Integer.toString(salary));
        actions.setValueInField(this.department, department);
        actions.clickOnElement(submitBtn);
    }
}
