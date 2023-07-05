package Practice_DemoQA.Tests;

import Practice_DemoQA.Base.BaseTest;
import Practice_DemoQA.Pages.Elements.HomepagePage;
import Practice_DemoQA.Pages.Elements.SidebarPage;
import Practice_DemoQA.Pages.Elements.TextBoxPage;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class TextBoxTest extends BaseTest {

    public HomepagePage homepagePage;

    public SidebarPage sidebarPage;
    public TextBoxPage textBoxPage;

    String validFullName;
    String validEmail;
    String validCurrentAddress;
    String validPermanentAddress;
    String invalidEmail;


    @BeforeMethod
    public void pageSetUp() {
        validFullName = excelReader.getStringData("Credentials", 1, 0);
        validEmail = excelReader.getStringData("Credentials", 1, 1);
        validCurrentAddress = excelReader.getStringData("Credentials", 1, 2);
        validPermanentAddress = excelReader.getStringData("Credentials", 1, 3);

        homepagePage = new HomepagePage();
        sidebarPage = new SidebarPage();
        textBoxPage = new TextBoxPage();


    }

    @Test
    public void userCanSubmitDataUsingValidCredentials() {
        driver.get(homeURL);
        driver.manage().window().maximize();
        homepagePage.clickElementByName("Elements");


        Assert.assertEquals(driver.getCurrentUrl(), elementsURL);
        sidebarPage.clickElementByName("Text Box");
        Assert.assertEquals(driver.getCurrentUrl(), textBoxURL);
        Assert.assertEquals(getTextFromElement(textBoxPage.header), "Text Box");

        textBoxPage.enterFullName(validFullName);
        textBoxPage.enterEmail(validEmail);
        textBoxPage.enterCurrentAddress(validCurrentAddress);
        textBoxPage.enterPermanentAddress(validPermanentAddress);
        scrollIntoView(textBoxPage.submitButton);
        textBoxPage.clickOnSubmitButton();
        Assert.assertTrue(textBoxPage.outputMessage.isDisplayed());

    }

    @Test
    public void userCannotSubmitDataUsingInvalidEmail() {
        driver.get(homeURL);
        driver.manage().window().maximize();
        homepagePage.clickElementByName("Elements");

        Assert.assertEquals(driver.getCurrentUrl(), elementsURL);
        sidebarPage.clickElementByName("Text Box");
        Assert.assertEquals(driver.getCurrentUrl(), textBoxURL);
        Assert.assertEquals(getTextFromElement(textBoxPage.header), "Text Box");

        for (int i = 2; i <= excelReader.getLastRow("Credentials"); i++) {
            textBoxPage.enterFullName(validFullName);
            textBoxPage.enterCurrentAddress(validCurrentAddress);
            textBoxPage.enterPermanentAddress(validPermanentAddress);
            invalidEmail = excelReader.getStringData("Credentials", i, 1);
            textBoxPage.enterEmail(invalidEmail);
            scrollIntoView(textBoxPage.submitButton);
            textBoxPage.clickOnSubmitButton();
            Assert.assertTrue(textBoxPage.emailFieldError.isDisplayed());
        }

    }
}
