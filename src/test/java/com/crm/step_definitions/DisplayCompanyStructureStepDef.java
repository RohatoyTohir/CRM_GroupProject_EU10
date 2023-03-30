package com.crm.step_definitions;

import com.crm.pages.AddDepartmentPage;
import com.crm.pages.LoginPage;
import com.crm.pages.CompanyStructurePage;
import com.crm.utilities.BrowserUtils;
import com.crm.utilities.ConfigurationReader;
import com.crm.utilities.Driver;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;


public class DisplayCompanyStructureStepDef {

    LoginPage crmLoginPage = new LoginPage();
    CompanyStructurePage companyStructurePage = new CompanyStructurePage();
    AddDepartmentPage addDepartmentPage = new AddDepartmentPage();

    @Given("User loads the website")
    public void userLoadsTheWebsite() {
        Driver.getDriver().get(ConfigurationReader.getProperty("crm.url"));
    }


    @When("User {string} logs to home page")
    public void userLogsToHomePage(String userType) {
        crmLoginPage.loginAs(userType);
    }

    @When("User clicks on {string} button")
    public void userClicksOnButton(String employeeButton) {
        BrowserUtils.waitFor(2);
        companyStructurePage.employeeButton.click();
    }

    @Then("User sees {string} header")
    public void userSeesHeader(String expectedText) {
        String actualText = companyStructurePage.companyStructureHeader.getText();
        System.out.println("expectedText = " + expectedText);
        System.out.println("actualText = " + actualText);

        Assert.assertEquals(expectedText, actualText);
    }

    @Then("User does not see Add department button")
    public void userDoesNotSeeButton() {
        Assert.assertFalse("addDepartment Button is not displayed",companyStructurePage.isAddDepartmentButtonDisplayed());
    }


}