package Practice_DemoQA.Tests;

import Practice_DemoQA.Base.BaseTest;
import Practice_DemoQA.Pages.Elements.BrokenLinksImagesPage;
import Practice_DemoQA.Pages.Elements.HomepagePage;
import Practice_DemoQA.Pages.Elements.SidebarPage;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class BrokenLinksImagesTest extends BaseTest {

    public HomepagePage homepagePage;
    public SidebarPage sidebarPage;
    public BrokenLinksImagesPage brokenLinksImagesPage;



    @BeforeMethod
    public void pageSetUp() {
        sidebarPage = new SidebarPage();
        brokenLinksImagesPage = new BrokenLinksImagesPage();
        homepagePage = new HomepagePage();

    }

    @Test
    public void userCanSeeImages(){ //treba da padne kod druge asertacije
        driver.get(homeURL);
        driver.manage().window().maximize();
        homepagePage.clickElementByName("Elements");

        sidebarPage.clickElementByName("Broken Links - Images");
        Assert.assertTrue(elementIsPresent(brokenLinksImagesPage.brokenLinksImagesHeader));
        Assert.assertEquals(driver.getCurrentUrl(), brokenLinksImagesURL);

        Assert.assertTrue(brokenLinksImagesPage.imageIsPresent(brokenLinksImagesPage.imagesToolsQA.get(1)));
        Assert.assertTrue(brokenLinksImagesPage.imageIsPresent(brokenLinksImagesPage.brokenImage));

    }

    @Test
    public void userCanGoToLink(){
        driver.get(homeURL);
        driver.manage().window().maximize();
        homepagePage.clickElementByName("Elements");

        Assert.assertEquals(driver.getCurrentUrl(), elementsURL);
        sidebarPage.clickElementByName("Broken Links - Images");
        Assert.assertTrue(elementIsPresent(brokenLinksImagesPage.brokenLinksImagesHeader));
        Assert.assertEquals(driver.getCurrentUrl(), brokenLinksImagesURL);

        brokenLinksImagesPage.clickOnLink();
        Assert.assertEquals(driver.getCurrentUrl(), homeURL);

        brokenLinksImagesPage.clickOnBrokenLink();
        Assert.assertEquals(driver.getCurrentUrl(), homeURL);


    }

    @Test
    public void userCanGoToBrokenLink(){ //treba da padne
        driver.get(homeURL);
        driver.manage().window().maximize();
        homepagePage.clickElementByName("Elements");

        Assert.assertEquals(driver.getCurrentUrl(), elementsURL);
        sidebarPage.clickElementByName("Broken Links - Images");
        Assert.assertTrue(elementIsPresent(brokenLinksImagesPage.brokenLinksImagesHeader));
        Assert.assertEquals(driver.getCurrentUrl(), brokenLinksImagesURL);

        brokenLinksImagesPage.clickOnBrokenLink();
        Assert.assertEquals(driver.getCurrentUrl(), homeURL);


    }




}
