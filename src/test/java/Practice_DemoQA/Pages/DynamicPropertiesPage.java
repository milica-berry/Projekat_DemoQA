package Practice_DemoQA.Pages;

import Practice_DemoQA.Base.BaseTest;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class DynamicPropertiesPage extends BaseTest {

    public DynamicPropertiesPage(){
        PageFactory.initElements(driver, this);
    }


    @FindBy(className = "main-header")
    public WebElement dynamicPropertiesHeader;

    @FindBy(id = "enableAfter")
    public WebElement enableAfterButton;

    @FindBy(id = "visibleAfter")
    public WebElement visibleAfterButton;

    public void clickOnEnableAfterButton(){
        enableAfterButton.click();
    }

    public void clickOnVisibleAfterButton(){
        visibleAfterButton.click();
    }




}
