package Practice_DemoQA.Pages.AlertsFrameAndWindows;

import Practice_DemoQA.Base.BaseTest;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;


public class BrowserWindowsPage extends BaseTest {


    public BrowserWindowsPage(){
        PageFactory.initElements(driver, this);
    }

    @FindBy(id = "tabButton")
    public WebElement newTabButton;

    @FindBy(id = "windowButton")
    public WebElement newWindowButton;


    @FindBy(id = "messageWindowButton")
    public WebElement messageWindowButton;

    @FindBy(tagName = "body")
    public WebElement windowMessage;

    @FindBy(id = "sampleHeading")
    public WebElement sampleHeading;

    public void clickOnNewTabButton(){
        newTabButton.click();
    }

    public void clickOnNewWindowButton(){
        newWindowButton.click();
    }

    public void clickOnMessageWindowButton(){
        messageWindowButton.click();
    }

    public String messageFromWindow(){
        return windowMessage.getText();
    }




}
