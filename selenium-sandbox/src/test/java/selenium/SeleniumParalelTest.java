package selenium;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.*;

/**
 * Created by tbalogh on 5/7/17.
 */
public class SeleniumParalelTest {

    private final String homePage = "http://androidweekly.net/";

    @BeforeClass
    public void setUp() {
    }

    @AfterClass
    public void tearDown() {
    }

//    @BeforeMethod
//    public void navigateToHome(WebDriver driver) {
//        driver.navigate().to(homePage);
//    }

//    @Test
//    public void testNavigateToJobs(WebDriver driver) {
//        driver.findElement(By.xpath("/html/body/header/div/nav/a[3]")).click();
//        new WebDriverWait(driver, 2).until(
//                ExpectedConditions.presenceOfElementLocated(
//                        new By() {
//                            @Override
//                            public List<WebElement> findElements(SearchContext searchContext) {
//                                WebElement element = searchContext.findElement(By.xpath("/html/body/div/h1"));
//                                if (element != null) {
//                                    return Arrays.asList(element);
//                                } else {
//                                    return new ArrayList<>();
//                                }
//                            }
//                        }
//                )
//        );
//        Assert.assertEquals(driver.findElement(By.xpath("/html/body/div/h1")).getText(), "Jobs");
//        Assert.assertTrue(driver.getCurrentUrl().equals("http://androidweekly.net/jobs"), "Url should be http://androidweekly.net/jobs");
//    }

    @Parameters({"browser"})
    @Test
    public void testTitle(int browser) {
        WebDriver driver = DriverProvider.get(browser);
        driver.navigate().to(homePage);
        Assert.assertTrue(driver.getTitle().startsWith("Android Weekly"), "Title should be Android Weekly");
        driver.close();
        driver.quit();
    }

//    @Parameters({"driver"})
//    @Test
//    public void testAdvertiseChooserSize(WebDriver driver) {
//        navigateToAdvertisePage(driver);
//
//        List<WebElement> issues = driver.findElements(By.xpath("//*[@id=\"chooser\"]/ul/li"));
//        Assert.assertEquals(issues.size(), 5);
//    }
//
//    @Parameters({"driver"})
//    @Test
//    public void testAdvertisePriceOfOneIssue(WebDriver driver) {
//        navigateToAdvertisePage(driver);
//
//        WebElement price = driver.findElement(By.xpath("//*[@id=\"chooser\"]/ul/li[5]/div/output"));
//        Assert.assertEquals(price.getText(), "= $190");
//
//        driver.findElement(By.xpath("//*[@id=\"chooser\"]/ul/li[2]")).click();
//        driver.findElement(By.xpath("//*[@id=\"chooser\"]/ul/li[1]")).click();
//        Assert.assertEquals(price.getText(), "= $190");
//    }
//
//    @Parameters({"driver"})
//    @Test
//    public void testAdvertisePriceOfTwoIssue(WebDriver driver) {
//        navigateToAdvertisePage(driver);
//
//        driver.findElement(By.xpath("//*[@id=\"chooser\"]/ul/li[2]")).click();
//        List<WebElement> prices = driver.findElements(By.xpath("//*[@id=\"chooser\"]/ul/li[5]/div/output"));
//
//        Assert.assertEquals(prices.get(prices.size() - 1).getText(), "= $380");
//    }
//
//    @Parameters({"driver"})
//    @Test
//    public void testAdvertisePriceOfThreeIssue(WebDriver driver) {
//        navigateToAdvertisePage(driver);
//
//        driver.findElement(By.xpath("//*[@id=\"chooser\"]/ul/li[3]")).click();
//        List<WebElement> prices = driver.findElements(By.xpath("//*[@id=\"chooser\"]/ul/li[5]/div/output"));
//
//        Assert.assertEquals(prices.get(prices.size() - 1).getText(), "= $570");
//    }

    private void navigateToAdvertisePage(WebDriver driver) {
        driver.findElement(By.xpath("/html/body/header/div/nav/a[2]")).click();
        new WebDriverWait(driver, 2).until(
                ExpectedConditions.presenceOfElementLocated(By.xpath("//*[@id=\"chooser\"]/ul"))
        );
    }
}
