package pages;

import org.openqa.selenium.WebDriver;

public class BasePage {
    static WebDriver driver;

    public BasePage(WebDriver driver){
        this.driver = driver;
    }

    public void closeBrowser(){
        //driver.close();
        driver.quit();
    }

    public void launchURL(String url){
        driver.get(url);
    }

    public void cleanUpSession(){
        driver.manage().deleteAllCookies();
    }

}
