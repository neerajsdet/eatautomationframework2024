package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage {
    WebDriver driver;
    public LoginPage(WebDriver driver){
        this.driver=driver;
        PageFactory.initElements(driver, this);
    }

    @FindBy(xpath = "//h5[normalize-space()='Login']")
    WebElement loginTextOnLoginPage;
    @FindBy(xpath = "//input[@placeholder='Username']")
    WebElement userNameTextBox;
    @FindBy(xpath = "//input[@placeholder='Password']")
    WebElement passwordTextBox;
    @FindBy(xpath = "//button[normalize-space()='Login']")
    WebElement loginButton;
    @FindBy(xpath = "//img[@class='oxd-userdropdown-img']")
    WebElement userLoginIcon;
    @FindBy(xpath = "//p[@class='oxd-text oxd-text--p oxd-alert-content-text']")
    WebElement invalidCredentialErrorMessage;


    public void enterUserName(String userName){
        userNameTextBox.sendKeys(userName);
    }

    public void enterPassword(String password){
        passwordTextBox.sendKeys(password);
    }

    public void clickOnLoginButton(){
        loginButton.click();
    }

    public boolean checkIfLoginTestDisplay(){
        return loginTextOnLoginPage.isDisplayed();
    }

    public boolean checkIfUserIconDisplay(){
        return userLoginIcon.isDisplayed();
    }
    public boolean checkIfInvalidCredentialErrorDisplay(){
        return invalidCredentialErrorMessage.isDisplayed();
    }


}
