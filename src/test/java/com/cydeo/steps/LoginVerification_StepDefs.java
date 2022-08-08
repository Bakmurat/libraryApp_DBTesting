package com.cydeo.steps;

import com.cydeo.pages.BasePage;
import com.cydeo.pages.DashBoardPage;
import com.cydeo.pages.LoginPage;
import com.cydeo.utility.BrowserUtil;
import com.cydeo.utility.ConfigurationReader;
import com.cydeo.utility.Driver;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.WebElement;

public class LoginVerification_StepDefs {
    LoginPage loginPage=new LoginPage();
    DashBoardPage dashBoardPage = new DashBoardPage();

    @Given("librarian is on the loginPage")
    public void librarian_is_on_the_login_page() {
        System.out.println("Librarian is in the login page.");
    }
    @Then("verify that the title is {string}")
    public void verify_that_the_title_is(String expectedTitle) {
        String actualTitle = Driver.getDriver().getTitle();
        Assert.assertEquals(expectedTitle, actualTitle);
    }
    @When("librarian enters valid email address and password")
    public void librarian_enters_valid_email_address_and_password() {
        String username=ConfigurationReader.getProperty("librarian_username");
        String password=ConfigurationReader.getProperty("librarian_password");
        loginPage.emailBox.sendKeys(username);
        BrowserUtil.waitFor(1);
        loginPage.passwordBox.sendKeys(password);
    }
    @When("librarian click sign in button")
    public void librarian_click_sign_in_button() {
        loginPage.loginButton.click();
        BrowserUtil.waitFor(1);
    }
    @Then("verify that there are {int} models on the page")
    public void verify_that_there_are_models_on_the_page(Integer expectedCount) {
        Integer actualCount=0;
        try {
            if(dashBoardPage.users.isDisplayed()){
                actualCount++;
            }
        }catch(Exception e) {
            System.out.println("*Users not found");
        }

        try {
            if(dashBoardPage.dashboard.isDisplayed()){
                actualCount++;
            }
        }catch(Exception e) {
            System.out.println("*Dashboard not found");
        }

        try {
            if(dashBoardPage.books.isDisplayed()){
                actualCount++;
            }
        }catch(Exception e) {
            System.out.println("*Books not found");
        }

        try {
            if(dashBoardPage.borrowBooks.isDisplayed()){
                actualCount++;
            }
        }catch(Exception e) {
            System.out.println("*Borrow Boooks note found");
        }

        Assert.assertEquals(expectedCount, actualCount);
    }

}
