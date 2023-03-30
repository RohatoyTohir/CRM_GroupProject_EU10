package com.crm.pages;

import com.crm.utilities.Driver;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CompanyStructurePage {

    public CompanyStructurePage() {

        PageFactory.initElements(Driver.getDriver(), this);
    }

    @FindBy(xpath = "(//*[.='Company Structure'])[3]")
    public WebElement companyStructureHeader;

    @FindBy(css = "[title='Employees']")
    public WebElement employeeButton;

    @FindBy(xpath = "//*[.='Add department']")
    public WebElement addDepartmentButton;

    @FindBy(xpath = "//input[@id='NAME']")
    public WebElement departmentNameDropdown;

    @FindBy(xpath = "//*[text()='Add']")
    public WebElement addButton;

    @FindBy(xpath = "(//*[.='Marketing'])[3]")
    public  WebElement departmentName;

    @FindBy(xpath = "//select[@id='IBLOCK_SECTION_ID']")
    public WebElement parentDepartmentDropdown;



    public boolean isAddDepartmentButtonDisplayed() {
        try {
            return addDepartmentButton.isDisplayed();
        } catch (NoSuchElementException e) {
            return false;
        }
    }


}
