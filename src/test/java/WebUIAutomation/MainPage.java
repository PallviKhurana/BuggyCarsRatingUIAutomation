package WebUIAutomation;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class MainPage {

    private static void Login(WebDriver driver, String userName, String pwd)
    {
        WebElement login = driver.findElement(By.cssSelector("div input[name=login]"));
        WebElement password = driver.findElement(By.cssSelector("div input[name=password]"));
        WebElement loginBtn = driver.findElement(By.cssSelector("button[class*=success]"));

        login.sendKeys(userName);
        password.sendKeys(pwd);
        loginBtn.click();
    }

    private static boolean IsUserLoggedIn(WebDriver driver,String profileFirstName)
    {
        WebElement navProfileName = driver.findElement(By.cssSelector("li span[class*=nav-link]"));
        return navProfileName.isDisplayed();
    }
}
