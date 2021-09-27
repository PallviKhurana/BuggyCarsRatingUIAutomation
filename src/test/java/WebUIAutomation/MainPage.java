package WebUIAutomation;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindAll;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

import java.util.List;

public class MainPage extends  Base {

    @FindBy(how = How.CSS,using = "div input[name=login]")
    WebElement login;

    @FindBy(how = How.CSS,using = "div input[name=password]")
    WebElement password;

    @FindBy(how = How.CSS,using = "button[class*=success]")
    WebElement loginBtn;

    @FindBy(how = How.CSS,using = "li span[class*=nav-link]")
    WebElement navProfileName;

    @FindBy(how = How.CSS,using = "form[class=form-inline] a[class*=btn-success-outline]")
    WebElement registerBtn;

    @FindAll(@FindBy(how = How.XPATH,using = "//div[@class='card']/h2"))
    List<WebElement> cards;

    public MainPage(WebDriver driver) {
        super(driver);
    }

    public void Login(String userName, String pwd)
    {
        login.sendKeys(userName);
        password.sendKeys(pwd);
        loginBtn.click();
    }

     public boolean IsUserLoggedIn(String profileFirstName)
    {
        return navProfileName.getText().contains(profileFirstName);
    }

    public void ClickRegisterBtn()
    {
        registerBtn.click();
    }

    public void ClickCard(String cardHeader)
    {
        for (WebElement element : cards)
        {
            if(element.getText().equals(cardHeader))
            {
                element.findElement(By.xpath("../a/img")).click();
                break;
            }
        }

    }
}
