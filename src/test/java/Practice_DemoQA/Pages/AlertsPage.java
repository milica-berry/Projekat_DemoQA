package Practice_DemoQA.Pages;

import Practice_DemoQA.Base.BaseTest;
import org.openqa.selenium.Alert;
import org.openqa.selenium.NoAlertPresentException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class AlertsPage extends BaseTest {


    public AlertsPage(){
        PageFactory.initElements(driver, this);
    }

    @FindBy(className = "main-header")
    public WebElement alertsMainHeader;

    @FindBy(id = "alertButton")
    public WebElement basicAlert;

    @FindBy(id = "timerAlertButton")
    public WebElement waiterAlert;

    @FindBy(id = "confirmButton")
    public WebElement confirmOrDismissAlert;

    @FindBy(id = "confirmResult")
    public WebElement confirmResultMessage;

    @FindBy(id = "promtButton")
    public WebElement promptBoxAlert;

    @FindBy(id = "promptResult")
    public WebElement promptResultMessage;



    public void clickOnBasicAlert(){
        basicAlert.click();
    }

    public void clickOnWaiterAlert(){
        waiterAlert.click();
    }

    public void clickOnConfirmOrDismissAlert(){
        confirmOrDismissAlert.click();
    }

    public void clickOnPromptBoxAlert(){
        promptBoxAlert.click();
    }

    public void acceptAlert(){
        driver.switchTo().alert().accept();
    }

    public void dismissAlert(){
        driver.switchTo().alert().dismiss();
    }

    public void sendKeysToAlert(String input){
        driver.switchTo().alert().sendKeys(input);
    }

    public boolean isAlertPresent() {
        boolean presentFlag = false;

        try {
            presentFlag = true;

        } catch (NoAlertPresentException ex) {
            ex.printStackTrace();
        }
        return presentFlag;
    }





}
