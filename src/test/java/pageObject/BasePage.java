package pageObject;

import com.google.common.collect.ImmutableMap;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class BasePage {
    AppiumDriver<MobileElement> driver;

    public BasePage(AppiumDriver<MobileElement> driver) {
        this.driver = driver;
    }

    protected void click(MobileElement el) {
        el.click();
    }

    protected void fillText(MobileElement el, String text) {
        el.clear();
        el.sendKeys(text);
    }

    protected String getText(MobileElement el) {
        return el.getText();
    }

    protected void clickEnter(){
        driver.executeScript("mobile: performEditorAction", ImmutableMap.of("action", "search"));
    }

    protected boolean isDisplayed(MobileElement el){
        return el.isDisplayed();
    }

    public void sleep(long millis) {
        try {
            Thread.sleep(millis);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}