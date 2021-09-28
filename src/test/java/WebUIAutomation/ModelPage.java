package WebUIAutomation;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

public class ModelPage extends Base{

    final String VoteSuccessMsg = "Thank you for your vote!";

    public ModelPage(WebDriver driver) {
        super(driver);
    }

    @FindBy(how = How.CSS,using = "div[class=row] h3")
    WebElement modelHeader;

    @FindBy(how=How.CSS,using = "fieldset textarea[id=comment]")
    WebElement commentBox;

    @FindBy(how=How.CSS,using = "div button")
    WebElement voteButton;

    @FindBy(how=How.CSS,using = "div[class=card-block] p[class=card-text]")
    WebElement successVoteMsg;

    @FindBy(how=How.CSS,using = "h4 strong")
    WebElement voteCount;

    public String GetModelHeader()
    {
        return modelHeader.getText();
    }

    public void AddComment(String comment)
    {
        commentBox.sendKeys(comment);
        voteButton.click();
    }

    public boolean IsVoteSuccessFull()
    {
        return successVoteMsg.getText().equals(VoteSuccessMsg);
    }

    public Integer GetLatestCount()
    {
        return Integer.valueOf(voteCount.getText());
    }
}
