package utilities;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.qameta.allure.Attachment;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.testng.ITestListener;
import org.testng.ITestResult;
import org.testng.TestListenerAdapter;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class ListenerClass extends TestListenerAdapter implements ITestListener {

    @Attachment
    public byte[] captureScreenshot(AppiumDriver<MobileElement> driver) {
        return ((TakesScreenshot) driver).getScreenshotAs(OutputType.BYTES);
    }

    @Override
    public void onTestFailure(ITestResult result) {
        LocalDateTime myDateObj = LocalDateTime.now();
        DateTimeFormatter myFormatObj = DateTimeFormatter.ofPattern("dd/MM/yy HH:mm:ss");
        String formattedDate = myDateObj.format(myFormatObj);
        System.out.println("Test ended at: " + formattedDate);
        System.out.println("Test " + result.getName() + " Failed");
        Object webDriverAttribute = result.getTestContext().getAttribute("WebDriver");
        if (webDriverAttribute instanceof WebDriver) {
            captureScreenshot((AppiumDriver<MobileElement>) webDriverAttribute);
            AllureAttachment.attachScreenshot((AppiumDriver<MobileElement>) webDriverAttribute);
        }
    }

    public void onTestStart(ITestResult test) {
        LocalDateTime myDateObj = LocalDateTime.now();
        DateTimeFormatter myFormatObj = DateTimeFormatter.ofPattern("dd/MM/yy HH:mm:ss");
        String formattedDate = myDateObj.format(myFormatObj);
        System.out.println("Test " + test.getName() + "started at: " + formattedDate);
    }

    public void onTestSuccess(ITestResult test) {
        LocalDateTime myDateObj = LocalDateTime.now();
        DateTimeFormatter myFormatObj = DateTimeFormatter.ofPattern("dd/MM/yy HH:mm:ss");
        String formattedDate = myDateObj.format(myFormatObj);
        System.out.println("Test ended at: " + formattedDate);
        System.out.println("Test: " + test.getName() + " Passed");
    }
}