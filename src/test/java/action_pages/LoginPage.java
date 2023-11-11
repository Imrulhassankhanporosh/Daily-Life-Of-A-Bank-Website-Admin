package action_pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import javax.swing.*;
import java.time.Duration;
import java.util.concurrent.TimeUnit;

public class LoginPage extends BasePage {
    @FindBy(name="uid")
    WebElement username;

    @FindBy(name="password")
    WebElement password;

//    @FindBy(name="btnLogin")
//    WebElement login_btn;



    public LoginPage(WebDriver driver) {
        //The constructor is calling the constructor of the superclass BasePage using the super keyword, passing the driver parameter to the superclass constructor. This way, the driver is initialized in the BasePage class, which can then be used in the LoginPage class and its methods.
        super(driver);
    }

    public void login(String uname, String pass) throws InterruptedException {



        username.sendKeys(uname);
        Thread.sleep(2000);
        password.sendKeys(pass);
        Thread.sleep(2000);

        // Explicitly wait for an element (in this case, wait for the presence of an element with a specific ID)
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        WebElement element = wait.until(ExpectedConditions.presenceOfElementLocated(By.name("btnLogin")));

       // login_btn.click();
        element.click();
        Thread.sleep(2000);

        System.out.println("Login Completed.");
        
        

    }


}
