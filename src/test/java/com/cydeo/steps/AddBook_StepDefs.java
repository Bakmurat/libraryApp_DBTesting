package com.cydeo.steps;

import com.cydeo.pages.BookPage;
import com.cydeo.utility.BrowserUtil;
import com.cydeo.utility.DB_Util;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.Select;

public class AddBook_StepDefs {
    BookPage bookPage=new BookPage();

    @When("the librarian click to add book")
    public void the_librarian_click_to_add_book() {
        bookPage.addBook.click();
    }
    @When("the librarian enter book name {string}")
    public void the_librarian_enter_book_name(String bookName) {
        bookPage.inBookName.sendKeys(bookName);
    }
    @When("the librarian enter ISBN {string}")
    public void the_librarian_enter_isbn(String ISBN) {
        bookPage.inISBN.sendKeys(ISBN);
    }
    @When("the librarian enter year {string}")
    public void the_librarian_enter_year(String year) {
        bookPage.inYear.sendKeys(year);
    }
    @When("the librarian enter author {string}")
    public void the_librarian_enter_author(String author) {
        bookPage.inAuthor.sendKeys(author);
    }
    @When("the librarian choose the book category {string}")
    public void the_librarian_choose_the_book_category(String category) {
        Select catDropdown = new Select(bookPage.inCategory);
        catDropdown.selectByVisibleText(category);
    }
    @When("the librarian click to save changes")
    public void the_librarian_click_to_save_changes() {
        bookPage.btnSave.click();
    }
    @Then("verify “The book has been created\" message is displayed")
    public void verify_the_book_has_been_created_message_is_displayed() {
        Assert.assertEquals("The book has been created.", bookPage.createdTxt.getText());
    }
    @Then("verify {string} information must match with DB")
    public void verify_information_must_match_with_db(String expectedbookName) {
        String query="select name from books where name = '"+expectedbookName+"'";
        DB_Util.runQuery(query);

        String actualBookName = DB_Util.getFirstRowFirstColumn();
        Assert.assertEquals(expectedbookName, actualBookName);
    }
}
