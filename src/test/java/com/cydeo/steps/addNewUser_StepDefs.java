package com.cydeo.steps;

import com.cydeo.pages.DashBoardPage;
import com.cydeo.pages.UsersPage;
import com.cydeo.utility.BrowserUtil;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;

public class addNewUser_StepDefs {
    UsersPage usersPage= new UsersPage();
    String actualEmail = "baha22@library";
    @When("librarian click Users module")
    public void librarian_click_users_module() {
        usersPage.users.click();
    }
    @When("librarian click {string} button")
    public void librarian_click_button(String addUserBtn) {
        usersPage.addUser.click();
    }
    @When("librarian enter full name, password, email and address")
    public void librarian_enter_full_name_password_email_and_address() {
        usersPage.full_name.sendKeys("Baha Kuban");
        usersPage.password.sendKeys("123456");
        usersPage.email.sendKeys(actualEmail);
        usersPage.address.sendKeys("9060 ViewPoint Ct");

    }
    @When("librarian click save changes")
    public void librarian_click_save_changes() {
        usersPage.saveChangeBtn.click();
    }
    @Then("verify a new user is created")
    public void verify_a_new_user_is_created() {
        //BrowserUtil.waitFor(2);
        //Assert.assertEquals(actualEmail, usersPage.firstRowEmail.getText());
        String expectedMsg = "The user has been created.";
        Assert.assertEquals(expectedMsg, usersPage.verifMsg.getText());
    }
}
