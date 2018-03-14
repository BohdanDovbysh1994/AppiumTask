import driver.DriverObject;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.remote.MobileCapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pageobjects.GmailPage;
import pageobjects.LoginPage;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.TimeUnit;

public class GmailTest {
//    private AppiumDriver driver;
    private LoginPage loginPage;
    private GmailPage gmailPage;

    @BeforeMethod
    public void setUp() throws MalformedURLException {
//        DesiredCapabilities capability = new DesiredCapabilities();
//        capability.setCapability(MobileCapabilityType.PLATFORM_NAME, "Android");
//        capability.setCapability(MobileCapabilityType.PLATFORM_VERSION, "5.0");
//        capability.setCapability(MobileCapabilityType.DEVICE_NAME, "Samsung Galaxy S6");
//        capability.setCapability(MobileCapabilityType.BROWSER_NAME, "Browser");
//        URL url = new URL("http://127.0.0.1:4723/wd/hub");
//        driver = new AppiumDriver(url, capability);
//        driver.manage().timeouts().implicitlyWait(45, TimeUnit.SECONDS);
        loginPage = new LoginPage(DriverObject.getDriver());
        gmailPage = new GmailPage(DriverObject.getDriver());
    }

    @Test
    public void test() {
        DriverObject.getDriver().get("https://www.google.com/intl/ru/gmail/about/");
        loginPage.loginGmail("homeworkbohdan@gmail.com");
        loginPage.setPasswordInput("719113719113", DriverObject.getDriver());
        gmailPage.sentLetter("dovbysh.bohdan@gmail.com", "test2", "Test2");
        gmailPage.deleteMessage(DriverObject.getDriver());
        Assert.assertTrue(gmailPage.isImageDisplayed());
    }

    @AfterMethod
    public void closeDr() {
        DriverObject.releaseThread();
    }
}
