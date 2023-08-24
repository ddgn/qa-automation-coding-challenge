package Features;

import Base.BaseTest;
import PageObjects.HomePage;
import org.testng.Assert;
import org.testng.annotations.Test;

public class PositiveScenarios extends BaseTest {

    @Test
    public void userInterfaceElementsTest(){
        HomePage homePage = new HomePage(getDriver(), 10);
        Assert.assertTrue(homePage.isPageLoaded());
        Assert.assertTrue(homePage.validateElementsDisplayed());
    }

    @Test
    public void searchGithubValidUserTest(){
        HomePage homePage = new HomePage(getDriver(), 10);
        Assert.assertTrue(homePage.isPageLoaded());
        homePage.inputGithubUsername("ddgn");
        homePage.selectGoButton();
        Assert.assertTrue(homePage.validateResultsAreShown());
        Assert.assertTrue(homePage.selectLinkFromListAndValidateLoadPage(1));
    }
}
