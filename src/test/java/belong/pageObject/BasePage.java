package belong.pageObject;

import com.google.common.collect.ImmutableMap;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class BasePage {
    AppiumDriver<MobileElement> driver;
    WebDriverWait wait;

    {
        assert false;
        wait = new WebDriverWait(driver, 10);
    }

    public BasePage(AppiumDriver<MobileElement> driver) {
        this.driver = driver;
    }

    protected void click(MobileElement el) {
        wait.until(ExpectedConditions.elementToBeClickable(el));
        el.click();
    }

    protected void fillText(MobileElement el, String text) {
        wait.until(ExpectedConditions.visibilityOf(el));
        el.clear();
        el.sendKeys(text);
    }

    protected String getText(MobileElement el) {
        wait.until(ExpectedConditions.visibilityOf(el));
        return el.getText();
    }

    protected void clickEnter(){
        sleep(2000);
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