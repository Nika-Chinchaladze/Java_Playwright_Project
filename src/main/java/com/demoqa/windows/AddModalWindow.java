package com.demoqa.windows;

import com.demoqa.pages.TablePage;
import com.microsoft.playwright.Locator;
import com.microsoft.playwright.Page;

public class AddModalWindow extends TablePage {
    // Locators
    public Locator title = page.locator("#registration-form-modal");
    public Locator window = page.locator(".modal-content");
    public Locator firstName = page.locator("#firstName");
    public Locator lastName = page.locator("#lastName");
    public Locator email = page.locator("#userEmail");
    public Locator age = page.locator("#age");
    public Locator salary = page.locator("#salary");
    public Locator department = page.locator("#department");
    public Locator submitBtn = page.locator("#submit");

    public AddModalWindow(Page page) {
        super(page);
    }

    // Methods
    public void verifyAddModalWindow() {
        Locator[] locators = {window, title, firstName, lastName, email, age, salary, department, submitBtn};
        assertions.verifyMultipleElementsAreVisible(locators);
    }

    public void fillAddRecordForm(
            String firstName,
            String lastName,
            String email,
            Integer age,
            Integer salary,
            String department) {
        actions.setValueInField(this.firstName, firstName);
        actions.setValueInField(this.lastName, lastName);
        actions.setValueInField(this.email, email);
        actions.setValueInField(this.age, Integer.toString(age));
        actions.setValueInField(this.salary, Integer.toString(salary));
        actions.setValueInField(this.department, department);
    }
}
