package com.crm.step_definitions;

import com.crm.pages.AddDepartmentPage;
import com.crm.pages.LoginPage;
import com.crm.pages.CompanyStructurePage;
import io.cucumber.java.en.Then;
import org.junit.Assert;

public class AddDepartmentModalClosingStepDefinitions {


    CompanyStructurePage companyStructurePage = new CompanyStructurePage();
    LoginPage crmLoginPage = new LoginPage();
    AddDepartmentPage addDepartmentPage = new AddDepartmentPage();

    @Then("User sees {string} modal")
    public void userSeesModal(String addDepartmentModal) {
        Assert.assertTrue(addDepartmentPage.addDepartmentModalButton.isDisplayed());
    }


    @Then("User clicks on close button")
    public void userClicksOnCloseButton() {
        addDepartmentPage.closeButton.click();
    }

    @Then("User can not see  add Department modal button")
    public void userCanNotSeeAddDepartmentModalButton() {
        addDepartmentPage.addDepartmentModalButton.isDisplayed();
        System.out.println("addDepartmentPage.addModal.isDisplayed() = " + addDepartmentPage.addDepartmentModalButton.isDisplayed());

        Assert.assertFalse(addDepartmentPage.addDepartmentModalButton.isDisplayed());
    }


}

