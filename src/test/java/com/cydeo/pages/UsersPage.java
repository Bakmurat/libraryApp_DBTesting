package com.cydeo.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class UsersPage extends BasePage {
    @FindBy(css = ".btn-lg")
    public WebElement addUser;

    @FindBy(name = "full_name")
    public WebElement full_name;

    @FindBy(name = "password")
    public WebElement password;

    @FindBy(name = "email")
    public WebElement email;

    @FindBy(id = "user_group_id")
    public WebElement userGroupId;

    @FindBy(id = "status")
    public WebElement status;

    @FindBy(name = "start_date")
    public WebElement startDate;

    @FindBy(name = "end_date")
    public WebElement endDate;

    @FindBy(id = "address")
    public WebElement address;

    @FindBy(css = "button[type='submit']")
    public WebElement saveChangeBtn;

    @FindBy(xpath = "//table//tbody//tr[1]//td[4]")
    public WebElement firstRowEmail;

    @FindBy(xpath = "//div[@class='toast-message']")
    public WebElement verifMsg;


}
