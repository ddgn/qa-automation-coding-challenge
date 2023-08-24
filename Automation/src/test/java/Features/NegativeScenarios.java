package Features;

import Base.BaseTest;
import PageObjects.HomePage;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.UUID;

public class NegativeScenarios extends BaseTest {

    @Test
    public void notExistingUsernameValidationTest(){
        HomePage homePage = new HomePage(getDriver(), 10);
        Assert.assertTrue(homePage.isPageLoaded());
        homePage.inputGithubUsername(UUID.randomUUID().toString());
        homePage.selectGoButton();
        Assert.assertTrue(homePage.validateNoReposResult());
    }

    @Test
    public void emptyUsernameValidationTest(){
        HomePage homePage = new HomePage(getDriver(), 10);
        Assert.assertTrue(homePage.isPageLoaded());
        homePage.selectGoButton();
        Assert.assertTrue(homePage.validateNoReposResult());
    }

}
