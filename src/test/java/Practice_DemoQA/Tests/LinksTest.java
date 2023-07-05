package Practice_DemoQA.Tests;

import Practice_DemoQA.Base.BaseTest;
import Practice_DemoQA.Pages.Elements.HomepagePage;
import Practice_DemoQA.Pages.Elements.LinksPage;
import Practice_DemoQA.Pages.Elements.SidebarPage;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;


public class LinksTest extends BaseTest {

    public HomepagePage homepagePage;
    public SidebarPage sidebarPage;
    public LinksPage linksPage;


    @BeforeMethod
    public void pageSetUp(){
        linksPage = new LinksPage();
        sidebarPage = new SidebarPage();
        homepagePage = new HomepagePage();

    }

    @Test(priority = 10)
    public void userCanOpenSimpleLink(){
        driver.get(homeURL);
        driver.manage().window().maximize();
        homepagePage.clickElementByName("Elements");

        Assert.assertEquals(driver.getCurrentUrl(), elementsURL);
        sidebarPage.clickElementByName("Links");
        Assert.assertEquals(driver.getCurrentUrl(), linksURL);
        Assert.assertTrue(elementIsPresent(linksPage.linksHeader));
        Assert.assertEquals(getTextFromElement(linksPage.linksHeader), "Links");

        linksPage.clickOnSimpleLink();
        Assert.assertTrue(newWindowOrTabIsEqual("https://demoqa.com/"));
    }

    @Test(priority = 20)
    public void userCanOpenDynamicLink(){
        driver.get(homeURL);
        driver.manage().window().maximize();
        homepagePage.clickElementByName("Elements");

        Assert.assertEquals(driver.getCurrentUrl(), elementsURL);
        sidebarPage.clickElementByName("Links");
        Assert.assertEquals(driver.getCurrentUrl(), linksURL);
        Assert.assertTrue(elementIsPresent(linksPage.linksHeader));
        Assert.assertEquals(getTextFromElement(linksPage.linksHeader), "Links");

        linksPage.clickOnDynamicLink();
        Assert.assertTrue(newWindowOrTabIsEqual("https://demoqa.com/"));
    }

    @Test(priority = 30)
    public void userCanSendCreatedAPICall(){
        driver.get(homeURL);
        driver.manage().window().maximize();
        homepagePage.clickElementByName("Elements");

        Assert.assertEquals(driver.getCurrentUrl(), elementsURL);
        sidebarPage.clickElementByName("Links");
        Assert.assertEquals(driver.getCurrentUrl(), linksURL);
        Assert.assertTrue(elementIsPresent(linksPage.linksHeader));
        Assert.assertEquals(getTextFromElement(linksPage.linksHeader), "Links");

        linksPage.clickOnCreated();
        Assert.assertTrue(linksPage.responseMessage.isDisplayed());
        Assert.assertTrue(linksPage.responseMessage.getText().contains("201"));
    }

    @Test(priority = 40)
    public void userCanSendNoContentAPICall(){
        driver.get(homeURL);
        driver.manage().window().maximize();
        homepagePage.clickElementByName("Elements");

        Assert.assertEquals(driver.getCurrentUrl(), elementsURL);
        sidebarPage.clickElementByName("Links");
        Assert.assertEquals(driver.getCurrentUrl(), linksURL);
        Assert.assertTrue(elementIsPresent(linksPage.linksHeader));
        Assert.assertEquals(getTextFromElement(linksPage.linksHeader), "Links");

        linksPage.clickOnNoContent();
        Assert.assertTrue(linksPage.responseMessage.isDisplayed());
        Assert.assertTrue(linksPage.responseMessage.getText().contains("204"));
    }

    @Test(priority = 50)
    public void userCanSendMovedAPICall(){
        driver.get(homeURL);
        driver.manage().window().maximize();
        homepagePage.clickElementByName("Elements");

        Assert.assertEquals(driver.getCurrentUrl(), elementsURL);
        sidebarPage.clickElementByName("Links");
        Assert.assertEquals(driver.getCurrentUrl(), linksURL);
        Assert.assertTrue(elementIsPresent(linksPage.linksHeader));
        Assert.assertEquals(getTextFromElement(linksPage.linksHeader), "Links");

        linksPage.clickOnMoved();
        Assert.assertTrue(linksPage.responseMessage.isDisplayed());
        Assert.assertTrue(linksPage.responseMessage.getText().contains("301"));
    }

    @Test(priority = 60)
    public void userCanSendBadRequestAPICall(){
        driver.get(homeURL);
        driver.manage().window().maximize();
        homepagePage.clickElementByName("Elements");

        Assert.assertEquals(driver.getCurrentUrl(), elementsURL);
        sidebarPage.clickElementByName("Links");
        Assert.assertEquals(driver.getCurrentUrl(), linksURL);
        Assert.assertTrue(elementIsPresent(linksPage.linksHeader));
        Assert.assertEquals(getTextFromElement(linksPage.linksHeader), "Links");

        linksPage.clickOnBadRequest();
        Assert.assertTrue(linksPage.responseMessage.isDisplayed());
        Assert.assertTrue(linksPage.responseMessage.getText().contains("400"));
    }

    @Test(priority = 70)
    public void userCanSendUnauthorizedAPICall(){
        driver.get(homeURL);
        driver.manage().window().maximize();
        homepagePage.clickElementByName("Elements");

        Assert.assertEquals(driver.getCurrentUrl(), elementsURL);
        sidebarPage.clickElementByName("Links");
        Assert.assertEquals(driver.getCurrentUrl(), linksURL);
        Assert.assertTrue(elementIsPresent(linksPage.linksHeader));
        Assert.assertEquals(getTextFromElement(linksPage.linksHeader), "Links");

        linksPage.clickOnUnauthorized();
        Assert.assertTrue(linksPage.responseMessage.isDisplayed());
        Assert.assertTrue(linksPage.responseMessage.getText().contains("401"));
    }

    @Test(priority = 80)
    public void userCanSendForbiddenAPICall(){
        driver.get(homeURL);
        driver.manage().window().maximize();
        homepagePage.clickElementByName("Elements");

        Assert.assertEquals(driver.getCurrentUrl(), elementsURL);
        sidebarPage.clickElementByName("Links");
        Assert.assertEquals(driver.getCurrentUrl(), linksURL);
        Assert.assertTrue(elementIsPresent(linksPage.linksHeader));
        Assert.assertEquals(getTextFromElement(linksPage.linksHeader), "Links");

        linksPage.clickOnForbidden();
        Assert.assertTrue(linksPage.responseMessage.isDisplayed());
        Assert.assertTrue(linksPage.responseMessage.getText().contains("403"));
    }

    @Test(priority = 90)
    public void userCanSendNotFoundAPICall(){
        driver.get(homeURL);
        driver.manage().window().maximize();
        homepagePage.clickElementByName("Elements");

        Assert.assertEquals(driver.getCurrentUrl(), elementsURL);
        sidebarPage.clickElementByName("Links");
        Assert.assertEquals(driver.getCurrentUrl(), linksURL);
        Assert.assertTrue(elementIsPresent(linksPage.linksHeader));
        Assert.assertEquals(getTextFromElement(linksPage.linksHeader), "Links");

        linksPage.clickOnNotFound();
        Assert.assertTrue(linksPage.responseMessage.isDisplayed());
        Assert.assertTrue(linksPage.responseMessage.getText().contains("404"));
    }





    }

