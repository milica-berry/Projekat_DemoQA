package Practice_DemoQA.Pages;

import Practice_DemoQA.Base.BaseTest;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public class HomepagePage extends BaseTest {

    public HomepagePage(){
        PageFactory.initElements(driver, this);
    }

    @FindBy(css = ".card.mt-4.top-card")
    public List<WebElement> cards;


    public void clickElementByName(String name){
        for (int i = 0; i < cards.size(); i++) {
            if(cards.get(i).getText().equals(name)){
                cards.get(i).click();
                break;
            }
        }
    }

    public void goToElemets(){
        driver.manage().window().maximize();
        driver.get(homeURL);
        clickElementByName("Elements");

    }

    public void goToAlertsFrameAndWindows(){
        driver.manage().window().maximize();
        driver.get(homeURL);
        clickElementByName("Alerts, Frame & Windows");

    }








}
