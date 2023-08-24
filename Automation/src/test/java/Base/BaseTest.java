package Base;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;

public class BaseTest {
    private WebDriver driver;

    @BeforeMethod
    public void init(){
        String browser = System.getProperty("browser");
        if (browser != null ){
            switch (browser){
                case "Chrome":
                    driver = new ChromeDriver();
                    break;
                case "Firefox":
                    driver = new FirefoxDriver();
                    break;
                case "Edge":
                    driver = new EdgeDriver();
                    break;
            }
        } else {
            driver = new ChromeDriver();
        }

        driver.get("http://localhost:3000/");
    }

    @AfterMethod
    public void tearDown(){
        if (driver != null){
            driver.close();
            driver.quit();
        }
    }

    public WebDriver getDriver() { return driver; }

}
