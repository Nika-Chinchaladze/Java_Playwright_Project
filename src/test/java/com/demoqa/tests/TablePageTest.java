package com.demoqa.tests;

import com.demoqa.base.BaseTest;
import com.demoqa.pages.TablePage;
import io.qameta.allure.Feature;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

@Feature("TablePageTest")
public class TablePageTest extends BaseTest {
    private TablePage tablePage;

    @BeforeMethod(description = "navigateToTablePage")
    public void navigateToTablePage() {
        homePage.verifyHomePage();
        tablePage = homePage.transferToSpecificPage("Elements", homePage.webTables, TablePage.class);
        tablePage.assertions.verifyElementIsVisible(tablePage.title);
    }

    @Test(description = "testWebTableDelete")
    public void testWebTableDelete() {
        tablePage.actions.clickOnElement(tablePage.deleteIcon3);
        tablePage.assertions.verifyElementIsNotVisible(tablePage.deleteIcon3);
        tablePage.waiters.waitForTimeOut(2000);
    }

    @Test(description = "testWebTableEdit")
    public void testWebTableEdit() {
        var editModalWindow = tablePage.openEditModalWindow("cierra@example.com");
        editModalWindow.verifyEditModalWindow();
        editModalWindow.editRecord("Tommy", "Shelby", 27, 1500, "AQA");
        tablePage.assertions.verifyElementIsVisible(tablePage.getTableRowLocator("Tommy"));
        tablePage.waiters.waitForTimeOut(3000);
    }

    @Test(description = "testWebTablesAdd")
    public void testWebTablesAdd() {
        var addModalWindow = tablePage.openAddModalWindow();
        addModalWindow.verifyAddModalWindow();
        addModalWindow.fillAddRecordForm("Artur", "Shelby", "artur@gmail.com", 30, 2000, "Gangster");
        addModalWindow.assertions.verifyElementHasValue(addModalWindow.firstName, "Artur");
        addModalWindow.assertions.verifyElementHasValue(addModalWindow.lastName, "Shelby");
        addModalWindow.assertions.verifyElementHasValue(addModalWindow.email, "artur@gmail.com");
        addModalWindow.assertions.verifyElementHasValue(addModalWindow.age, Integer.toString(30));
        addModalWindow.assertions.verifyElementHasValue(addModalWindow.salary, Integer.toString(2000));
        addModalWindow.assertions.verifyElementHasValue(addModalWindow.department, "Gangster");

        addModalWindow.actions.clickOnElement(addModalWindow.submitBtn);
        tablePage.assertions.verifyElementIsVisible(tablePage.getTableRowLocator("artur@gmail.com"));
        tablePage.waiters.waitForTimeOut(3000);
    }
}
