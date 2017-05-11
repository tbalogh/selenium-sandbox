import org.openqa.selenium.By;
import org.openqa.selenium.SearchContext;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.CapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.*;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created by tbalogh on 5/7/17.
 */
@Listeners({AWChromeTestListener.class})
public class AWChromeTest {

    private final String homePage = "http://androidweekly.net/";

    WebDriver driver;

    @BeforeClass
    public void setUp() {
        driver = new ChromeDriver(getCapabilities());
    }

    @AfterClass
    public void tearDown() {
        driver.close();
        driver.quit();
    }

    @BeforeMethod
    public void navigateToHome() {
        driver.navigate().to(homePage);
    }

    @Test
    public void testNavigateToJobs() {
        driver.findElement(By.xpath("/html/body/header/div/nav/a[3]")).click();
        new WebDriverWait(driver, 2).until(
                ExpectedConditions.presenceOfElementLocated(
                        new By() {
                            @Override
                            public List<WebElement> findElements(SearchContext searchContext) {
                                WebElement element = searchContext.findElement(By.xpath("/html/body/div/h1"));
                                if (element != null) {
                                    return Arrays.asList(element);
                                } else {
                                    return new ArrayList<>();
                                }
                            }
                        }
                )
        );
        Assert.assertEquals(driver.findElement(By.xpath("/html/body/div/h1")).getText(), "Jobs");
        Assert.assertTrue(driver.getCurrentUrl().equals("http://androidweekly.net/jobs"), "Url should be http://androidweekly.net/jobs");
    }

    @Test
    public void testTitle() {
//        System.out.println(driver.getTitle());
        Assert.assertTrue(driver.getTitle().startsWith("Android Weekly"), "Title should be Android Weekly");
    }

    @Test
    public void testAdvertiseChooserSize() {
        navigateToAdvertisePage();

        List<WebElement> issues = driver.findElements(By.xpath("//*[@id=\"chooser\"]/ul/li"));
        Assert.assertEquals(issues.size(), 5);
    }

    @Test
    public void testAdvertisePriceOfOneIssue() {
        navigateToAdvertisePage();

        WebElement price = driver.findElement(By.xpath("//*[@id=\"chooser\"]/ul/li[5]/div/output"));
        Assert.assertEquals(price.getText(), "= $190");

        driver.findElement(By.xpath("//*[@id=\"chooser\"]/ul/li[2]")).click();
        driver.findElement(By.xpath("//*[@id=\"chooser\"]/ul/li[1]")).click();
        Assert.assertEquals(price.getText(), "= $190");
    }

    @Test
    public void testAdvertisePriceOfTwoIssue() {
        navigateToAdvertisePage();

        driver.findElement(By.xpath("//*[@id=\"chooser\"]/ul/li[2]")).click();
        List<WebElement> prices = driver.findElements(By.xpath("//*[@id=\"chooser\"]/ul/li[5]/div/output"));

        Assert.assertEquals(prices.get(prices.size() - 1).getText(), "= $380");
    }

    @Test
    public void testAdvertisePriceOfThreeIssue() {
        navigateToAdvertisePage();

        driver.findElement(By.xpath("//*[@id=\"chooser\"]/ul/li[3]")).click();
        List<WebElement> prices = driver.findElements(By.xpath("//*[@id=\"chooser\"]/ul/li[5]/div/output"));

        Assert.assertEquals(prices.get(prices.size() - 1).getText(), "= $570");
    }

    private void waitASec() {
        try {
            Thread.sleep(1000);
        } catch (InterruptedException ignored) {
        }
    }

    private DesiredCapabilities getCapabilities() {
        DesiredCapabilities capabilities = new DesiredCapabilities();
        ChromeOptions chromeOptions = (ChromeOptions) capabilities.getCapability(ChromeOptions.CAPABILITY);
        if (chromeOptions == null) {
            chromeOptions = new ChromeOptions();
        }
//        chromeOptions.addArguments("--start-fullscreen");
//        chromeOptions.addArguments("start-maximized");
        chromeOptions.addArguments("--user-data-dir=/Users/tbalogh/dev/lmi/testlocal");
        capabilities.setCapability(ChromeOptions.CAPABILITY, chromeOptions);
        capabilities.setCapability(CapabilityType.BROWSER_NAME, "chrome");
        return capabilities;
    }

    private void navigateToAdvertisePage() {
        driver.findElement(By.xpath("/html/body/header/div/nav/a[2]")).click();
        new WebDriverWait(driver, 2).until(
                ExpectedConditions.presenceOfElementLocated(By.xpath("//*[@id=\"chooser\"]/ul"))
        );
    }
}
