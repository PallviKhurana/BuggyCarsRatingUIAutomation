package WebUIAutomation;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.List;
import java.util.UUID;
import java.util.concurrent.TimeUnit;


public class BasePage {

    public static void main(String[] args) throws InterruptedException {
        final String FirstName = "Pallvi";


        System.setProperty("webdriver.chrome.driver", "src\\main\\resources\\chromedriver.exe");
        WebDriver driver = new ChromeDriver();

        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.get("https://buggy.justtestit.org/");

        ClickCard(driver,"Popular Make");
        WebElement CardText = driver.findElement(By.cssSelector("div[class=card] h3"));

        Assert.assertEquals("Lamborghini",CardText.getText());

        List<WebElement> Models = driver.findElements(By.cssSelector("table tr td a"));

        for (WebElement element : Models)
        {
            if(element.getText().equals("Diablo"))
            {
                element.click();
            }
        }
       // NewUserRegistration(driver);


      //  Login(driver,randomString,"Random1$");
      //  Assert.assertEquals(true,IsUserLoggedIn(driver,"First " + randomString));
       // driver.close();
    }

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

    private static String GenerateRandomString()
    {
        return UUID.randomUUID().toString().replaceAll("-", "");
    }

    public static void NewUserRegistration(WebDriver driver)
    {
        final String RegisterSuccessMsg = "Registration is successful";
        // Register New User
        WebElement RegisterBtn = driver.findElement(By.cssSelector("form[class=form-inline] a[class*=btn-success-outline]"));
        RegisterBtn.click();

        var randomString = GenerateRandomString();

        WebElement login = driver.findElement(By.cssSelector("input[id=username]"));
        WebElement firstName = driver.findElement(By.cssSelector("input[id=firstName]"));
        WebElement lastName = driver.findElement(By.cssSelector("input[id=lastName]"));
        WebElement password = driver.findElement(By.cssSelector("input[id=password]"));
        WebElement confirmPassword = driver.findElement(By.cssSelector("input[id=confirmPassword]"));
        // Register btn on Register Page
        WebElement registerButton = driver.findElement(By.cssSelector("form button[class*=btn-default]"));

        login.sendKeys(randomString);
        firstName.sendKeys("First " + randomString);
        lastName.sendKeys("Last");
        password.sendKeys("Random1$");
        confirmPassword.sendKeys("Random1$");
        registerButton.click();

        WebElement registerSuccessMsg = driver.findElement(By.cssSelector("form div[class*=alert-success]"));
        String actualSuccessMsg = registerSuccessMsg.getText();
        Assert.assertEquals(RegisterSuccessMsg,actualSuccessMsg);
        System.out.println("New User registered with username: "+ randomString );
    }

    private static void ClickCard(WebDriver driver,String cardHeader)
    {
        List<WebElement> Cards = driver.findElements(By.xpath("//div[@class='card']/h2"));
        for (WebElement element : Cards)
        {
            if(element.getText().equals(cardHeader))
            {
                element.findElement(By.xpath("../a/img")).click();
            }
        }

    }
}
