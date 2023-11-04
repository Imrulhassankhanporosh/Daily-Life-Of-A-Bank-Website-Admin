package test_cases;

import action_pages.LoginPage;
import action_pages.MouseHover;
import action_pages.NewCustomerAdd;
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

    @Test(priority = 2)
    @Description("Mouse action test by selecting dropdown options from dashboard")
    public void mouseHover() throws InterruptedException {

        MouseHover mh = new MouseHover(driver);
        mh.mouseAction();


    }


    @AfterTest
    @Description("Closing the browser after the test")
    public void browserClose(){

        driver.close();
    }



}
