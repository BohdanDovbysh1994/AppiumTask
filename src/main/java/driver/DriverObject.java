package driver;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.remote.MobileCapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.TimeUnit;

public class DriverObject {
    private static Map<Long, AppiumDriver> driverMap = new HashMap();

    private DriverObject() {
    }

    private static AppiumDriver createDriver() {
        DesiredCapabilities capability = new DesiredCapabilities();
        capability.setCapability(MobileCapabilityType.PLATFORM_NAME, "Android");
        capability.setCapability(MobileCapabilityType.PLATFORM_VERSION, "5.0");
        capability.setCapability(MobileCapabilityType.DEVICE_NAME, "Samsung Galaxy S6");
        capability.setCapability(MobileCapabilityType.BROWSER_NAME, "Browser");
        URL url = null;
        try {
            url = new URL("http://127.0.0.1:4723/wd/hub");
        } catch (MalformedURLException e) {
            e.printStackTrace();
        }
        AppiumDriver driver = new AppiumDriver(url, capability);
        driver.manage().timeouts().implicitlyWait(45, TimeUnit.SECONDS);
        return driver;
    }

    public static void releaseThread() {
        DriverObject.getDriver().quit();
        driverMap.remove(Thread.currentThread().getId());
    }

    public static AppiumDriver getDriver() {
        long currentThread = Thread.currentThread().getId();
        AppiumDriver driver = driverMap.get(currentThread);
        if (driver == null) {
            driver = createDriver();
            driverMap.put(currentThread, driver);
        }
        return driver;
    }
}
