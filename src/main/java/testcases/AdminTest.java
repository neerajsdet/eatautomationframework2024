package testcases;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.*;
import pages.AdminPage;
import pages.BasePage;
import pages.LoginPage;
import setup.BrowserFactory;
import utils.Wrapper;

public class AdminTest {

    WebDriver driver;
    BasePage basePage;
    AdminPage adminPage;
    LoginPage loginPage;

    @BeforeClass(alwaysRun = true)
    public void tearUp(){
        driver = BrowserFactory.launchBrowser("chrome");
        basePage = new BasePage(driver);
        adminPage = new AdminPage(driver);
        loginPage = new LoginPage(driver);

    }

    @BeforeMethod(alwaysRun = true)
    public void launchApplication(){
        Wrapper.waitForLoading(3);
        basePage.launchURL("https://opensource-demo.orangehrmlive.com/");
    }

    @Test(priority = 1)
    public void verifyOrangeHRMLoginPageDisplayed(){
        Assert.assertTrue(loginPage.checkIfLoginTestDisplay());
    }

    @Test(priority = 2)
    public void verifyUserShouldNotBeAbleToLoginWithInvalidCred(){

    }

    @Test(priority = 3)
    public void verifyUserIsAbleToLoginIntoApplication(){


    }

    @AfterMethod
    public void cleanUp(){
        basePage.cleanUpSession();
    }

    @AfterClass
    public void tearDown(){
        basePage.closeBrowser();
    }


}
