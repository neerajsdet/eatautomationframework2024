package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utils.Wrapper;

public class DashboardPage {
    WebDriver driver;
    public DashboardPage(WebDriver driver){
        this.driver=driver;
        PageFactory.initElements(driver, this);
    }

    @FindBy(xpath = "//a[contains(@class,'oxd-main-menu-item')]//span[text()='Admin']")
    WebElement adminMenuOnSidePanel;
    @FindBy(xpath = "//a[contains(@class,'oxd-main-menu-item')]//span[text()='PIM']")
    WebElement pimMenuOnSidePanel;
    @FindBy(xpath = "//a[contains(@class,'oxd-main-menu-item')]//span[text()='Time']")
    WebElement timeMenuOnSidePanel;
    @FindBy(xpath = "//a[contains(@class,'oxd-main-menu-item')]//span[text()='Leave']")
    WebElement leaveMenuOnSidePanel;
    @FindBy(xpath = "//a[contains(@class,'oxd-main-menu-item')]//span[text()='Recruitment']")
    WebElement recruitmentMenuOnSidePanel;
    @FindBy(xpath = "//h5[normalize-space()='System Users']")
    WebElement systemUsersOnAdminPage;
    @FindBy(xpath = "//h5[normalize-space()='Employee Information']")
    WebElement employeeInformationOnPIMPage;
   @FindBy(xpath = "///h5[normalize-space()='Leave List']")
    WebElement leaveListTextOnLeavePage;
   @FindBy(xpath = "//h6[normalize-space()='Select Employee']")
    WebElement selectEmployeeTextOnTimePage;
   @FindBy(xpath = "//h5[normalize-space()='Candidates']")
    WebElement candidateTextOnRecruitmentPage;

    public void clickOnGivenMenuOnHomePage(String menu){
        if (menu.equalsIgnoreCase("admin")){
            adminMenuOnSidePanel.click();
        }else if(menu.equalsIgnoreCase("pim")){
            pimMenuOnSidePanel.click();
        }else if (menu.equalsIgnoreCase("leave")){
            leaveMenuOnSidePanel.click();
        }else if (menu.equalsIgnoreCase("time")){
            timeMenuOnSidePanel.click();
        }else if (menu.equalsIgnoreCase("Recruitment")){
            recruitmentMenuOnSidePanel.click();
        }
    }

    public boolean verifyIfGivenMenuPageHasOpen(String menu){
       boolean flag=false;
        if (menu.equalsIgnoreCase("admin")){
            flag=systemUsersOnAdminPage.isDisplayed();
        }else if(menu.equalsIgnoreCase("pim")){
            flag=employeeInformationOnPIMPage.isDisplayed();
        }else if (menu.equalsIgnoreCase("leave")){
            flag=leaveListTextOnLeavePage.isDisplayed();
        }else if (menu.equalsIgnoreCase("time")){
            flag=selectEmployeeTextOnTimePage.isDisplayed();
        }else if (menu.equalsIgnoreCase("Recruitment")){
            flag=candidateTextOnRecruitmentPage.isDisplayed();
        }
        Wrapper.waitForLoading(2);
        return flag;
    }





}
