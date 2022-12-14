package com.cydeo.steps;

import com.cydeo.pages.DashBoardPage;
import com.cydeo.pages.LoginPage;
import com.cydeo.utility.BrowserUtil;
import com.cydeo.utility.DB_Util;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;

public class Borrowed_StepDefs {
    LoginPage loginPage=new LoginPage();
    DashBoardPage dashBoardPage=new DashBoardPage();

    String actualBorrowedBookNumbers;

    @Given("the {string} on the home page")
    public void the_on_the_home_page(String user) {
        loginPage.login(user);
        BrowserUtil.waitFor(4);
    }
    @When("the librarian gets borrowed books number")
    public void the_librarian_gets_borrowed_books_number() {
        BrowserUtil.waitForPageToLoad(4);
        actualBorrowedBookNumbers = dashBoardPage.borrowedBooksNumber.getText();
        System.out.println("actualBorrowedBookNumbers = " + actualBorrowedBookNumbers);
    }
    @Then("borrowed books number information must match with DB")
    public void borrowed_books_number_information_must_match_with_db() {
        DB_Util.runQuery("select count(*) from book_borrow where is_returned=0");
        String expectedBorrowedBookNumbers = DB_Util.getFirstRowFirstColumn();
        Assert.assertEquals(expectedBorrowedBookNumbers,actualBorrowedBookNumbers);
    }
}
