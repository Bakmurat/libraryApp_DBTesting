package com.cydeo.steps;

import com.cydeo.utility.DB_Util;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;

public class Common_StepDefs {
    String expectedCategory;
    @When("I execute query to find most popular book genre")
    public void i_execute_query_to_find_most_popular_book_genre() {
        String query="select bc.name,count(*)\n" +
                "from book_borrow bb inner join books b\n" +
                "    on bb.book_id = b.id\n" +
                "                inner join book_categories bc\n" +
                "                    on b.book_category_id=bc.id\n" +
                "group by name\n" +
                "order by 2 desc";

        DB_Util.runQuery(query);
        expectedCategory = DB_Util.getFirstRowFirstColumn();
    }
    @Then("verify {string} is the most popular book genre.")
    public void verify_is_the_most_popular_book_genre(String actualCategory) {
        Assert.assertEquals(expectedCategory, actualCategory);
    }
}
