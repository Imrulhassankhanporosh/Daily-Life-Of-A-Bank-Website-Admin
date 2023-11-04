package action_pages;

import org.openqa.selenium.Alert;
import org.openqa.selenium.NoAlertPresentException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import static action_pages.NewCustomerAdd.getCustomerID;

public class DeleteCustomer extends BasePage{

    @FindBy(linkText = "Delete Customer")
    WebElement delete_cus_option_from_dashboard;
    @FindBy(name="cusid")
    WebElement cus_id;

    @FindBy(name="AccSubmit")
    WebElement cus_id_submit_btn;



    public DeleteCustomer(WebDriver driver) {
        super(driver);
    }

    public void deleteCustomer() throws InterruptedException {

        delete_cus_option_from_dashboard.click();
        Thread.sleep(2000);
        NewCustomerAdd new_cus = new NewCustomerAdd(driver);
        //String Cus_ID = "\"" + getCustomerID() + "\"";
        String Cus_ID =getCustomerID();
        System.out.println("Cus ID in Delete : "+Cus_ID);
        cus_id.sendKeys(Cus_ID);
        Thread.sleep(2000);
        cus_id_submit_btn.click();
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

        System.out.println("Deleted Customer.");
    }
}
