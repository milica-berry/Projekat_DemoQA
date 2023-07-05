package Practice_DemoQA.Pages.Elements;

import Practice_DemoQA.Base.BaseTest;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public class BrokenLinksImagesPage extends BaseTest {


    public BrokenLinksImagesPage(){
        PageFactory.initElements(driver, this);
    }


    @FindBy(className = "main-header")
    public WebElement brokenLinksImagesHeader;


    @FindBy(xpath = "//*[starts-with(@src, '/images/Toolsqa.jpg')]")
    public List<WebElement> imagesToolsQA;

    @FindBy(xpath = "//*[starts-with(@src, '/images/Toolsqa_1.jpg')]")
    public WebElement brokenImage;

    @FindBy(linkText = "Click Here for Valid Link")
    public WebElement link;

    @FindBy(linkText = "Click Here for Broken Link")
    public WebElement brokenLink;


    public Boolean imageIsPresent(WebElement element){
        Boolean imagePresent = (Boolean) ((JavascriptExecutor)driver).executeScript("return arguments[0].complete && typeof arguments[0].naturalWidth != \"undefined\" && arguments[0].naturalWidth > 0", element);
        if (!imagePresent)
        {
            System.out.println("Image not displayed.");
        }
        else
        {
            System.out.println("Image displayed.");
        }
        return imagePresent;
    }

    public void clickOnLink(){
        link.click();
    }

    public void clickOnBrokenLink(){
        brokenLink.click();
    }




}
