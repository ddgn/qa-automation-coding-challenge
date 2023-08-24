package PageObjects;

import Base.BasePage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;

import java.util.List;

public class HomePage extends BasePage {

    public HomePage(WebDriver driver, int waitDuration){
        super(driver, waitDuration);
        PageFactory.initElements(driver, this);
    }

    @FindBy(xpath = "//header//h1")
    protected WebElement header;

    @FindBy(xpath = "//label[@for='username']")
    protected WebElement usernameLabel;

    @FindBy(id = "username")
    protected WebElement inputUsername;

    @FindBy(xpath = "//button[@class='submit']")
    protected WebElement submitButton;

    @FindBy(xpath = "//p[@class='output-status-text']")
    protected WebElement outputStatusTextNoRepos;

    @FindBy(xpath = "//li[@class='repo-row']//a")
    protected List<WebElement> listResultsLinks;

    @FindBy(xpath = "//p[@class='repo-amount']")
    protected WebElement repoAmountResult;

    @FindBy(xpath = "//header[@role='banner']")
    protected WebElement githubHeader;

    public boolean isPageLoaded(){
        return wait.until(ExpectedConditions.visibilityOf(header)).isDisplayed();
    }

    public boolean validateElementsDisplayed(){
        return header.isDisplayed()
                && usernameLabel.isDisplayed()
                && inputUsername.isDisplayed()
                && submitButton.isDisplayed();
    }

    public void inputGithubUsername (String username){
        inputUsername.sendKeys(username);
    }

    public void selectGoButton(){
        wait.until(ExpectedConditions.elementToBeClickable(submitButton));
        submitButton.click();
    }

    public boolean validateResultsAreShown(){
        wait.until(ExpectedConditions.visibilityOf(repoAmountResult)).isDisplayed();
        return listResultsLinks.size() != 0;
    }

    public boolean validateNoReposResult(){
        return wait.until(ExpectedConditions.visibilityOf(outputStatusTextNoRepos)).isDisplayed();
    }

    public boolean selectLinkFromListAndValidateLoadPage(int index){
        String repoName = listResultsLinks.get(index).getText();
        listResultsLinks.get(index).click();
        wait.until(ExpectedConditions.numberOfWindowsToBe(2));
        driver.switchTo().window(driver.getWindowHandles().toArray()[1].toString());
        wait.until(ExpectedConditions.visibilityOf(githubHeader)).isDisplayed();
        String currentUrl = driver.getCurrentUrl();
        return currentUrl.contains(repoName);
    }

}
