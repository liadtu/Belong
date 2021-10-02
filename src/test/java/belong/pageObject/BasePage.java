package belong.pageObject;

import com.google.common.collect.ImmutableMap;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.List;

public class BasePage {
    AppiumDriver<MobileElement> driver;
    protected final int timeOutInSeconds = 30;

    public BasePage(AppiumDriver<MobileElement> driver) {
        PageFactory.initElements(new AppiumFieldDecorator(driver), this);
        this.driver = driver;
    }

    protected void click(MobileElement el) {
        waitForElementClickable(el);
        el.click();
    }

    protected void fillText(MobileElement el, String text) {
//        wait.until(ExpectedConditions.visibilityOf(el));
        waitForElementClickable(el);
        el.clear();
        el.sendKeys(text);
        clickEnter();
    }

    protected String getText(MobileElement el) {
//        wait.until(ExpectedConditions.visibilityOf(el));
        waitForElementVisibility(el);
        return el.getText();
    }

    protected void clickEnter(){
        sleep(1000);
        driver.executeScript("mobile: performEditorAction", ImmutableMap.of("action", "search"));
    }

    protected boolean isDisplayed(MobileElement el){
        waitForElementVisibility(el);
        return el.isDisplayed();
    }

    public void sleep(long millis) {
        try {
            Thread.sleep(millis);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public void waitForElementVisibility(MobileElement el){
        WebDriverWait wait = new WebDriverWait(driver, timeOutInSeconds);
        wait.until(ExpectedConditions.visibilityOf(el));
    }

    public void waitForElementClickable(MobileElement el){
        WebDriverWait wait = new WebDriverWait(driver, timeOutInSeconds);
        wait.until(ExpectedConditions.elementToBeClickable(el));
    }
}