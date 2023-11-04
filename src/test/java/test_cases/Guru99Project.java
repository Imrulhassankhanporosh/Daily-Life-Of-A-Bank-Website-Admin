package test_cases;

import action_pages.*;
import io.github.bonigarcia.wdm.WebDriverManager;
import jdk.jfr.Description;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.util.PriorityQueue;
import java.util.concurrent.TimeUnit;

public class Guru99Project {
    WebDriver driver;
    String  url = "https://demo.guru99.com/v4";

    @BeforeTest
    @Description("Browser invoke")
    public void invokeBrowser(){

        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().deleteAllCookies();

        //wait time to find the web elements
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        // to load the page , wait duration
        driver.manage().timeouts().pageLoadTimeout(60, TimeUnit.SECONDS);
    }

    @Test(priority = 0)
    @Description("Test Login with valid email and password")
    public void testLogin() throws InterruptedException {

        //This line of code is invoking the constructor of the LoginPage class that takes a WebDriver parameter, as mentioned earlier. This constructor, in turn, calls the constructor of its superclass (BasePage) using the super(driver) statement, thus initializing the driver in the BasePage class.
        LoginPage lp = new LoginPage(driver);
        driver.get("https://demo.guru99.com/v4/");
        //driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        Thread.sleep(2000);
        lp.login("mngr536665","AzenYdE");
       // driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        Thread.sleep(2000);


    }


    @Test(priority = 1)
    @Description("Add a customer")
    public void addCustomer() throws InterruptedException {

        NewCustomerAdd new_cus = new NewCustomerAdd(driver);
        new_cus.addCustomer();


    }

//    @Test(priority = 2)
//    @Description("Mouse action test by selecting dropdown options from dashboard")
//    public void mouseHover() throws InterruptedException {
//
//        MouseHover mh = new MouseHover(driver);
//        mh.mouseAction();
//
//
//    }

//    @Test(priority = 2)
//    @Description("Edit a customer")
//    public void editCustomer() throws InterruptedException {
//
//        EditCustomer edit_cus = new EditCustomer(driver);
//        edit_cus.editCustomer();
//
//
//    }
//
//    @Test(priority = 3)
//    @Description("Delete a customer")
//    public void deleteCustomer() throws InterruptedException {
//
//        DeleteCustomer del_cus = new DeleteCustomer(driver);
//        del_cus.deleteCustomer();
//
//
//    }

    @Test(priority = 4)
    @Description("Add a account")
    public void addAccount() throws InterruptedException {

        NewAccountAdd new_acc = new NewAccountAdd(driver);
        new_acc.newAccount();


    }

    @Test(priority = 5)
    @Description("Edit a account, not working, getting 500.")
    public void editAcc() throws InterruptedException {

        EditAccount edit_acc = new EditAccount(driver);
        edit_acc.editAccount();


    }

    @Test(priority = 6)
    @Description("Delete a account, not working, getting 500.")
    public void deleteAccount() throws InterruptedException {

        DeleteAccount del_acc = new DeleteAccount(driver);
        del_acc.deleteAccount();


    }
//
//    @Test(priority = 3)
//    @Description("Delete a customer")
//    public void deleteCustomer() throws InterruptedException {
//
//        DeleteCustomer del_cus = new DeleteCustomer(driver);
//        del_cus.deleteCustomer();
//
//
//    }
//
//    @Test(priority = 3)
//    @Description("Delete a customer")
//    public void deleteCustomer() throws InterruptedException {
//
//        DeleteCustomer del_cus = new DeleteCustomer(driver);
//        del_cus.deleteCustomer();
//
//
//    }
//
//    @Test(priority = 3)
//    @Description("Delete a customer")
//    public void deleteCustomer() throws InterruptedException {
//
//        DeleteCustomer del_cus = new DeleteCustomer(driver);
//        del_cus.deleteCustomer();
//
//
//    }


    @AfterTest
    @Description("Closing the browser after the test")
    public void browserClose(){

        driver.close();
    }



}
