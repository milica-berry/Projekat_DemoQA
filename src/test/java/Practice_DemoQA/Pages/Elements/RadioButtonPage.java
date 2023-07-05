package Practice_DemoQA.Pages.Elements;

import Practice_DemoQA.Base.BaseTest;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class RadioButtonPage extends BaseTest {
    public Actions actions;

    public RadioButtonPage(){
        PageFactory.initElements(driver, this);
    }

    @FindBy(className = "main-header")
    public WebElement radioButtonHeader;

    @FindBy(id = "yesRadio")
    public WebElement yesRadioButton;

    @FindBy(id = "impressiveRadio")
    public WebElement impressiveRadioButton;

    @FindBy(id = "noRadio")
    public WebElement noRadioButton;

    @FindBy(className = "text-success")
    public WebElement textSuccessMessage;




    public void clickOnYesRadioButton(){
        scrollIntoView(yesRadioButton);
        Actions actions = new Actions(driver);
        actions.click(yesRadioButton).perform();
    }

    public void clickOnImpressiveRadioButton(){
        scrollIntoView(impressiveRadioButton);
        Actions actions = new Actions(driver);
        actions.click(impressiveRadioButton).perform();
    }

    public void clickOnNoRadioButton(){
        scrollIntoView(noRadioButton);
        Actions actions = new Actions(driver);
        actions.click(noRadioButton).perform();
    }


}
