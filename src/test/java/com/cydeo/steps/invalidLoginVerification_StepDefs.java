package com.cydeo.steps;

import com.cydeo.pages.LoginPage;
import com.cydeo.utility.BrowserUtil;
import com.cydeo.utility.ConfigurationReader;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;

public class invalidLoginVerification_StepDefs {
    LoginPage loginPage=new LoginPage();

    @Given("user is on the loginPage")
    public void user_is_on_the_login_page() {
        System.out.println("User is in the login page.");
    }
    @When("user enters invalid email address or password")
    public void user_enters_invalid_email_address_or_password() {
        String username= ConfigurationReader.getProperty("librarian_username");
        String password=ConfigurationReader.getProperty("invalid_password");
        loginPage.emailBox.sendKeys(username);
        BrowserUtil.waitFor(1);
        loginPage.passwordBox.sendKeys(password);
    }
    @Then("verify the error message {string}")
    public void verify_the_error_message(String expectedError) {
        String actualError = loginPage.errorMessage.getText();
        Assert.assertEquals(expectedError, actualError);
    }
}
