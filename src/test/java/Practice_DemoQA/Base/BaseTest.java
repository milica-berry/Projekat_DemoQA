package Practice_DemoQA.Base;

import Practice_DemoQA.Pages.*;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.time.Duration;
import java.util.ArrayList;
import java.util.List;

public class BaseTest {

    //SREDJUJ!!

    public static WebDriver driver;
    public WebDriverWait wait;
    public ExcelReader excelReader;
    public String homeURL;
    public String elementsURL;
    public String textBoxURL;
    public String checkBoxURL;
    public String radioButtonURL;
    public String buttonsURL;
    public String linksURL;
    public String webTablesURL;
    public String brokenLinksImagesURL;
    public String uploadAndDownloadURL;
    public String dynamicPropertiesURL;
    public String alertsFrameAndWindowsURL;
    public String alertsURL;



    @BeforeClass
    public void setUp() throws IOException {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        excelReader = new ExcelReader("src/test/java/Practice_DemoQA/TestDataDemoQA.xlsx");

        homeURL = excelReader.getStringData("URLs", 1, 0);
        elementsURL = excelReader.getStringData("URLs", 1, 1);
        alertsFrameAndWindowsURL = excelReader.getStringData("URLs", 1, 11);

        textBoxURL = excelReader.getStringData("URLs", 1, 2);
        checkBoxURL = excelReader.getStringData("URLs", 1, 3);
        radioButtonURL = excelReader.getStringData("URLs", 1, 4);
        buttonsURL = excelReader.getStringData("URLs", 1, 5);
        linksURL = excelReader.getStringData("URLs", 1, 6);
        webTablesURL = excelReader.getStringData("URLs", 1, 7);
        uploadAndDownloadURL = excelReader.getStringData("URLs", 1, 8);
        brokenLinksImagesURL = excelReader.getStringData("URLs", 1, 9);
        dynamicPropertiesURL = excelReader.getStringData("URLs", 1, 10);
        alertsURL = excelReader.getStringData("URLs", 1, 13);
    }

    public void scrollIntoView(WebElement element) {
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("arguments[0].scrollIntoView(true);", element);
    }

    public void waitForURL(String URL) {
        wait.until(ExpectedConditions.urlToBe(URL));
    }

    public void waitForVisibility(WebElement element) {
        wait.until(ExpectedConditions.visibilityOf(element));
    }

    public void waitForClickability(WebElement element) {
        wait.until(ExpectedConditions.elementToBeClickable(element));
    }

    public boolean elementIsPresent(WebElement element) {
        boolean nonexistingElement = false;
        try {
            nonexistingElement = element.isDisplayed();
        } catch (Exception e) {
        }
        return nonexistingElement;
    }

    public void openNewTab() {
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("window.open()");
    }

    public void saveImage(WebElement element) throws IOException {
        wait.until(ExpectedConditions.attributeContains(element, "src", "imgflip.com"));
        String link = element.getAttribute("src");
        URL imageURL = new URL(link);
        BufferedImage saveImage = ImageIO.read(imageURL);
        String location = "C:\\Users\\drago\\Desktop\\";
        ImageIO.write(saveImage, "png", new File(location + System.currentTimeMillis() + ".png"));
    }

    public String getTextFromElement(WebElement element){
        return element.getText();
    }



    public boolean newWindowOrTabIsEqual(String url){
        List<String> browserTabs = new ArrayList<String>(driver.getWindowHandles());
        driver.switchTo().window(browserTabs.get(1));

        boolean b;
        if(driver.getCurrentUrl().equals(url)){
            b = true;
        } else {
            b = false;
        }

        return b;
    }

    public void closeNewWindowOrTab(){
        List<String> browserTabs = new ArrayList<String>(driver.getWindowHandles());

        driver.switchTo().window(browserTabs.get(1));
        driver.close();
        driver.switchTo().window(browserTabs.get(0));
    }

    @AfterClass
    public void tearDown() {
        driver.manage().deleteAllCookies();
        driver.quit();
    }






}
