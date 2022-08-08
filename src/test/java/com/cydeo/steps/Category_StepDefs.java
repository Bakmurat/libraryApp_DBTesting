package com.cydeo.steps;

import com.cydeo.pages.BasePage;
import com.cydeo.pages.BookPage;
import com.cydeo.utility.BrowserUtil;
import com.cydeo.utility.DB_Util;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;

import java.util.List;

public class Category_StepDefs {
    BookPage bookPage = new BookPage();
    List<String> actualCategoryList;

    @When("the user clicks book categories")
    public void the_user_clicks_book_categories() {
        actualCategoryList = BrowserUtil.getAllSelectOptions(bookPage.mainCategoryElement);
        actualCategoryList.remove(0);
    }
    @Then("verify book categories must match book_categories table from db")
    public void verify_book_categories_must_match_book_categories_table_from_db() {
        String query="select name from book_categories";
        DB_Util.runQuery(query);
        List<String> expectedCategoryList = DB_Util.getColumnDataAsList(1);
        Assert.assertEquals(expectedCategoryList,actualCategoryList);
    }
}
