package Practice_DemoQA.Pages.Elements;

import Practice_DemoQA.Base.BaseTest;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;


public class TextBoxPage extends BaseTest {

    public TextBoxPage(){
        PageFactory.initElements(driver, this);
    }

    @FindBy(id = "userName")
    public WebElement fullNameField;

    @FindBy(id = "userEmail")
    public WebElement emailField;

    @FindBy(id = "currentAddress")
    public WebElement currentAddressField;

    @FindBy(id = "permanentAddress")
    public WebElement permanentAddressField;

    @FindBy(id = "submit")
    public WebElement submitButton;

    @FindBy(id = "output")
    public WebElement outputMessage;

    @FindBy(css = ".mr-sm-2.field-error.form-control")
    public WebElement emailFieldError;

    @FindBy(className = "main-header")
    public WebElement header;

    public void enterFullName(String fullName){
        fullNameField.clear();
        fullNameField.sendKeys(fullName);
    }

    public void enterEmail(String email){
        emailField.clear();
        emailField.sendKeys(email);
    }

    public void enterCurrentAddress(String address){
        currentAddressField.clear();
        currentAddressField.sendKeys(address);
    }

    public void enterPermanentAddress(String address){
        permanentAddressField.clear();
        permanentAddressField.sendKeys(address);
    }

    public void clickOnSubmitButton(){
        submitButton.click();
    }






}
