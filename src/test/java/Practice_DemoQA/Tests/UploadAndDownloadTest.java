package Practice_DemoQA.Tests;

import Practice_DemoQA.Base.BaseTest;
import Practice_DemoQA.Pages.Elements.HomepagePage;
import Practice_DemoQA.Pages.Elements.SidebarPage;
import Practice_DemoQA.Pages.Elements.UploadAndDownloadPage;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.io.File;

public class UploadAndDownloadTest extends BaseTest {

    public HomepagePage homepagePage;

    public SidebarPage sidebarPage;
    public UploadAndDownloadPage uploadAndDownloadPage;


    @BeforeMethod
    public void pageSetUp() {
        homepagePage = new HomepagePage();
        sidebarPage = new SidebarPage();
        uploadAndDownloadPage = new UploadAndDownloadPage();


    }

    @Test
    public void userCanDownloadFile() throws InterruptedException {
        driver.get(homeURL);
        driver.manage().window().maximize();
        homepagePage.clickElementByName("Elements");


        Assert.assertEquals(driver.getCurrentUrl(), elementsURL);
        sidebarPage.clickElementByName("Upload and Download");
        Assert.assertEquals(driver.getCurrentUrl(), uploadAndDownloadURL);
        Assert.assertEquals(getTextFromElement(uploadAndDownloadPage.uploadAndDownloadHeader), "Upload and Download");

        uploadAndDownloadPage.clickOnDownloadButton();
        File image = new File("C:\\Users\\HP\\Downloads\\sampleFile.jpeg");
        Thread.sleep(3000);
        Assert.assertTrue(image.exists());
    }


    @Test
    public void userCanUploadFile(){
        driver.get(homeURL);
        driver.manage().window().maximize();
        homepagePage.clickElementByName("Elements");

        Assert.assertEquals(driver.getCurrentUrl(), elementsURL);
        sidebarPage.clickElementByName("Upload and Download");
        Assert.assertEquals(driver.getCurrentUrl(), uploadAndDownloadURL);
        Assert.assertEquals(getTextFromElement(uploadAndDownloadPage.uploadAndDownloadHeader), "Upload and Download");

        uploadAndDownloadPage.uploadImage();
        Assert.assertTrue(uploadAndDownloadPage.uploadedMessage.isDisplayed());




    }


}
