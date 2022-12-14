package com.cydeo.pages;

import com.cydeo.utility.Driver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;

public class BookPage extends BasePage {

    @FindBy(xpath = "//table/tbody/tr")
    public List<WebElement> allRows;

    @FindBy(xpath = "//input[@type='search']")
    public WebElement search;

    @FindBy(id = "book_categories")
    public WebElement mainCategoryElement;

    @FindBy(name = "name")
    public WebElement bookName;

    @FindBy(xpath = "(//input[@type='text'])[4]")
    public WebElement author;

    @FindBy(name = "year")
    public WebElement year;

    @FindBy(name = "isbn")
    public WebElement isbn;

    @FindBy(id = "description")
    public WebElement description;

    @FindBy(css = ".btn-lg")
    public WebElement addBook;

    @FindBy(name = "name")
    public WebElement inBookName;

    @FindBy(name = "isbn")
    public WebElement inISBN;

    @FindBy(name = "year")
    public WebElement inYear;

    @FindBy(xpath = "//input[@name='author']")
    public WebElement inAuthor;

    @FindBy(id = "book_group_id")
    public WebElement inCategory;

    @FindBy(css = "button[type='submit']")
    public WebElement btnSave;

    @FindBy(xpath = "//div[@class='toast-message']")
    public WebElement createdTxt;



    public WebElement editBook(String book) {
        String xpath = "//td[3][.='" + book + "']/../td/a";
        return Driver.getDriver().findElement(By.xpath(xpath));
    }




}
