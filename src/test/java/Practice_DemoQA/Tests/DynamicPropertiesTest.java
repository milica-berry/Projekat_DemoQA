package Practice_DemoQA.Tests;

import Practice_DemoQA.Base.BaseTest;
import Practice_DemoQA.Pages.DynamicPropertiesPage;
import Practice_DemoQA.Pages.HomepagePage;
import Practice_DemoQA.Pages.SidebarPage;

import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class DynamicPropertiesTest extends BaseTest {

    public DynamicPropertiesPage dynamicPropertiesPage;
    public SidebarPage sidebarPage;
    public HomepagePage homepagePage;


    @BeforeMethod
    public void pageSetUp() {
        sidebarPage = new SidebarPage();
        dynamicPropertiesPage = new DynamicPropertiesPage();
        homepagePage = new HomepagePage();

    }

    //Color change button


    @Test
    public void userCanClickOnEnableAfterButton(){
        driver.get(homeURL);
        driver.manage().window().maximize();
        homepagePage.clickElementByName("Elements");

        Assert.assertEquals(driver.getCurrentUrl(), elementsURL);
        sidebarPage.clickElementByName("Dynamic Properties");
        Assert.assertTrue(elementIsPresent(dynamicPropertiesPage.dynamicPropertiesHeader));
        Assert.assertEquals(driver.getCurrentUrl(), dynamicPropertiesURL);

        waitForClickability(dynamicPropertiesPage.enableAfterButton);
        dynamicPropertiesPage.clickOnEnableAfterButton();

    }

    @Test
    public void userCanClickOnVisibleAfterButton(){
        driver.get(homeURL);
        driver.manage().window().maximize();
        homepagePage.clickElementByName("Elements");

        Assert.assertEquals(driver.getCurrentUrl(), elementsURL);
        sidebarPage.clickElementByName("Dynamic Properties");
        Assert.assertTrue(elementIsPresent(dynamicPropertiesPage.dynamicPropertiesHeader));
        Assert.assertEquals(driver.getCurrentUrl(), dynamicPropertiesURL);

        waitForVisibility(dynamicPropertiesPage.visibleAfterButton);
        dynamicPropertiesPage.clickOnVisibleAfterButton();


        //String color = driver.findElements(By.cssSelector(".mt-4.text-danger.btn.btn-primary")).getCssValue("background-color");

    }
}
