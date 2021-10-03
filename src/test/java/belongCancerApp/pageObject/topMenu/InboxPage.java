package belongCancerApp.pageObject.topMenu;

import belongCancerApp.pageObject.BasePage;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.iOSXCUITFindBy;
import io.qameta.allure.Step;

public class InboxPage extends BasePage {
    public InboxPage(AppiumDriver<MobileElement> driver) {
        super(driver);
    }

    @AndroidFindBy(xpath = "/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.view.ViewGroup/android.widget.LinearLayout/android.widget.RelativeLayout/android.view.ViewGroup/android.widget.TextView")
    @iOSXCUITFindBy()
    protected MobileElement inboxTitle;
    @AndroidFindBy(accessibility = "Navigate up")
    @iOSXCUITFindBy()
    protected MobileElement backButton;


    @Step("Return the text of the inbox page title")
    public String inboxTitle() {
        return getText(inboxTitle);
    }

    @Step("Click on back button")
    public void clickOnBackButton() {
        click(backButton);
    }
}
