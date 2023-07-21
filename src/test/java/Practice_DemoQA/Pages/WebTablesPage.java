package Practice_DemoQA.Pages;

import Practice_DemoQA.Base.BaseTest;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;
import java.util.List;

public class WebTablesPage extends BaseTest {


    public WebTablesPage(){
        PageFactory.initElements(driver, this);
    }

    @FindBy(className = "main-header")
    public WebElement webTablesHeader;

    @FindBy(id = "searchBox")
    public WebElement searchBox;



    @FindBy(className = "rt-td")
    public List<WebElement> cells;

    @FindBy(className = "rt-tr-group")
    public List<WebElement> rows;

    @FindBy(id = "addNewRecordButton")
    public WebElement addNewRecordButton;

    @FindBy(xpath = "//*[starts-with(@id, 'edit-record-')]")
    public List<WebElement> editButtons;


    @FindBy(xpath = "//*[starts-with(@id, 'delete-record-')]")
    public List<WebElement> deleteButtons;


    @FindBy(id = "firstName")
    public WebElement firstNameField;

    @FindBy(id = "lastName")
    public WebElement lastNameField;

    @FindBy(id = "userEmail")
    public WebElement emailField;

    @FindBy(id = "age")
    public WebElement ageField;

    @FindBy(id = "salary")
    public WebElement salaryField;

    @FindBy(id = "department")
    public WebElement departmentField;


    @FindBy(id = "submit")
    public WebElement submitButton;

    @FindBy(xpath = "/html/body/div[2]/div/div/div[2]/div[2]/div[2]/div[3]/div[2]/div/div[2]/span[2]/select")
    public WebElement rowsNumber;


    @FindBy(id = "registration-form-modal")
    public WebElement editModalHeader;



    public void enterInSearchBox(String input){
        searchBox.clear();
        searchBox.sendKeys(input);
    }

    public boolean elementIsPresentInTheTable(String text){
        boolean b = false;
        for (int i = 0; i < cells.size(); i++) {
            searchBox.clear();
            if(cells.get(i).getText().contains(text)){
                b = true;
            }
        }
        return b;
    }



    public boolean numberOfRowsEquals(int number){
        boolean b = false;
        if(rows.size() == number){
            b = true;
        }
        return b;
    }

    public void clickOnEditButton(int numberOfButton){
        editButtons.get(numberOfButton).click();
    }

    public void clickOnAddButton(){
        addNewRecordButton.click();
    }

    public boolean valueOfField(WebElement field, String value){
        boolean b = field.getAttribute("value").contentEquals(value);
        return b;
    }

    public void enterNewData(WebElement field, String updatedData){
        field.clear();
        field.sendKeys(updatedData);
    }

    public void clickOnSubmitButton(){
        submitButton.click();
    }



    public void deleteAllUsers(){
        for (int i = 0; i < deleteButtons.size(); i++) {
            deleteButtons.get(i).click();
        }
        deleteButtons.get(0).click();
    }

    public void selectNumberOfRows(String number){
        Select select = new Select(rowsNumber);
        select.selectByValue(number);
    }

    public String rowText(int brojReda){
        return rows.get(brojReda).getText();
    }

    public String cellText(int brojCelije){
        return cells.get(brojCelije).getText();
    }















}
