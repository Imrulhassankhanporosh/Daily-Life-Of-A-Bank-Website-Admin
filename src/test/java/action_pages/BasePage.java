package action_pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

public class BasePage {

    protected WebDriver driver;

    public BasePage(WebDriver driver){

        this.driver= driver;

        //This method initializes web elements in the current page class, allowing you to use @FindBy annotations to locate elements on the page.
        PageFactory.initElements(driver,this);
    }


}
