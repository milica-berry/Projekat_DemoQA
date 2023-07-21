package Practice_DemoQA.Pages;

import Practice_DemoQA.Base.BaseTest;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

import java.io.File;

public class UploadAndDownloadPage extends BaseTest {

    public UploadAndDownloadPage(){
        PageFactory.initElements(driver, this);
    }


    @FindBy(className = "main-header")
    public WebElement uploadAndDownloadHeader;


    @FindBy(id = "downloadButton")
    public WebElement downloadButton;

    @FindBy(xpath = "//*[@id='uploadFile']")
    public WebElement uploadButton;

    @FindBy(id = "uploadedFilePath")
    public WebElement uploadedMessage;

    public void clickOnDownloadButton(){
        downloadButton.click();

    }

    public void uploadImage(){
        String imgLocation = "C:\\Users\\HP\\Desktop\\484171235.jpg";
        uploadButton.sendKeys(imgLocation);

    }





}
