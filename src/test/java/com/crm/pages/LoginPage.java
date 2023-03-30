package com.crm.pages;

import com.crm.utilities.ConfigurationReader;
import com.crm.utilities.Driver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage {


    public LoginPage() {

        PageFactory.initElements(Driver.getDriver(), this);

    }

    @FindBy(xpath = "//input[@name='USER_LOGIN']")
    public WebElement inputUsername;

    @FindBy(xpath = "//input[@name='USER_PASSWORD']")
    public WebElement inputPassword;

    @FindBy(xpath = "//input[@value='Log In']")
    public WebElement loginButton;


    /**
     * I created custom method and this method enters the provided username and password,
     * and clicks on the login button.
     *
     * @param userName The username to enter in the login form.
     * @param password The password to enter in the login form.
     */

    public void sendLoginCredentials(String userName, String password) {
        inputUsername.sendKeys(userName);
        inputPassword.sendKeys(password);
        loginButton.click();
    }

    /**
     * This method logs in as the specified user type by reading the username and password
     * from configuration.properties file, and calling sendLoginCredentials() method.
     *
     * @param userType The type of user to log in as (e.g. "hr", "helpdesk", "marketing").
     */

    public void loginAs(String userType) {
        String userName = null;
        String password = null;

        switch (userType.toLowerCase()) {
            case "hr":
                userName = ConfigurationReader.getProperty("hr_username");
                password = ConfigurationReader.getProperty("hr_password");
                break;
            case "helpdesk":
                userName = ConfigurationReader.getProperty("helpdesk_username");
                password = ConfigurationReader.getProperty("helpdesk_password");
                break;
            case "marketing":
                userName = ConfigurationReader.getProperty("marketing_username");
                password = ConfigurationReader.getProperty("marketing_password");
                break;
            default:
                System.out.println("Invalid userType message is displayed");
        }
        sendLoginCredentials(userName, password);
    }
}
