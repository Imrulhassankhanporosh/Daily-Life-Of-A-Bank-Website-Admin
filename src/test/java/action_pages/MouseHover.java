package action_pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;

import javax.swing.*;


public class MouseHover extends BasePage {

    @FindBy(xpath = "//*[@id=\"navbar-brand-centered\"]/ul/li[1]/a")
    WebElement selenium_option;

    @FindBy(linkText = "Drag and Drop Action")
    WebElement drag_and_drop_option_from_dashboard;
    public MouseHover(WebDriver driver) {
        super(driver);
    }

    public void mouseAction() throws InterruptedException {

        Actions actions = new Actions(driver);
        actions.moveToElement(selenium_option).click().build().perform();
        Thread.sleep(2000);
        actions.moveToElement(drag_and_drop_option_from_dashboard).click().build().perform();
        Thread.sleep(3000);
        driver.navigate().back();
    }
}
