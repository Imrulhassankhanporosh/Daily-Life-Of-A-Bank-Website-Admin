package action_pages;

import org.openqa.selenium.*;
import org.openqa.selenium.support.FindBy;

public class NewCustomerAdd extends BasePage {

   // String C_id;
    public static String C_id;

    @FindBy(linkText = "New Customer")
    WebElement new_cus_option_from_dashboard;
    @FindBy(name="name")
    WebElement name;

    @FindBy(xpath="//input[@value = 'f']")
    WebElement gender;

    @FindBy(name="dob")
    WebElement dob;

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


    @FindBy(xpath="//*[@id=\"customer\"]/tbody/tr[4]/td[2]")
    WebElement customer_id;





    public NewCustomerAdd(WebDriver driver) {
        super(driver);
    }

    public void addCustomer() throws InterruptedException {

        new_cus_option_from_dashboard.click();
        Thread.sleep(2000);

       // Alert Case handle
//        try {
//            Alert alert = driver.switchTo().alert();
//            //alert.dismiss();
//            //alert.accept();
//            }
//        catch (NoAlertPresentException e){
//            System.out.println("Alert was not present: " + e.getMessage());
//        }
//        Thread.sleep(2000);

        // to remove the ad manually
        driver.navigate().refresh();
        Thread.sleep(2000);
        new_cus_option_from_dashboard.click();
        Thread.sleep(2000);



        name.sendKeys("Imrul");
        Thread.sleep(2000);
        gender.click();
        Thread.sleep(2000);
        dob.sendKeys("06/10/1999");
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
        password.sendKeys("hello@122");
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

        System.out.println("New Customer Added.");

        C_id = customer_id.getText();
        System.out.println(C_id);




    }

    public static String getCustomerID(){

        return C_id;
    }

}
