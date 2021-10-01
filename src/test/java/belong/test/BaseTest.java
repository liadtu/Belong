package belong.test;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.ios.IOSDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;

import java.io.IOException;
import java.net.URL;

public class BaseTest {

    AppiumDriver<WebElement> driver;

    @Parameters({"platform"})
    @BeforeClass
    public void setup(String platform) throws IOException {
        DesiredCapabilities cap = new DesiredCapabilities();
        switch (platform) {
            case "iOS":
                cap.setCapability("platformName", "iOS");
                cap.setCapability("deviceName", "iPhone");
                cap.setCapability("version", "14.6");
                cap.setCapability("udid", "00008020-000D0D090182002E");
                cap.setCapability("automationName", "XCUITest");
//                cap.setCapability("appActivity", "");
//                cap.setCapability("appPackage", "");

                driver = new IOSDriver<>(new URL("http://localhost:4723/wd/hub"), cap);

                break;
            case "Android":
                cap.setCapability("platformName", "Android");
                cap.setCapability("deviceName", "Galaxy s10");
                cap.setCapability("platformVersion", "11.0");
                cap.setCapability("udid", "RF8M41PXY7F");
                cap.setCapability("automationName", "UiAutomator2");
                cap.setCapability("appActivity", "com.belongtail.activities.MainActivity");
                cap.setCapability("appPackage", "com.belongtail.belong");

                driver = new AndroidDriver<>(new URL("http://localhost:4723/wd/hub"), cap);

                break;
        }
    }
}