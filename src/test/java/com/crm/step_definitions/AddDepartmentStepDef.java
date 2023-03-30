package com.crm.step_definitions;

import com.crm.pages.AddDepartmentPage;
import com.crm.pages.LoginPage;
import com.crm.pages.CompanyStructurePage;
import com.crm.utilities.Driver;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.interactions.Actions;

public class AddDepartmentStepDef {

    /**
     * AddButton is not clickable by using Selenium, so I used JS Executor.
     * for this I created an Action object,which provides a way to perform complex user interactions with the web page,
     *  such as clicking and dragging elements, double-clicking, or hovering over elements.
     *  The Actions class has several methods that can be used to perform these interactions,
     *  such as moveToElement(), click(), doubleClick(), and dragAndDrop() etc.
     *
     */
    JavascriptExecutor js = (JavascriptExecutor) Driver.getDriver();
    Actions actions = new Actions(Driver.getDriver());

    CompanyStructurePage companyStructurePage = new CompanyStructurePage();
    AddDepartmentPage addDepartmentPage = new AddDepartmentPage();
    LoginPage crmLoginPage = new LoginPage();

    @When("User clicks on the {string} button")
    public void userClicksOnTheButton(String addDepartmentButton) {
        companyStructurePage.addDepartmentButton.click();
    }

    @When("User types department name {string} for the department text field")
    public void userTypesDepartmentNameForTheDepartmentTextField(String textField) {
        companyStructurePage.departmentNameDropdown.sendKeys("Marketing");
    }

    @When("User clicks on the {string} button on next window")
    public void userClicksOnTheButtonOnNextWindow(String addButton) {
        actions.moveToElement(companyStructurePage.addButton).click().build().perform();
        js.executeScript("arguments[0].click();", companyStructurePage.addButton);


    }

    @Then("User sees the department column {string} on the Company Structure page")
    public void userSeesTheDepartmentColumnOnTheCompanyStructurePage(String departmentColumnMarketing) {
        Assert.assertTrue(companyStructurePage.departmentName.isDisplayed());
        Assert.assertEquals("Marketing", companyStructurePage.departmentName.getText());

    }


    @Then("User sees error message {string} on the add Department page")
    public void userSeesErrorMessageOnTheAddDepartmentPage(String expectedErrorMessage) {
        addDepartmentPage.errorMessage.isDisplayed();

        String actualText = addDepartmentPage.errorMessage.getText();
        Assert.assertEquals(expectedErrorMessage, actualText);



    }
}






