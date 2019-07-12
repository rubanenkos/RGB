import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;


public class ColorTest extends TestBase {

    @BeforeTest
    public void preConditionStep() {
        goToURL("https://www.rrrgggbbb.com/", true);
    }

    @Test
    public void login() {
        moveToElement(HomePage.variableR);
        moveToElement(HomePage.variableG);
        moveToElement(HomePage.variableB);
    }

    @AfterTest
    public void postConditionStep() {
        driver.quit();
    }
}
