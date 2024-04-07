package core;

import contactlist.MainPage;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.time.Duration;

public class BaseTests {
    protected static WebDriver driver;
    protected MainPage mainPage;
    protected Actions actions;


    @BeforeEach
    public void setUp() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
        actions = new Actions(driver);
        BaseSeleniumPage.setDriver(driver);
        mainPage = new MainPage();
    }

    public static WebDriver getDriver() {
        return driver;
    }

    @AfterEach
    public void tearDown() {
        driver.close();
        driver.quit();
    }
}
