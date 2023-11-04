package action_pages;

import org.openqa.selenium.Alert;
import org.openqa.selenium.NoAlertPresentException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import static action_pages.NewAccountAdd.getAccountNo;

public class Withdrawal extends BasePage{

    @FindBy(linkText = "Withdrawal")
    WebElement withdrawal_option_from_dashboard;
    @FindBy(name="accountno")
    WebElement acc_no;

    @FindBy(name="ammount")
    WebElement withdrawal_amount;

    @FindBy(name="desc")
    WebElement withdrawal_desc;

    @FindBy(name="AccSubmit")
    WebElement acc_no_submit_btn;
    public Withdrawal(WebDriver driver) {
        super(driver);
    }

    public void withdrawal_amount() throws InterruptedException {
        withdrawal_option_from_dashboard.click();
        Thread.sleep(2000);

        String Acc_No =getAccountNo();
        System.out.println("Acc No in Withdrawal Option : "+Acc_No);
        acc_no.sendKeys(Acc_No);
        Thread.sleep(2000);

        withdrawal_amount.sendKeys("1000");
        Thread.sleep(2000);

        withdrawal_desc.sendKeys("withdrawal amount is 1000");
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


        System.out.println("Withdrawal in New Account.");
    }
}
