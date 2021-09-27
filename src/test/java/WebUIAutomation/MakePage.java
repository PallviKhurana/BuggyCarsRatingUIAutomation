package WebUIAutomation;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindAll;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

import java.util.List;

public class MakePage extends Base{
    public MakePage(WebDriver driver) {
        super(driver);
    }

    @FindBy(how = How.CSS,using = "div[class=card] h3")
    WebElement cardText;
    @FindAll
    (@FindBy(how = How.CSS,using = "table tr td a"))
    List<WebElement> models;


 //   GoToModel(driver,"Diablo");

   //

    //    Assert.assertEquals("Diablo",modelHeader.getText());

    public void GoToModel(String modelName) {

        for (WebElement element : models) {
            if (element.getText().equals(modelName)) {
                element.click();
                break;
            }
        }
    }

    public String GetCardHeader() {
        return cardText.getText();
    }
}
