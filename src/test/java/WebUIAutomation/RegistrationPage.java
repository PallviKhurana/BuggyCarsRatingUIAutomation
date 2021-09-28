package WebUIAutomation;

import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

public class RegistrationPage extends Base{

    final String RegisterSuccessMsg = "Registration is successful";

    public RegistrationPage(WebDriver driver) {
        super(driver);
    }

    @FindBy(how = How.CSS,using = "input[id=username]")
    WebElement user;

    @FindBy(how = How.CSS,using = "input[id=firstName]")
    WebElement firstName;

    @FindBy(how = How.CSS,using = "input[id=lastName]")
    WebElement lastName;

    @FindBy(how = How.CSS,using = "input[id=password]")
    WebElement pwd;

    @FindBy(how = How.CSS,using = "input[id=confirmPassword]")
    WebElement confirmPassword;

    @FindBy(how = How.CSS,using = "form button[class*=btn-default]")
    WebElement registerBtn;

    @FindBy(how = How.CSS,using = "form div[class*=alert-success]")
    WebElement registerSuccessMsg;


    public String NewUserRegistration(String userName)
    {
        user.sendKeys(userName);
        firstName.sendKeys("First " + userName);
        lastName.sendKeys("Last");
        pwd.sendKeys("Random1$");
        confirmPassword.sendKeys("Random1$");

        registerBtn.click();

        String actualSuccessMsg = registerSuccessMsg.getText();
        Assert.assertEquals(RegisterSuccessMsg,actualSuccessMsg);
        return userName;
    }
}
