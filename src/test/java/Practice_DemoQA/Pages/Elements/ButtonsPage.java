package Practice_DemoQA.Pages.Elements;

import Practice_DemoQA.Base.BaseTest;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public class ButtonsPage extends BaseTest {



    public ButtonsPage(){
        PageFactory.initElements(driver, this);
    }

    @FindBy(className = "main-header")
    public WebElement buttonsHeader;

    @FindBy(id = "doubleClickBtn")
    public WebElement doubleClickButton;

    @FindBy(id = "rightClickBtn")
    public WebElement rightClickButton;

    @FindBy(css = ".btn.btn-primary")
    public List<WebElement> dynamicClickButton;

    @FindBy(id = "doubleClickMessage")
    public WebElement doubleClickMessage;

    @FindBy(id = "rightClickMessage")
    public WebElement rightClickMessage;

    @FindBy(id = "dynamicClickMessage")
    public WebElement dynamicClickMessage;



    public void clickDoubleClickButton(){
        Actions actions = new Actions(driver);
        actions.doubleClick(doubleClickButton).perform();
    }

    public void clickRightClickButton(){
        Actions actions = new Actions(driver);
        actions.contextClick(rightClickButton).perform();
    }

    public void clickOnDynamicButton(){
        for (int i = 0; i < dynamicClickButton.size(); i++) {
            if(dynamicClickButton.get(i).getText().equals("Click Me")){
                dynamicClickButton.get(i).click();
            }
        }

    }






}
