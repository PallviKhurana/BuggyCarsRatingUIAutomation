package WebUIAutomation;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

public class ModelPage extends Base{
    public ModelPage(WebDriver driver) {
        super(driver);
    }

    @FindBy(how = How.CSS,using = "div[class=row] h3")
    WebElement modelHeader;

    public String GetModelHeader()
    {
        return modelHeader.getText();
    }
}
