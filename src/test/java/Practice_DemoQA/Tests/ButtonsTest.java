package Practice_DemoQA.Tests;

import Practice_DemoQA.Base.BaseTest;
import Practice_DemoQA.Pages.ButtonsPage;
import Practice_DemoQA.Pages.HomepagePage;
import Practice_DemoQA.Pages.SidebarPage;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class ButtonsTest extends BaseTest {

    public ButtonsPage buttonsPage;
    public HomepagePage homepagePage;
    public SidebarPage sidebarPage;


    String validDoubleClickMessage;
    String validRightClickMessage;
    String validDynamicClickMessage;

    @BeforeMethod
    public void pageSetUp() {
        sidebarPage = new SidebarPage();
        buttonsPage = new ButtonsPage();
        homepagePage = new HomepagePage();
        validDoubleClickMessage = excelReader.getStringData("Messages", 1, 0);
        validRightClickMessage = excelReader.getStringData("Messages", 2, 0);
        validDynamicClickMessage = excelReader.getStringData("Messages", 3, 0);


    }

    @Test
    public void userCanClickDoubleClickButton(){
        driver.get(homeURL);
        driver.manage().window().maximize();
        homepagePage.clickElementByName("Elements");

        Assert.assertEquals(driver.getCurrentUrl(), elementsURL);

        sidebarPage.clickElementByName("Buttons");
        Assert.assertTrue(elementIsPresent(buttonsPage.buttonsHeader));
        Assert.assertEquals(driver.getCurrentUrl(), buttonsURL);

        buttonsPage.clickDoubleClickButton();
        Assert.assertTrue(buttonsPage.elementIsPresent(buttonsPage.doubleClickMessage));
        Assert.assertEquals(getTextFromElement(buttonsPage.doubleClickMessage), validDoubleClickMessage);

    }

    @Test
    public void userCanClickRightClickButton(){
        driver.get(homeURL);
        driver.manage().window().maximize();
        homepagePage.clickElementByName("Elements");

        Assert.assertEquals(driver.getCurrentUrl(), elementsURL);

        sidebarPage.clickElementByName("Buttons");
        Assert.assertTrue(elementIsPresent(buttonsPage.buttonsHeader));
        Assert.assertEquals(driver.getCurrentUrl(), buttonsURL);

        buttonsPage.clickRightClickButton();
        Assert.assertTrue(buttonsPage.elementIsPresent(buttonsPage.rightClickMessage));
        Assert.assertEquals(getTextFromElement(buttonsPage.rightClickMessage), validRightClickMessage);


    }


    @Test
    public void userCanClickDynamicButton(){
        driver.get(homeURL);
        driver.manage().window().maximize();
        homepagePage.clickElementByName("Elements");

        sidebarPage.clickElementByName("Buttons");
        Assert.assertTrue(elementIsPresent(buttonsPage.buttonsHeader));
        Assert.assertEquals(driver.getCurrentUrl(), buttonsURL);

        buttonsPage.clickOnDynamicButton();
        Assert.assertTrue(buttonsPage.elementIsPresent(buttonsPage.dynamicClickMessage));
        Assert.assertEquals(getTextFromElement(buttonsPage.dynamicClickMessage), validDynamicClickMessage);

    }
}
