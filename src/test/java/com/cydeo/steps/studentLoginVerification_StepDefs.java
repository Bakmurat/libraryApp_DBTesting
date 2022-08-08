package com.cydeo.steps;

import com.cydeo.pages.DashBoardPage;
import com.cydeo.pages.LoginPage;
import com.cydeo.utility.BrowserUtil;
import com.cydeo.utility.ConfigurationReader;
import com.cydeo.utility.Driver;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;

public class studentLoginVerification_StepDefs {
    LoginPage loginPage=new LoginPage();
    DashBoardPage dashBoardPage = new DashBoardPage();
    @Given("student is on the loginPage")
    public void student_is_on_the_login_page() {
        System.out.println("Student is in the login page.");
    }
    @Then("verify that the URL is {string}")
    public void verify_that_the_url_is(String expectedTitle) {
        String actualTitle = Driver.getDriver().getCurrentUrl();
        Assert.assertEquals(expectedTitle, actualTitle);
    }
    @When("student enters valid email address and password")
    public void student_enters_valid_email_address_and_password() {
        String username= ConfigurationReader.getProperty("student_username");
        String password=ConfigurationReader.getProperty("student_password");
        loginPage.emailBox.sendKeys(username);
        BrowserUtil.waitFor(1);
        loginPage.passwordBox.sendKeys(password);
    }
    @When("student click sign in button")
    public void student_click_sign_in_button() {
        loginPage.loginButton.click();
        BrowserUtil.waitFor(1);
    }
}
