package com.cydeo.steps;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import com.cydeo.utility.DB_Util;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class UsersInfo_StepDefs {
    @Given("Establish the database connection")
    public void establish_the_database_connection() {
        System.out.println("Establish connection.");
    }
    @When("Execute query to get all IDs from users")
    public void execute_query_to_get_all_i_ds_from_users() {
        DB_Util.runQuery("select id from users");
    }
    @Then("verify all users has unique ID")
    public void verify_all_users_has_unique_id() {
        List<String> mylist = DB_Util.getColumnDataAsList(1);
        Set<String> myset = new HashSet<String>(mylist);
        Assert.assertTrue(myset.size()==mylist.size());
    }
    @When("Execute query to get all columns")
    public void execute_query_to_get_all_columns() {
        DB_Util.runQuery("select * from users");
    }
    @Then("verify the below columns are listed in result")
    public void verify_the_below_columns_are_listed_in_result(List<String> actualCol) {
        List<String> expectedCol = DB_Util.getAllColumnNamesAsList();
        Assert.assertEquals(actualCol, expectedCol);
    }
}
