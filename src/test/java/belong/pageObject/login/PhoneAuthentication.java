package belong.pageObject.login;

import belong.pageObject.BasePage;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.iOSXCUITFindBy;
import io.qameta.allure.Step;

public class PhoneAuthentication extends BasePage {
    public PhoneAuthentication(AppiumDriver<MobileElement> driver) {
        super(driver);
    }

    @AndroidFindBy(xpath = "/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.RelativeLayout/android.view.ViewGroup/android.widget.LinearLayout/android.view.ViewGroup/android.widget.TextView")
    @iOSXCUITFindBy()
    protected MobileElement phoneAuthenticationTitle;
    @AndroidFindBy(id = "com.belongtail.belong:id/action_skip_frag")
    @iOSXCUITFindBy()
    protected MobileElement skipButton;


    @Step("Return the text of phone authetication page")
    public String phoneAuthenticationTitle() {
        return getText(phoneAuthenticationTitle);
    }

    @Step("Click on skip button")
    public void clickOnSkipButton() {
        click(skipButton);
    }
}
