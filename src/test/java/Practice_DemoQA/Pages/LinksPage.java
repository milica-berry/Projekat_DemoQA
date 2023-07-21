package Practice_DemoQA.Pages;

import Practice_DemoQA.Base.BaseTest;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

import java.util.ArrayList;
import java.util.List;

public class LinksPage extends BaseTest {

    public LinksPage(){
        PageFactory.initElements(driver, this);
    }

    @FindBy(className = "main-header")
    public WebElement linksHeader;

    @FindBy(id = "simpleLink")
    public WebElement simpleLink;

    @FindBy(id = "dynamicLink")
    public WebElement dynamicLink;

    @FindBy(id = "created")
    public WebElement createdAPILink;

    @FindBy(id = "no-content")
    public WebElement noContentAPILink;

    @FindBy(id = "moved")
    public WebElement movedAPILink;

    @FindBy(id = "bad-request")
    public WebElement badRequestAPILink;

    @FindBy(id = "unauthorized")
    public WebElement unauthorizedAPILink;

    @FindBy(id = "forbidden")
    public WebElement forbiddenAPILink;

    @FindBy(id = "invalid-url")
    public WebElement notFoundAPILink;

    @FindBy(id = "linkWrapper")
    public WebElement responseMessage;




    public void clickOnSimpleLink(){
        simpleLink.click();
    }

    public void clickOnDynamicLink(){
        dynamicLink.click();
    }

    public void clickOnCreated(){
        createdAPILink.click();
    }

    public void clickOnNoContent(){
        noContentAPILink.click();
    }

    public void clickOnMoved(){
        movedAPILink.click();
    }

    public void clickOnBadRequest(){
        badRequestAPILink.click();
    }

    public void clickOnUnauthorized(){
        unauthorizedAPILink.click();
    }

    public void clickOnForbidden(){
        forbiddenAPILink.click();
    }

    public void clickOnNotFound(){
        notFoundAPILink.click();
    }










}
