package test_cases;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.concurrent.TimeUnit;

public class Setup {

    WebDriver driver;
    String url = "https://test.qatechhub.com/";
    String ExpectedTitle = "QA Automation Tools Trainings and Tutorials | QA Tech Hub";

    public void browserSetup(){

        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();

        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.get(url);
    }

    public void getTitle() {

        String Title = driver.getTitle();
        //System.out.println(Title);
        if (Title == ExpectedTitle) {
            System.out.println("PASS");
        }
        else {
            System.out.println("FAIL");
        }

    }

    public void nagivateMethods(){

        driver.navigate().to("https://www.facebook.com");
        driver.navigate().back();
        String URL = driver.getCurrentUrl();
        System.out.println(URL);
        driver.navigate().forward();
        driver.navigate().refresh();
    }

    public void closeBrowser(){

        driver.close();
    }

    public static void main(String[] args) {

        Setup setup = new Setup();
        setup.browserSetup();
        setup.getTitle();
        setup.nagivateMethods();
        setup.closeBrowser();


    }




}
