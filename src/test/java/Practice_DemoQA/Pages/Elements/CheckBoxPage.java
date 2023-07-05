package Practice_DemoQA.Pages.Elements;

import Practice_DemoQA.Base.BaseTest;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

import java.util.List;

public class CheckBoxPage extends BaseTest {

    public CheckBoxPage(){
        PageFactory.initElements(driver, this);
    }

    @FindBy(className = "main-header")
    public WebElement checkBoxHeader;

    @FindBy(css = ".rct-icon.rct-icon-expand-all")
    public WebElement expandAllButton;


    @FindBy(css = ".rct-icon.rct-icon-collapse-all")
    public WebElement collapseAllButton;

    @FindBy(className = ".rct-node.rct-node-parent.rct-node-collapsed")
    public WebElement collapsedNode;

    @FindBy(className = ".rct-node.rct-node-parent.rct-node-expanded")
    public WebElement expandedNode;

    @FindBy(className = "rct-checkbox")
    public WebElement homeCheckBox;

    @FindBy(id = "result")
    public WebElement result;

    @FindBy(css = ".rct-collapse.rct-collapse-btn")
    public List<WebElement> collapseAndExpandArrows;

    @FindBy(className = "rct-checkbox")
    public List<WebElement> checkBoxes;




    public void extendAll(){
        expandAllButton.click();
    }

    public void collapseAll(){
        collapseAllButton.click();
    }

    public void clickOnHomeCheckBox(){
        homeCheckBox.click();
    }








}
