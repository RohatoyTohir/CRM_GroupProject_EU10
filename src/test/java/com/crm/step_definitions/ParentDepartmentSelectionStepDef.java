package com.crm.step_definitions;

import com.crm.pages.LoginPage;
import com.crm.pages.CompanyStructurePage;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.support.ui.Select;


public class ParentDepartmentSelectionStepDef {

    CompanyStructurePage companyStructurePage = new CompanyStructurePage();
    LoginPage crmLoginPage = new LoginPage();
    Select select = new Select(companyStructurePage.parentDepartmentDropdown);



    @When("User selects a parent department {string} from parent dropdown")
    public void userSelectsAParentDepartmentFromParentDropdown(String departmentToSelect) {
        select.selectByVisibleText(departmentToSelect);
        System.out.println("select.getOptions() = " + select.getOptions());
    }


    @Then("User sees parent department {string} in the parent department dropdown")
    public void userSeesParentDepartmentInTheParentDepartmentDropdown(String expectedDepartment) {
        String actualDepartment = select.getOptions().get(5).getText();
        Assert.assertEquals(expectedDepartment,actualDepartment);
    }
}


/**
 * This code will return me all the options available from parent dropdown
 */

//      List<WebElement> options = select.getOptions();
//      System.out.println("options.size() = " + options.size());
//      for (WebElement option : options) { // prints options one by one
//      System.out.println(option.getText());
//      options.contains(marketingDepartment);
