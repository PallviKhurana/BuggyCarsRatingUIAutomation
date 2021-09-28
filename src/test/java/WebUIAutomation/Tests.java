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

            // Ideally values should be picked from env.config file
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

            // Click Card : Popular Make Card
            mainPage.ClickCard("Popular Make");

            // Verify User Land on make page of Lamborghini
            MakePage makePage = new MakePage(driver);
            Assert.assertEquals("Lamborghini",makePage.GetCardHeader());

            // Click model : Diablo
            makePage.GoToModel("Diablo");
            ModelPage modelPage = new ModelPage(driver);

            // Verify user is on Diablo model page
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



        mainPage.ClickBuggyRatingBrandLogo(driver);
        mainPage.ClickCard("Popular Make");

        // Go to the Make Card
        MakePage makePage = new MakePage(driver);
        Integer getCurrentVoteCountBeforeAddingCommentOnMakeTable = makePage.GetModelCurrentVotes("Murciélago");

        makePage.GoToModel("Murciélago");
        ModelPage modelPage = new ModelPage(driver);
        Integer getCurrentVoteCountBeforeAddingCommentOnModelPage = modelPage.GetLatestCount(driver);

        modelPage.AddComment("This is expensive!!");

        // Need to remove anti-pattern
        Thread.sleep(500);
        Assert.assertTrue(modelPage.IsVoteSuccessFull());

        Integer getCurrentVoteCountAfterAddingNewCommentOnModelPage = modelPage.GetLatestCount(driver);
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
