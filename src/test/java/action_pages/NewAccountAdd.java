package action_pages;

import org.openqa.selenium.Alert;
import org.openqa.selenium.NoAlertPresentException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.Select;

import static action_pages.NewCustomerAdd.getCustomerID;

public class NewAccountAdd extends BasePage{

    public static String A_id;

    @FindBy(linkText = "New Account")
    WebElement new_acc_option_from_dashboard;
    @FindBy(name="cusid")
    WebElement cus_id;

    @FindBy(name="selaccount")
    WebElement acc_type_dropdown;



    @FindBy(name="inideposit")
    WebElement init_deposit_amount;



    @FindBy(name="button2")
    WebElement submit_btn;

    @FindBy(xpath="//*[@id=\"account\"]/tbody/tr[4]/td[2]")
    WebElement account_no;

    public NewAccountAdd(WebDriver driver) {
        super(driver);
    }

    public void newAccount() throws InterruptedException {
        new_acc_option_from_dashboard.click();
        Thread.sleep(2000);
        //String Cus_ID = "\"" + getCustomerID() + "\"";
        String Cus_ID =getCustomerID();
        System.out.println("Cus ID in New Account : "+Cus_ID);
        cus_id.sendKeys(Cus_ID);
        Thread.sleep(2000);
        //acc_type_dropdown.click();

        // Create a Select object
        Select dropdown = new Select(acc_type_dropdown);

        // Select by visible text
       // dropdown.selectByVisibleText("Option 1");

        // Select by value attribute
        dropdown.selectByValue("Current");
        Thread.sleep(2000);

        // Select by index
      //  dropdown.selectByIndex(2);

        init_deposit_amount.sendKeys("2000");
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

        System.out.println("Added New Account.");

        A_id = account_no.getText();
        System.out.println("AccountNo : "+ A_id);
    }

    public static String getAccountNo(){

        return A_id;
    }

}
