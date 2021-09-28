package WebUIAutomation;

import org.junit.*;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.util.UUID;
import java.util.concurrent.TimeUnit;

public class Tests  {

    private static WebDriver driver = null;

       @BeforeClass
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
            Assert.assertTrue(mainPage.IsUserLoggedIn("Pallvi"));
            mainPage.ClickLogout();
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
            driver.get("https://buggy.justtestit.org/");
            MainPage mainPage = new MainPage(driver);
            mainPage.ClickCard("Popular Make");

            // Go to the Make Card
            MakePage makePage = new MakePage(driver);
            Assert.assertEquals("Lamborghini",makePage.GetCardHeader());

            // Goto Model Page
            makePage.GoToModel("Diablo");
            ModelPage modelPage = new ModelPage(driver);
            Assert.assertEquals("Diablo",modelPage.GetModelHeader());
        }

    @Test
    public void VerifyUserCanAddCommentToAModelAndCountIncreaseOnModelPageAndMainTable() throws InterruptedException {
        driver.get("https://buggy.justtestit.org/");
        MainPage mainPage = new MainPage(driver);

        // Register new user each time
        mainPage.ClickRegisterBtn();
        RegistrationPage registrationPage = new RegistrationPage(driver);
        String newUserName = registrationPage.NewUserRegistration(GenerateRandomString());
        mainPage.Login(newUserName,"Random1$");
        Thread.sleep(500);

        mainPage.ClickBuggyRatingBrandLogo();


        mainPage.ClickCard("Popular Make");

        // Go to the Make Card
        MakePage makePage = new MakePage(driver);
        Integer getCurrentVoteCountBeforeAddingCommentOnMakeTable = makePage.GetModelCurrentVotes("Murciélago");

        makePage.GoToModel("Murciélago");
        ModelPage modelPage = new ModelPage(driver);
        Integer getCurrentVoteCountBeforeAddingCommentOnModelPage = modelPage.GetLatestCount();

        modelPage.AddComment("This is expensive!!");

        Thread.sleep(1000);

        Integer getCurrentVoteCountAfterAddingNewCommentOnModelPage = modelPage.GetLatestCount();
        Assert.assertTrue(getCurrentVoteCountAfterAddingNewCommentOnModelPage > getCurrentVoteCountBeforeAddingCommentOnModelPage);
        driver.navigate().back();
        Assert.assertTrue(getCurrentVoteCountAfterAddingNewCommentOnModelPage > getCurrentVoteCountBeforeAddingCommentOnMakeTable);
        mainPage.ClickLogout();
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
