package belongCancerApp.test;

import belongCancerApp.pageObject.MainPage;
import belongCancerApp.pageObject.login.LoginPage;
import belongCancerApp.pageObject.login.PhoneAuthentication;
import belongCancerApp.pageObject.login.SignupPage;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.ios.IOSDriver;
import io.qameta.allure.Step;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.Assert;
import org.testng.ITestContext;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;

import java.io.IOException;
import java.net.URL;
import java.util.concurrent.TimeUnit;

public class BaseTest {

    AppiumDriver<MobileElement> driver;

    @Parameters({"platform"})
    @BeforeClass
    public void setup(ITestContext testContext, String platform) throws IOException {
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
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
    }

    @BeforeClass
    @Step("Create new user and enter to the system")
    public void signup() {
        LoginPage loginPage = new LoginPage(driver);
        loginPage.clickOnButton("SIGN UP, IT'S FREE");
        SignupPage signupPage = new SignupPage(driver);
        signupPage.clickOnTermsPopupButton("I agree");
        signupPage.fillSignupForm("Liadtobi");
        signupPage.clickOnGotItButton();
        PhoneAuthentication phoneAuthentication = new PhoneAuthentication(driver);
        Assert.assertEquals(phoneAuthentication.phoneAuthenticationTitle(), "Phone Authentication");
        phoneAuthentication.clickOnSkipButton();
        MainPage mainPage = new MainPage(driver);
        if (mainPage.belongAppTutorialPopupTitleIsDisplayed()) {
            mainPage.clickOnBelongAppTutorialButton("WATCH LATER");
        }
        Assert.assertEquals(mainPage.userName(), "Hi Liadtobi");
    }

    @AfterClass
    public void tearDown() {
        driver.resetApp();
        driver.quit();
    }
}