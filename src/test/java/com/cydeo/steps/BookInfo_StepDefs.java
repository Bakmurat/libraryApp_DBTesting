package com.cydeo.steps;

import com.cydeo.pages.BookPage;
import com.cydeo.utility.BrowserUtil;
import com.cydeo.utility.DB_Util;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;

import java.util.Map;

public class BookInfo_StepDefs {
    BookPage bookPage=new BookPage();

    @When("the user searches for {string} book")
    public void the_user_searches_for_book(String bookName) {
        BrowserUtil.waitForClickablility(bookPage.search, 5).sendKeys(bookName);
    }
    @When("the user clicks edit book button")
    public void the_user_clicks_edit_book_button() {
        BrowserUtil.waitForClickablility(bookPage.editBook("Clean Code"), 5).click();
    }
    @Then("book information must match the Database")
    public void book_information_must_match_the_database() {
        BrowserUtil.waitFor(3);

        //get data from UI
        String actualBookName = bookPage.bookName.getAttribute("value");
        String actualAuthorName = bookPage.author.getAttribute("value");
        String actualISBN = bookPage.isbn.getAttribute("value");
        String actualYear = bookPage.year.getAttribute("value");
        String actualDesc = bookPage.description.getAttribute("value");

        //get related book info from DB
        String query="select name,author,isbn,description,year from books where name ='Clean Code'";
        DB_Util.runQuery(query);

        Map<String, String> rowMap = DB_Util.getRowMap(1);
        String expectedBookName = rowMap.get("name");
        String expectedAuthorName = rowMap.get("author");
        String expectedISBN = rowMap.get("isbn");
        String expectedDesc = rowMap.get("description");
        String expectedYear = rowMap.get("year");

        //Assertion
        Assert.assertEquals(expectedBookName,actualBookName);
        Assert.assertEquals(expectedAuthorName,actualAuthorName);
        Assert.assertEquals(expectedISBN,actualISBN);
        Assert.assertEquals(expectedDesc,actualDesc);
        Assert.assertEquals(expectedYear,actualYear);
    }

}
