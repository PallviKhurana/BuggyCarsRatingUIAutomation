package WebUIAutomation;

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
    (@FindBy(how = How.XPATH,using = "//table/tbody/tr/td/a"))
    List<WebElement> models;


    public void GoToModel(String modelName) {

        for (WebElement element : models) {
            if (element.getText().equals(modelName)) {
                element.click();
                break;
            }
        }
    }

    public Integer GetModelCurrentVotes(String modelName) {
        List<WebElement> currentVotes = null;
        for (WebElement element : models) {
            if (element.getText().equals(modelName)) {
                currentVotes = element.findElements(By.xpath("../../td"));
                break;
            }
        }
        assert currentVotes != null;
        return Integer.valueOf(currentVotes.get(3).getText());
    }

    public String GetCardHeader() {
        return cardText.getText();
    }
}
