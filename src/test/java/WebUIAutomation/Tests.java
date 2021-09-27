package WebUIAutomation;

import org.junit.*;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.Test;

import java.util.UUID;
import java.util.concurrent.TimeUnit;

public class Tests  {

    private static WebDriver driver = null;

       @org.testng.annotations.BeforeClass
        public static void Initialize()
        {
            System.setProperty("webdriver.chrome.driver", "src\\main\\resources\\chromedriver.exe");
            driver = new ChromeDriver();
            driver.manage().window().maximize();
            driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
            driver.get("https://buggy.justtestit.org/");
        }

        @Test
        public void VerifyUserCanLogin()
        {
            MainPage mainPage = new MainPage(driver);
            mainPage.Login("PallviKhurana","pALLVI84$");
            Assert.assertEquals(true,mainPage.IsUserLoggedIn("Pallvi"));
        }

        @Test
        public void VerifyNewUserCanBeRegistered() {
            MainPage mainPage = new MainPage(driver);
            mainPage.ClickRegisterBtn();
            RegistrationPage registrationPage = new RegistrationPage(driver);
            registrationPage.NewUserRegistration(GenerateRandomString());
        }

        @Test
        public void VerifyUserCanRouteToMakeAndSelectedModel()
        {
            MainPage mainPage = new MainPage(driver);
            mainPage.ClickCard("Popular Make");

            MakePage makePage = new MakePage(driver);
            Assert.assertEquals("Lamborghini",makePage.GetCardHeader());

            makePage.GoToModel("Diablo");

            ModelPage modelPage = new ModelPage(driver);
            Assert.assertEquals("Diablo",modelPage.GetModelHeader());
        }


    private static String GenerateRandomString()
    {
        return UUID.randomUUID().toString().replaceAll("-", "");
    }
        @AfterTest
         public static void CloseBrowser(){
           driver.close();
        }
    }
