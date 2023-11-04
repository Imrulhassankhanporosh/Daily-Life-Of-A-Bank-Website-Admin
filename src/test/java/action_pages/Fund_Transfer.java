package action_pages;

import org.openqa.selenium.Alert;
import org.openqa.selenium.NoAlertPresentException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import static action_pages.NewAccountAdd.getAccountNo;

public class Fund_Transfer extends BasePage{

    @FindBy(linkText = "Fund Transfer")
    WebElement fund_transfer_option_from_dashboard;
    @FindBy(name="payersaccount")
    WebElement payers_acc_no;


    @FindBy(name="payeeaccount")
    WebElement payees_acc_no;

    @FindBy(name="ammount")
    WebElement fund_transfer_amount;

    @FindBy(name="desc")
    WebElement fund_transfer_desc;

    @FindBy(name="AccSubmit")
    WebElement acc_no_submit_btn;
    public Fund_Transfer(WebDriver driver) {
        super(driver);
    }

    public void fundTransfer() throws InterruptedException {

        fund_transfer_option_from_dashboard.click();
        Thread.sleep(2000);

        payers_acc_no.sendKeys("128893");
        Thread.sleep(2000);

        String Acc_No =getAccountNo();
        System.out.println("Acc No in Fund Transfer Option : "+Acc_No);
        payees_acc_no.sendKeys(Acc_No);
        Thread.sleep(2000);

        fund_transfer_amount.sendKeys("1200");
        Thread.sleep(2000);

        fund_transfer_desc.sendKeys("fund transfer amount is 1200");
        Thread.sleep(2000);

        acc_no_submit_btn.click();
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


        System.out.println("Fund Transfer between two Accounts.");

    }
}
