package Practice_DemoQA.Tests;

import Practice_DemoQA.Base.BaseTest;
import Practice_DemoQA.Pages.Elements.CheckBoxPage;
import Practice_DemoQA.Pages.Elements.HomepagePage;
import Practice_DemoQA.Pages.Elements.SidebarPage;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class CheckBoxTest extends BaseTest {

    public CheckBoxPage checkBoxPage;
    public HomepagePage homepagePage;
    public SidebarPage sidebarPage;


    //ASERTACIJE

    String resultAllFiles;

    @BeforeMethod
    public void pageSetUp() {
        sidebarPage = new SidebarPage();
        checkBoxPage = new CheckBoxPage();
        homepagePage = new HomepagePage();

        resultAllFiles = excelReader.getStringData("Messages", 5, 0);

    }

    @Test
    public void userCanExtendAllFoldersOnPlusButton(){
        driver.get(homeURL);
        driver.manage().window().maximize();
        homepagePage.clickElementByName("Elements");

        Assert.assertEquals(driver.getCurrentUrl(), elementsURL);
        sidebarPage.clickElementByName("Check Box");
        Assert.assertEquals(driver.getCurrentUrl(), checkBoxURL);
        Assert.assertEquals(getTextFromElement(checkBoxPage.checkBoxHeader), "Check Box");

        checkBoxPage.extendAll();
        Assert.assertFalse(elementIsPresent(checkBoxPage.collapsedNode));


    }

    @Test
    public void userCanCollapseAllFoldersOnMinusButton(){
        driver.get(homeURL);
        driver.manage().window().maximize();
        homepagePage.clickElementByName("Elements");

        Assert.assertEquals(driver.getCurrentUrl(), elementsURL);
        sidebarPage.clickElementByName("Check Box");
        Assert.assertEquals(driver.getCurrentUrl(), checkBoxURL);
        Assert.assertEquals(getTextFromElement(checkBoxPage.checkBoxHeader), "Check Box");

        checkBoxPage.collapseAll();
        Assert.assertFalse(elementIsPresent(checkBoxPage.expandedNode));

    }

    @Test
    public void userCanCheckAllFoldersByClickingOnHomeButton(){
        driver.get(homeURL);
        driver.manage().window().maximize();
        homepagePage.clickElementByName("Elements");

        Assert.assertEquals(driver.getCurrentUrl(), elementsURL);
        sidebarPage.clickElementByName("Check Box");
        Assert.assertEquals(driver.getCurrentUrl(), checkBoxURL);
        Assert.assertEquals(getTextFromElement(checkBoxPage.checkBoxHeader), "Check Box");

        checkBoxPage.clickOnHomeCheckBox();
        Assert.assertTrue(elementIsPresent(checkBoxPage.result));
        Assert.assertEquals(checkBoxPage.result.getText(), resultAllFiles);
    }

    @Test
    public void userCanExtendAllFoldersIndividually(){
        driver.get(homeURL);
        driver.manage().window().maximize();
        homepagePage.clickElementByName("Elements");


        Assert.assertEquals(driver.getCurrentUrl(), elementsURL);
        sidebarPage.clickElementByName("Check Box");
        Assert.assertEquals(driver.getCurrentUrl(), checkBoxURL);
        Assert.assertEquals(getTextFromElement(checkBoxPage.checkBoxHeader), "Check Box");

        for (int i = 0; i < checkBoxPage.collapseAndExpandArrows.size(); i++) {
            scrollIntoView(checkBoxPage.collapseAndExpandArrows.get(i));
            checkBoxPage.collapseAndExpandArrows.get(i).click();
            Assert.assertTrue(checkBoxPage.collapseAndExpandArrows.get(i).isEnabled());

        }
    }

    @Test
    public void userCanCheckAllFilesIndividually(){
        driver.get(homeURL);
        driver.manage().window().maximize();
        homepagePage.clickElementByName("Elements");

        Assert.assertEquals(driver.getCurrentUrl(), elementsURL);
        sidebarPage.clickElementByName("Check Box");
        Assert.assertEquals(driver.getCurrentUrl(), checkBoxURL);
        Assert.assertEquals(getTextFromElement(checkBoxPage.checkBoxHeader), "Check Box");


        for (int i = 0; i < checkBoxPage.collapseAndExpandArrows.size(); i++) {
            scrollIntoView(checkBoxPage.collapseAndExpandArrows.get(i));
            checkBoxPage.collapseAndExpandArrows.get(i).click();
            Assert.assertTrue(checkBoxPage.collapseAndExpandArrows.get(i).isEnabled());


        }

        for (int i = 0; i < checkBoxPage.checkBoxes.size(); i++) {
            scrollIntoView(checkBoxPage.checkBoxes.get(i));
            checkBoxPage.checkBoxes.get(i).click();
            Assert.assertTrue(checkBoxPage.checkBoxes.get(i).isEnabled());
            checkBoxPage.checkBoxes.get(i).click();
        }

    }


}
