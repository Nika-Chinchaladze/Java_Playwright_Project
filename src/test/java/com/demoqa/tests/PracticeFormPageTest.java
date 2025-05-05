package com.demoqa.tests;

import com.demoqa.base.BaseTest;
import com.demoqa.pages.PracticeFormPage;
import io.qameta.allure.Feature;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

@Feature("PracticeFormPageTest")
public class PracticeFormPageTest extends BaseTest {
    private PracticeFormPage practiceFormPage;

    @BeforeMethod(description = "navigateToPracticeFormPage")
    public void testUserIsRedirectedToPracticeFormPage() {
        homePage.actions.navigateToUrl(homePage.url);
        homePage.verifyHomePage();
        practiceFormPage = homePage.transferToSpecificPage("Forms", homePage.getSectionLocator("Practice Form"), PracticeFormPage.class);
        practiceFormPage.assertions.verifyElementIsVisible(practiceFormPage.practiceFormTitle);
    }

    @Test(description = "testRadioButton")
    public void testRadioButton() {
        // Radio Button
        practiceFormPage.actions.clickJS(practiceFormPage.femaleRadioBtn);
        practiceFormPage.assertions.verifyElementIsChecked(practiceFormPage.femaleRadioBtn);
    }

    @Test(description = "testCheckBox")
    public void testCheckBox() {
        // Check-Box
        practiceFormPage.actions.clickOnCheckBox(practiceFormPage.sportsCheckBox);
        practiceFormPage.assertions.verifyElementIsChecked(practiceFormPage.sportsCheckBox);
        practiceFormPage.actions.unClickOnCheckBox(practiceFormPage.sportsCheckBox);
        practiceFormPage.assertions.verifyElementIsNotChecked(practiceFormPage.sportsCheckBox);
    }
}
