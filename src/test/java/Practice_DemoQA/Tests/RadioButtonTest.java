package Practice_DemoQA.Tests;

import Practice_DemoQA.Base.BaseTest;
import Practice_DemoQA.Pages.Elements.HomepagePage;
import Practice_DemoQA.Pages.Elements.RadioButtonPage;
import Practice_DemoQA.Pages.Elements.SidebarPage;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class RadioButtonTest extends BaseTest {

    public HomepagePage homepagePage;
    public SidebarPage sidebarPage;
    public RadioButtonPage radioButtonPage;


    @BeforeMethod
    public void pageSetUp() {
        sidebarPage = new SidebarPage();
        radioButtonPage = new RadioButtonPage();
        homepagePage = new HomepagePage();

    }

    @Test(priority = 10)
    public void yesRadioButtonTest(){
        driver.get(homeURL);
        driver.manage().window().maximize();
        homepagePage.clickElementByName("Elements");

        Assert.assertEquals(driver.getCurrentUrl(), elementsURL);
        sidebarPage.clickElementByName("Radio Button");
        Assert.assertEquals(driver.getCurrentUrl(), radioButtonURL);
        Assert.assertEquals(getTextFromElement(radioButtonPage.radioButtonHeader), "Radio Button");


        radioButtonPage.clickOnYesRadioButton();
        Assert.assertTrue(radioButtonPage.yesRadioButton.isSelected());
        Assert.assertTrue(radioButtonPage.textSuccessMessage.isDisplayed());
        Assert.assertEquals(radioButtonPage.textSuccessMessage.getText(), "Yes");


    }

    @Test(priority = 20)
    public void impressiveRadioButtonTest(){
        driver.get(homeURL);
        driver.manage().window().maximize();
        homepagePage.clickElementByName("Elements");

        Assert.assertEquals(driver.getCurrentUrl(), elementsURL);
        sidebarPage.clickElementByName("Radio Button");
        Assert.assertEquals(driver.getCurrentUrl(), radioButtonURL);
        Assert.assertEquals(getTextFromElement(radioButtonPage.radioButtonHeader), "Radio Button");


        radioButtonPage.clickOnImpressiveRadioButton();
        Assert.assertTrue(radioButtonPage.impressiveRadioButton.isSelected());
        Assert.assertTrue(radioButtonPage.textSuccessMessage.isDisplayed());
        Assert.assertEquals(radioButtonPage.textSuccessMessage.getText(), "Impressive");


    }

    @Test(priority = 30) //treba da padne
    public void noRadioButtonTest(){
        driver.get(homeURL);
        driver.manage().window().maximize();
        homepagePage.clickElementByName("Elements");

        Assert.assertEquals(driver.getCurrentUrl(), elementsURL);
        sidebarPage.clickElementByName("Radio Button");
        Assert.assertEquals(driver.getCurrentUrl(), radioButtonURL);
        Assert.assertEquals(getTextFromElement(radioButtonPage.radioButtonHeader), "Radio Button");

        radioButtonPage.clickOnNoRadioButton();
        Assert.assertTrue(radioButtonPage.noRadioButton.isSelected());
        Assert.assertTrue(radioButtonPage.noRadioButton.isEnabled());

    }


}
