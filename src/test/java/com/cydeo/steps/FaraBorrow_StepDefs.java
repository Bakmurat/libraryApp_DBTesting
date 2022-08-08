package com.cydeo.steps;

import com.cydeo.pages.BookPage;
import com.cydeo.pages.BorrowBooksPage;
import com.cydeo.utility.BrowserUtil;
import com.cydeo.utility.ConfigurationReader;
import com.cydeo.utility.DB_Util;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;

public class FaraBorrow_StepDefs {
    BookPage bookPage=new BookPage();
    BorrowBooksPage borrowBooksPage = new BorrowBooksPage();
    String globalName="";

    @Given("the user searches book name called {string}")
    public void the_user_searches_book_name_called(String bookName) {
        globalName+=bookName;
        BrowserUtil.waitFor(2);
        BrowserUtil.waitForClickablility(bookPage.search, 5).sendKeys(bookName);

    }
    @When("the user clicks Borrow Book")
    public void the_user_clicks_borrow_book() {
        BrowserUtil.waitFor(2);
        BrowserUtil.waitForClickablility(bookPage.editBook(globalName), 5).click();
    }
    @Then("verify that book is shown in {string} page")
    public void verify_that_book_is_shown_in_borrowing_books_page(String dummy) {
        BrowserUtil.waitFor(2);
        bookPage.borrowBooks.click();

        BrowserUtil.waitFor(2);
        String actualBook = borrowBooksPage.borrowBook(globalName).getText();

        BrowserUtil.waitFor(2);
        Assert.assertTrue(borrowBooksPage.borrowBook(globalName).isDisplayed());
    }
    @Then("verify logged student has same book in database")
    public void verify_logged_student_has_same_book_in_database() {
        String query="select full_name,b.name,bb.borrowed_date " +
                "from users u inner join book_borrow bb " +
                    "on u.id = bb.user_id inner " +
                        "join books b on bb.book_id = b.id " +
                            "where full_name='"+ConfigurationReader.getProperty("fullName")+"' and name='"+globalName+"'order by 3 desc;";
        DB_Util.runQuery(query);

        Assert.assertEquals(ConfigurationReader.getProperty("fullName"), DB_Util.getFirstRowFirstColumn());
        Assert.assertEquals(globalName, DB_Util.getCellValue(1,2));

    }
}
