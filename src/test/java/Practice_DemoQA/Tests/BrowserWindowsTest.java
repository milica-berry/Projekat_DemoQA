package Practice_DemoQA.Tests;

import Practice_DemoQA.Base.BaseTest;

import Practice_DemoQA.Pages.AlertsFrameAndWindows.BrowserWindowsPage;
import Practice_DemoQA.Pages.Elements.HomepagePage;
import Practice_DemoQA.Pages.Elements.SidebarPage;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;



public class BrowserWindowsTest extends BaseTest {

    public HomepagePage homepagePage;
    public SidebarPage sidebarPage;
    public BrowserWindowsPage browserWindowsPage;


    String demoqaSamlpeURL;
    String sampleHeadingMessage;


    @BeforeMethod
    public void pageSetUp(){
        demoqaSamlpeURL = excelReader.getStringData("URLs", 1, 12);
        sampleHeadingMessage = excelReader.getStringData("Messages", 1, 2);
        homepagePage = new HomepagePage();
        sidebarPage = new SidebarPage();
        browserWindowsPage = new BrowserWindowsPage();
    }


    @Test
    public void userCanOpenTab(){
        driver.get(homeURL);
        driver.manage().window().maximize();
        homepagePage.clickElementByName("Alerts, Frame & Windows");

        Assert.assertEquals(driver.getCurrentUrl(), alertsFrameAndWindowsURL);
        sidebarPage.clickElementByName("Browser Windows");

        browserWindowsPage.clickOnNewTabButton();
        Assert.assertTrue(newWindowOrTabIsEqual(demoqaSamlpeURL));
        Assert.assertTrue(browserWindowsPage.sampleHeading.isDisplayed());
        Assert.assertEquals(browserWindowsPage.sampleHeading.getText(), sampleHeadingMessage);
        closeNewWindowOrTab();


    }

    @Test
    public void userCanOpenWindow(){
        driver.get(homeURL);
        driver.manage().window().maximize();
        homepagePage.clickElementByName("Alerts, Frame & Windows");

        Assert.assertEquals(driver.getCurrentUrl(), alertsFrameAndWindowsURL);
        sidebarPage.clickElementByName("Browser Windows");

        browserWindowsPage.clickOnNewWindowButton();
        Assert.assertTrue(newWindowOrTabIsEqual(demoqaSamlpeURL));
        Assert.assertTrue(browserWindowsPage.sampleHeading.isDisplayed());
        Assert.assertEquals(browserWindowsPage.sampleHeading.getText(), sampleHeadingMessage);
        closeNewWindowOrTab();


    }


    @Test
    public void userCanOpenMessageWindow(){
        driver.get(homeURL);
        driver.manage().window().maximize();
        homepagePage.clickElementByName("Alerts, Frame & Windows");

        Assert.assertEquals(driver.getCurrentUrl(), alertsFrameAndWindowsURL);
        sidebarPage.clickElementByName("Browser Windows");
        browserWindowsPage.clickOnMessageWindowButton();

        //String message = excelReader.getStringData("Messages", 1, 1);

       // List<String> browserTabs = new ArrayList<String>(driver.getWindowHandles());
        //driver.switchTo().window(browserTabs.get(1));
        //System.out.println(browserWindowsPage.messageFromWindow());

        //System.out.println(driver.switchTo().window(browserTabs.get(1)));
        //System.out.println(browserWindowsPage.windowMessage.getText());
        //Assert.assertTrue(browserWindowsPage.windowMessage.isDisplayed());
        //Assert.assertEquals(browserWindowsPage.message.getText(),message );

        /*Set<String> winHandles = driver.getWindowHandles();
        Iterator<String> itr = winHandles.iterator();

        String currentWin = itr.next();
        String newBrowserWin = null;
        if (itr.hasNext())
            newBrowserWin = itr.next();

        String newBrowserWinText;
        if (newBrowserWin!=null) {
            driver.switchTo().window(newBrowserWin);

            System.out.println(driver.findElement(By.tagName("body")).getText());
            //newBrowserWinText = driver.findElement(By.tagName("body")).getText();
        }*/


    }


}
