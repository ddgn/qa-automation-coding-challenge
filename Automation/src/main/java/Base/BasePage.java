package Base;


import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.FluentWait;

import java.time.Duration;


public class BasePage {

    protected WebDriver driver;
    protected FluentWait<WebDriver> wait;

    public BasePage (WebDriver driver, int waitDuration){
        driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(10));
        this.driver = driver;
        wait = new FluentWait<>(this.driver);
        wait.withTimeout(Duration.ofSeconds(waitDuration)).pollingEvery(Duration.ofSeconds(1));
        wait.ignoring(NoSuchElementException.class);
    }

}
