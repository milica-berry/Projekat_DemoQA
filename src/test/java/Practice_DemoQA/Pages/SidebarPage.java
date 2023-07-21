package Practice_DemoQA.Pages;

import Practice_DemoQA.Base.BaseTest;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public class SidebarPage extends BaseTest {


    public SidebarPage(){
        PageFactory.initElements(driver, this);
    }



    @FindBy(className = "text")
    public List<WebElement> elements;


    public void clickElementByName(String name){
        for (int i = 0; i < elements.size(); i++) {
            if(elements.get(i).getText().equals(name)){
                scrollIntoView(elements.get(i));
                elements.get(i).click();
                break;
            }
        }
    }
}
