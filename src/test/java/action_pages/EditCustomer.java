package action_pages;

import org.openqa.selenium.Alert;
import org.openqa.selenium.NoAlertPresentException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import static action_pages.NewCustomerAdd.getCustomerID;

public class EditCustomer extends BasePage{

    @FindBy(linkText = "Edit Customer")
    WebElement edit_cus_option_from_dashboard;
    @FindBy(name="cusid")
    WebElement cus_id;

    @FindBy(name="AccSubmit")
    WebElement cus_id_submit_btn;

    @FindBy(name="addr")
    WebElement address;

    @FindBy(name="city")
    WebElement city;

    @FindBy(name="state")
    WebElement state;

    @FindBy(name="pinno")
    WebElement pin;

    @FindBy(name="telephoneno")
    WebElement mobile_no;

    @FindBy(name="emailid")
    WebElement email;

    @FindBy(name="password")
    WebElement password;

    @FindBy(name="sub")
    WebElement submit_btn;

    public EditCustomer(WebDriver driver) {
        super(driver);
    }

    public void editCustomer() throws InterruptedException {

        edit_cus_option_from_dashboard.click();
        Thread.sleep(2000);
        //String Cus_ID = "\"" + getCustomerID() + "\"";
        String Cus_ID =getCustomerID();
        System.out.println("Cus ID in Edit : "+Cus_ID);
        cus_id.sendKeys(Cus_ID);
        Thread.sleep(2000);
        cus_id_submit_btn.click();
        Thread.sleep(2000);
        address.sendKeys("Some where in the world");
        Thread.sleep(2000);
        city.sendKeys("XYZ");
        Thread.sleep(2000);
        state.sendKeys("ABC");
        Thread.sleep(2000);
        pin.sendKeys("102030");
        Thread.sleep(2000);
        mobile_no.sendKeys("01716661616");
        Thread.sleep(2000);
        String email_id = "Test" + System.currentTimeMillis() + "@abc.com";
        Thread.sleep(2000);
        email.sendKeys(email_id);
        Thread.sleep(2000);
        submit_btn.click();
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

        System.out.println("Edited Customer.");
    }
}
