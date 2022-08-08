package com.cydeo.pages;

import com.cydeo.utility.BrowserUtil;
import com.cydeo.utility.ConfigurationReader;
import com.cydeo.utility.Driver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;


public class LoginPage {

    public LoginPage() {
        PageFactory.initElements(Driver.getDriver(), this);
    }

    @FindBy(id = "inputEmail")
    public WebElement emailBox;

    @FindBy(id = "inputPassword")
    public WebElement passwordBox;

    @FindBy(tagName = "button")
    public WebElement loginButton;

    @FindBy(css = ".alert")
    public WebElement errorMessage;



    public void login(String userType){

        String username=ConfigurationReader.getProperty(userType+"_username");
        String password=ConfigurationReader.getProperty(userType+"_password");


        emailBox.sendKeys(username);
        BrowserUtil.waitFor(1);
        passwordBox.sendKeys(password);
        BrowserUtil.waitFor(1);
        loginButton.click();
        BrowserUtil.waitFor(1);

    }




}
