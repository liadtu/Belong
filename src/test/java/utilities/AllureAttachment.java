package utilities;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.qameta.allure.Attachment;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

import java.nio.charset.StandardCharsets;

public class AllureAttachment {

    @Attachment(value = "Page Screenshot", type = "image/png", fileExtension = ".png")
    static byte[] attachScreenshot(AppiumDriver<MobileElement> driver) {
        return ((TakesScreenshot) driver).getScreenshotAs(OutputType.BYTES);
    }
}