package com.crm.pages;

import com.crm.utilities.Driver;
import org.bouncycastle.jcajce.provider.asymmetric.X509;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class AddDepartmentPage {

    public AddDepartmentPage() {

        PageFactory.initElements(Driver.getDriver(), this);

    }

    @FindBy(xpath = "//*[text()='Add']")
    public WebElement addDepartmentModalButton;

    @FindBy(xpath = "(//*[.='Close'])[3]")
    public WebElement closeButton;

    @FindBy(css = "[class='webform-error-list']")
    public  WebElement errorMessage;


}

