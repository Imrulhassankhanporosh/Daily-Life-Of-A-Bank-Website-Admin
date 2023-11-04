package action_pages;

import org.openqa.selenium.Alert;
import org.openqa.selenium.NoAlertPresentException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class LogOut extends BasePage{

    @FindBy(linkText = "Log out")
    WebElement logout_option_from_dashboard;
    public LogOut(WebDriver driver) {
        super(driver);
    }

    public void logout() throws InterruptedException {

        logout_option_from_dashboard.click();
        Thread.sleep(2000);

        //  Alert Case handle
        try {
            Alert alert = driver.switchTo().alert();
            //alert.dismiss();
            alert.accept();
        }
        catch (NoAlertPresentException e){
            System.out.println("Alert was not present: " + e.getMessage());
        }
        Thread.sleep(2000);


        System.out.println("LogOut is completed.");

    }
}
