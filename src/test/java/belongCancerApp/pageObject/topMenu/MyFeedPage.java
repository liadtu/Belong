package belongCancerApp.pageObject.topMenu;

import belongCancerApp.pageObject.BasePage;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.iOSXCUITFindBy;
import io.qameta.allure.Step;

public class MyFeedPage extends BasePage {
    public MyFeedPage(AppiumDriver<MobileElement> driver) {
        super(driver);
    }

    @AndroidFindBy(xpath = "/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.RelativeLayout/android.view.ViewGroup/android.widget.LinearLayout/android.view.ViewGroup/android.widget.TextView")
    @iOSXCUITFindBy()
    protected MobileElement myFeedTitle;
    @AndroidFindBy(accessibility = "Navigate up")
    @iOSXCUITFindBy()
    protected MobileElement backButton;
    @AndroidFindBy(id = "com.belongtail.belong:id/action_done_save_profile")
    @iOSXCUITFindBy()
    protected MobileElement saveButton;


    @Step("Return the text of the my feed page title")
    public String myFeedTitle() {
        return getText(myFeedTitle);
    }

    @Step("Click on button : {button}")
    public void clickOnButton(String button) {
        switch (button) {
            case "Back button":
                click(backButton);
                break;
            case "Save button":
                click(saveButton);
                break;
        }

    }
}
