import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriverService;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.io.File;

import static java.util.concurrent.TimeUnit.SECONDS;

public class TestBase {

    public static WebDriver driver;
    private static ChromeDriverService service;
    public static WebDriverWait wait;
    private final static String PATH_TO_CHROMEDRIVER = "driver/chromedriver";


    public TestBase() {
        try {
            service = new ChromeDriverService.Builder()
                    .usingDriverExecutable(new File(PATH_TO_CHROMEDRIVER))
                    .usingAnyFreePort()
                    .build();
            service.start();

            DesiredCapabilities capabilities = new DesiredCapabilities();
            capabilities.setCapability("...", true);
            ChromeOptions option = new ChromeOptions();

            driver = new RemoteWebDriver(service.getUrl(), option);

            driver.manage().timeouts().implicitlyWait(10, SECONDS);
            driver.manage().timeouts().pageLoadTimeout(20, SECONDS);
            wait = new WebDriverWait(driver, 15);

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    void goToURL(String url, boolean maximizeWindow) {
        driver.get(url);
        if (maximizeWindow) {
            driver.manage().window().maximize();
        }
    }



    public void moveToElement(String elementLocation) {

        Actions builder = new Actions(driver);
        builder.moveToElement(driver.findElement(By.xpath(elementLocation))).build().perform();
        builder.click(driver.findElement(By.xpath(elementLocation))).build().perform();

    }




}
