package selenium;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.remote.CapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;

import java.util.HashMap;
import java.util.Map;

import static selenium.DriverProvider.BrowserPlatform.CHROME;
import static selenium.DriverProvider.BrowserPlatform.FIREFOX;

/**
 * Created by tbalogh on 5/11/17.
 */
public class DriverProvider {

    public static WebDriver get(int browser) {
        if (browser == 0) {
            return drivers.get(CHROME);
        } else {
            return drivers.get(FIREFOX);
        }
    }

    enum BrowserPlatform { CHROME, FIREFOX }

    private static final Map<BrowserPlatform, WebDriver> drivers = new HashMap<>();
    static {
        drivers.put(CHROME, createChromeDriver());
        drivers.put(FIREFOX, createFirefoxDriver());
    }

    private static WebDriver createChromeDriver() {
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

        return new ChromeDriver(capabilities);
    }

    private static WebDriver createFirefoxDriver() {
        DesiredCapabilities capabilities = new DesiredCapabilities();
        capabilities.setCapability(CapabilityType.BROWSER_NAME, "firefox");
        return new FirefoxDriver(capabilities);
    }

//    @DataProvider(name = "chrome-driver")
    public static Object[][] chromeDriver() {
        Object[][] params = new Object[1][1];
        params[0][0] = drivers.get(CHROME);
        return params;
    }

//    @DataProvider(name = "firefox-driver")
    public static Object[][] firefoxDriver() {
        Object[][] params = new Object[1][1];
        params[0][0] = drivers.get(FIREFOX);
        return params;
    }
}
