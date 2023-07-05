package Practice_DemoQA.Tests;

import Practice_DemoQA.Base.BaseTest;
import Practice_DemoQA.Pages.AlertsFrameAndWindows.AlertsPage;
import Practice_DemoQA.Pages.Elements.HomepagePage;
import Practice_DemoQA.Pages.Elements.SidebarPage;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class AlertsTest extends BaseTest {

    public HomepagePage homepagePage;
    public SidebarPage sidebarPage;
    public AlertsPage alertsPage;



    @BeforeMethod
    public void pageSetUp(){
        homepagePage = new HomepagePage();
        alertsPage = new AlertsPage();
        sidebarPage = new SidebarPage();
    }


    @Test
    public void userCanOpenAndAcceptBasicAlert(){
        driver.get(homeURL);
        driver.manage().window().maximize();
        homepagePage.clickElementByName("Alerts, Frame & Windows");

        Assert.assertEquals(driver.getCurrentUrl(), alertsFrameAndWindowsURL);
        sidebarPage.clickElementByName("Alerts");
        Assert.assertEquals(driver.getCurrentUrl(), alertsURL);
        Assert.assertEquals(alertsPage.alertsMainHeader.getText(), "Alerts");

        String alertMessage = excelReader.getStringData("Messages", 1, 3);

        scrollIntoView(alertsPage.basicAlert);
        alertsPage.clickOnBasicAlert();
        Assert.assertTrue(alertsPage.isAlertPresent());
        Assert.assertEquals(driver.switchTo().alert().getText(), alertMessage);
        alertsPage.acceptAlert();

    }

    @Test
    public void userCanOpenAndAcceptWaitAlert(){
        driver.get(homeURL);
        driver.manage().window().maximize();
        homepagePage.clickElementByName("Alerts, Frame & Windows");

        Assert.assertEquals(driver.getCurrentUrl(), alertsFrameAndWindowsURL);
        sidebarPage.clickElementByName("Alerts");
        Assert.assertEquals(driver.getCurrentUrl(), alertsURL);
        Assert.assertEquals(alertsPage.alertsMainHeader.getText(), "Alerts");

        String alertMessage = excelReader.getStringData("Messages", 2, 3);

        scrollIntoView(alertsPage.waiterAlert);
        alertsPage.clickOnWaiterAlert();
        wait.until(ExpectedConditions.alertIsPresent());
        Assert.assertTrue(alertsPage.isAlertPresent());
        Assert.assertEquals(driver.switchTo().alert().getText(), alertMessage);
        alertsPage.acceptAlert();
    }


    @Test
    public void userCanConfirmOrDismissAlert(){
        driver.get(homeURL);
        driver.manage().window().maximize();
        homepagePage.clickElementByName("Alerts, Frame & Windows");

        Assert.assertEquals(driver.getCurrentUrl(), alertsFrameAndWindowsURL);
        sidebarPage.clickElementByName("Alerts");
        Assert.assertEquals(driver.getCurrentUrl(), alertsURL);
        Assert.assertEquals(alertsPage.alertsMainHeader.getText(), "Alerts");

        String alertMessage = excelReader.getStringData("Messages", 3, 3);

        scrollIntoView(alertsPage.confirmOrDismissAlert);
        alertsPage.clickOnConfirmOrDismissAlert();
        Assert.assertTrue(alertsPage.isAlertPresent());
        Assert.assertEquals(driver.switchTo().alert().getText(), alertMessage);
        alertsPage.acceptAlert();
        Assert.assertTrue(alertsPage.confirmResultMessage.isDisplayed());
        Assert.assertTrue(alertsPage.confirmResultMessage.getText().contains("Ok"));

        alertsPage.clickOnConfirmOrDismissAlert();
        Assert.assertTrue(alertsPage.isAlertPresent());
        Assert.assertEquals(driver.switchTo().alert().getText(), alertMessage);
        alertsPage.dismissAlert();
        Assert.assertTrue(alertsPage.confirmResultMessage.isDisplayed());
        Assert.assertTrue(alertsPage.confirmResultMessage.getText().contains("Cancel"));
    }


    @Test
    public void userCanEnterOrDismissPromptBoxAlert(){
        driver.get(homeURL);
        driver.manage().window().maximize();
        homepagePage.clickElementByName("Alerts, Frame & Windows");

        Assert.assertEquals(driver.getCurrentUrl(), alertsFrameAndWindowsURL);
        sidebarPage.clickElementByName("Alerts");
        Assert.assertEquals(driver.getCurrentUrl(), alertsURL);
        Assert.assertEquals(alertsPage.alertsMainHeader.getText(), "Alerts");

        String alertMessage = excelReader.getStringData("Messages", 4, 3);
        String inputName = "Ime";

        scrollIntoView(alertsPage.promptBoxAlert);
        alertsPage.clickOnPromptBoxAlert();
        Assert.assertTrue(alertsPage.isAlertPresent());
        Assert.assertEquals(driver.switchTo().alert().getText(), alertMessage);
        alertsPage.sendKeysToAlert(inputName);
        alertsPage.acceptAlert();
        Assert.assertTrue(alertsPage.promptResultMessage.isDisplayed());
        Assert.assertTrue(alertsPage.promptResultMessage.getText().contains(inputName));

        alertsPage.clickOnPromptBoxAlert();
        Assert.assertTrue(alertsPage.isAlertPresent());
        Assert.assertEquals(driver.switchTo().alert().getText(), alertMessage);
        alertsPage.dismissAlert();
        Assert.assertFalse(elementIsPresent(alertsPage.promptResultMessage));
    }





}
