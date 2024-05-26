package testcases;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.*;
import pages.AdminPage;
import pages.BasePage;
import pages.DashboardPage;
import pages.LoginPage;
import setup.BrowserFactory;
import utils.Wrapper;

public class DashboardTest {

    WebDriver driver;
    BasePage basePage;
    LoginPage loginPage;
    DashboardPage dashboardPage;

    @BeforeClass(alwaysRun = true)
    public void tearUp(){
        driver = BrowserFactory.launchBrowser("chrome");
        basePage = new BasePage(driver);
        loginPage = new LoginPage(driver);
        dashboardPage= new DashboardPage(driver);

    }

    @BeforeMethod(alwaysRun = true)
    public void launchApplication(){
        Wrapper.waitForLoading(3);
        basePage.launchURL("https://opensource-demo.orangehrmlive.com/");
        loginPage.checkIfLoginTestDisplay();
        loginPage.enterUserName("admin");
        loginPage.enterPassword("admin123");
        loginPage.clickOnLoginButton();
        Wrapper.waitForLoading(2);
    }

    @Test(priority = 1)
    public void verifyAdminPageIsOpeningCorrectly(){
        dashboardPage.clickOnGivenMenuOnHomePage("Admin");
        Assert.assertTrue(dashboardPage.verifyIfGivenMenuPageHasOpen("Admin"));
    }

    @Test(priority = 2)
    public void verifyPIMPageIsOpeningCorrectly(){
        dashboardPage.clickOnGivenMenuOnHomePage("PIM");
        Assert.assertTrue(dashboardPage.verifyIfGivenMenuPageHasOpen("PIM"));
    }

    @Test(priority = 3)
    public void verifyLeavePageIsOpeningCorrectly(){
        dashboardPage.clickOnGivenMenuOnHomePage("Leave");
        Assert.assertTrue(dashboardPage.verifyIfGivenMenuPageHasOpen("Leave"));
    }

    @Test(priority = 4)
    public void verifyTimePageIsOpeningCorrectly(){
        dashboardPage.clickOnGivenMenuOnHomePage("Time");
        Assert.assertTrue(dashboardPage.verifyIfGivenMenuPageHasOpen("Time"));
    }

    @Test(priority = 5)
    public void verifyRecruitmentPageIsOpeningCorrectly(){
        dashboardPage.clickOnGivenMenuOnHomePage("Recruitment");
        Assert.assertTrue(dashboardPage.verifyIfGivenMenuPageHasOpen("Recruitment"));
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
