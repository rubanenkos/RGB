import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import static java.lang.Thread.sleep;


public class ColorTest extends TestBase {

    @BeforeTest
    public void preConditionStep() {
        goToURL("https://www.rrrgggbbb.com/", true);
    }

    @Test
    public void login() throws InterruptedException {

        moveToElement(HomePage.variableR);
        sleep(200);
        Assert.assertTrue(isElementHasClass(HomePage.variableR, "black"));
        Assert.assertTrue(isElementPresent(HomePage.redBackground));

        moveToElement(HomePage.variableG);
        sleep(200);
        Assert.assertTrue(isElementHasClass(HomePage.variableG, "black"));
        Assert.assertTrue(isElementPresent(HomePage.greenBackground));

        moveToElement(HomePage.variableB);
        sleep(200);
        Assert.assertTrue(isElementHasClass(HomePage.variableB, "black"));
        Assert.assertTrue(isElementPresent(HomePage.blueBackground));

    }

    @AfterTest
    public void postConditionStep() {
        driver.quit();
    }
}
