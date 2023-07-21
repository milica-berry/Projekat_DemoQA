package Practice_DemoQA.Tests;

import Practice_DemoQA.Base.BaseTest;
import Practice_DemoQA.Pages.HomepagePage;
import Practice_DemoQA.Pages.SidebarPage;
import Practice_DemoQA.Pages.WebTablesPage;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class WebTablesTest extends BaseTest {

    public HomepagePage homepagePage;
    public SidebarPage sidebarPage;
    public WebTablesPage webTablesPage;

    String updateName;
    String updateLastName;
    String updateSalary;
    String updateEmail;
    String updateAge;
    String updateDepartment;





    @BeforeMethod
    public void pageSetUp() {

        updateName = excelReader.getStringData("Update Table Data", 1, 0);
        updateLastName = excelReader.getStringData("Update Table Data", 1, 1);
        updateAge = excelReader.getStringData("Update Table Data", 1, 2);
        updateEmail = excelReader.getStringData("Update Table Data", 1, 3);
        updateSalary = excelReader.getStringData("Update Table Data", 1, 4);
        updateDepartment = excelReader.getStringData("Update Table Data", 1, 5);

        homepagePage = new HomepagePage();
        sidebarPage = new SidebarPage();
        webTablesPage = new WebTablesPage();


    }

    @Test
    public void userCanSearchEntries() {
        userCanAddNewRecords();

        String search = "Sanaa";

        webTablesPage.enterInSearchBox(search);
        Assert.assertTrue(webTablesPage.elementIsPresentInTheTable(search));
        Assert.assertFalse(webTablesPage.elementIsPresentInTheTable(excelReader.getStringData("New Data", 2, 0)));
        Assert.assertFalse(webTablesPage.elementIsPresentInTheTable(excelReader.getStringData("New Data", 3, 0)));
    }

    @Test
    public void userCanOpenUpdateModule(){
        driver.get(homeURL);
        driver.manage().window().maximize();
        homepagePage.clickElementByName("Elements");

        Assert.assertEquals(driver.getCurrentUrl(), elementsURL);
        sidebarPage.clickElementByName("Web Tables");
        Assert.assertEquals(driver.getCurrentUrl(), webTablesURL);
        Assert.assertEquals(getTextFromElement(webTablesPage.webTablesHeader), "Web Tables");

        webTablesPage.clickOnEditButton(0);
        Assert.assertTrue(webTablesPage.editModalHeader.isDisplayed());
        Assert.assertTrue(webTablesPage.firstNameField.isDisplayed());
        Assert.assertTrue(webTablesPage.lastNameField.isDisplayed());
        Assert.assertTrue(webTablesPage.ageField.isDisplayed());
        Assert.assertTrue(webTablesPage.emailField.isDisplayed());
        Assert.assertTrue(webTablesPage.salaryField.isDisplayed());
        Assert.assertTrue(webTablesPage.departmentField.isDisplayed());
    }

    @Test
    public void userCanDeleteAllRecords(){
        driver.get(homeURL);
        driver.manage().window().maximize();
        homepagePage.clickElementByName("Elements");

        Assert.assertEquals(driver.getCurrentUrl(), elementsURL);
        sidebarPage.clickElementByName("Web Tables");
        Assert.assertEquals(driver.getCurrentUrl(), webTablesURL);
        Assert.assertEquals(getTextFromElement(webTablesPage.webTablesHeader), "Web Tables");

        webTablesPage.deleteAllUsers();
        Assert.assertTrue(webTablesPage.rows.get(0).getText().isBlank());

    }


    @Test
    public void userCanAddNewRecords(){
        driver.get(homeURL);
        driver.manage().window().maximize();
        homepagePage.clickElementByName("Elements");

        Assert.assertEquals(driver.getCurrentUrl(), elementsURL);
        sidebarPage.clickElementByName("Web Tables");
        Assert.assertEquals(driver.getCurrentUrl(), webTablesURL);
        Assert.assertEquals(getTextFromElement(webTablesPage.webTablesHeader), "Web Tables");

        webTablesPage.deleteAllUsers();

        int j = 0;
        for (int i = 1; i <= excelReader.getLastRow("New Data"); i++) {
            String myDataName = excelReader.getStringData("New Data", i, 0);
            String myDataLastName = excelReader.getStringData("New Data", i, 1);
            String myDataAge =  excelReader.getStringData("New Data", i, 3);
            String myDataEmail = excelReader.getStringData("New Data", i, 2);
            String myDataSalary = excelReader.getStringData("New Data", i, 4);
            String myDataDepartment = excelReader.getStringData("New Data", i, 5);



            scrollIntoView(webTablesPage.addNewRecordButton);
            webTablesPage.clickOnAddButton();

            webTablesPage.enterNewData(webTablesPage.firstNameField, myDataName);
            webTablesPage.enterNewData(webTablesPage.lastNameField, myDataLastName);
            webTablesPage.enterNewData(webTablesPage.ageField, myDataAge);
            webTablesPage.enterNewData(webTablesPage.emailField, myDataEmail);

            webTablesPage.enterNewData(webTablesPage.salaryField, myDataSalary);
            webTablesPage.enterNewData(webTablesPage.departmentField, myDataDepartment);
            webTablesPage.clickOnSubmitButton();



            Assert.assertEquals(myDataName, webTablesPage.cellText(j));
            Assert.assertEquals(myDataLastName, webTablesPage.cellText(j+1));
            Assert.assertEquals(myDataAge, webTablesPage.cellText(j+2));
            Assert.assertEquals(myDataEmail, webTablesPage.cellText(j+3));
            Assert.assertEquals(myDataSalary, webTablesPage.cellText(j+4));
            Assert.assertEquals(myDataDepartment, webTablesPage.cellText(j+5));

            j = j + 7;


        }

    }


    @Test
    public void userCanUpdateDataInTable(){
        userCanAddNewRecords();
        webTablesPage.clickOnEditButton(0);


        webTablesPage.enterNewData(webTablesPage.firstNameField, updateName);
        Assert.assertTrue(webTablesPage.valueOfField(webTablesPage.firstNameField, updateName));
        webTablesPage.enterNewData(webTablesPage.lastNameField, updateLastName);
        Assert.assertTrue(webTablesPage.valueOfField(webTablesPage.lastNameField, updateLastName));
        webTablesPage.enterNewData(webTablesPage.emailField, updateEmail);
        Assert.assertTrue(webTablesPage.valueOfField(webTablesPage.emailField, updateEmail));
        webTablesPage.enterNewData(webTablesPage.ageField, updateAge);
        Assert.assertTrue(webTablesPage.valueOfField(webTablesPage.ageField, updateAge));
        webTablesPage.enterNewData(webTablesPage.salaryField, updateSalary);
        Assert.assertTrue(webTablesPage.valueOfField(webTablesPage.salaryField, updateSalary));
        webTablesPage.enterNewData(webTablesPage.departmentField, updateDepartment);
        Assert.assertTrue(webTablesPage.valueOfField(webTablesPage.departmentField, updateDepartment));
        webTablesPage.clickOnSubmitButton();

        webTablesPage.enterInSearchBox(updateName);
        Assert.assertTrue(webTablesPage.rows.get(0).getText().contains(updateName));
        Assert.assertTrue(webTablesPage.rows.get(0).getText().contains(updateLastName));
        Assert.assertTrue(webTablesPage.rows.get(0).getText().contains(updateAge));
        Assert.assertTrue(webTablesPage.rows.get(0).getText().contains(updateEmail));
        Assert.assertTrue(webTablesPage.rows.get(0).getText().contains(updateSalary));
        Assert.assertTrue(webTablesPage.rows.get(0).getText().contains(updateDepartment));
    }


    @Test //Koriscen xpath
    public void userCanChangeNumberOfVisibleRows(){
        driver.get(homeURL);
        driver.manage().window().maximize();
        homepagePage.clickElementByName("Elements");

        Assert.assertEquals(driver.getCurrentUrl(), elementsURL);
        sidebarPage.clickElementByName("Web Tables");
        Assert.assertEquals(driver.getCurrentUrl(), webTablesURL);
        Assert.assertEquals(getTextFromElement(webTablesPage.webTablesHeader), "Web Tables");

        webTablesPage.selectNumberOfRows("5");
        Assert.assertTrue(webTablesPage.numberOfRowsEquals(5));
        webTablesPage.selectNumberOfRows("10");
        Assert.assertTrue(webTablesPage.numberOfRowsEquals(10));
        webTablesPage.selectNumberOfRows("20");
        Assert.assertTrue(webTablesPage.numberOfRowsEquals(20));
        webTablesPage.selectNumberOfRows("25");
        Assert.assertTrue(webTablesPage.numberOfRowsEquals(25));
        webTablesPage.selectNumberOfRows("50");
        Assert.assertTrue(webTablesPage.numberOfRowsEquals(50));
        webTablesPage.selectNumberOfRows("100");
        Assert.assertTrue(webTablesPage.numberOfRowsEquals(100));


    }
}
