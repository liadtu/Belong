package pageObject;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.iOSXCUITFindBy;
import io.qameta.allure.Step;

import java.util.List;

public class resultPage extends BasePage {
    public resultPage(AppiumDriver<MobileElement> driver) {
        super(driver);
    }

    @AndroidFindBy(xpath = "/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.view.ViewGroup/android.view.ViewGroup/android.widget.RelativeLayout/androidx.recyclerview.widget.RecyclerView/android.widget.FrameLayout[1]/android.widget.LinearLayout/android.widget.RelativeLayout[1]/android.widget.RelativeLayout[3]/android.widget.ImageView")
    @iOSXCUITFindBy()
    protected MobileElement hamburgerMenu;
    @AndroidFindBy(xpath = "/hierarchy/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.ListView/android.widget.LinearLayout")
    @iOSXCUITFindBy()
    protected MobileElement hideThisPostButton;
    @AndroidFindBy(className = "android.widget.Button")
    @iOSXCUITFindBy()
    protected List<MobileElement> hidePostReasons;
    @AndroidFindBy(xpath = "/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.view.ViewGroup/android.view.ViewGroup/android.widget.RelativeLayout/androidx.recyclerview.widget.RecyclerView/android.widget.FrameLayout[1]/android.widget.LinearLayout/android.widget.RelativeLayout[1]/android.widget.RelativeLayout[2]/android.widget.TextView[3]")
    @iOSXCUITFindBy()
    protected MobileElement postTime;
    @AndroidFindBy(xpath = "/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.view.ViewGroup/android.view.ViewGroup/android.widget.RelativeLayout/androidx.recyclerview.widget.RecyclerView/android.widget.FrameLayout[1]/android.widget.LinearLayout/android.widget.RelativeLayout[1]/android.widget.RelativeLayout[4]/android.widget.TextView")
    @iOSXCUITFindBy()
    protected MobileElement postText;


    @Step("Hide post")
    public void hidePost() {
        click(hamburgerMenu);
        click(hideThisPostButton);
    }

    @Step("Click on one of the reason from the list :{reason}")
    public void clickInReason(String reason) {
        for (MobileElement element : hidePostReasons) {
            if (getText(element).equals(reason)) {
                click(element);
                break;
            }
        }
    }

    @Step("Return the post time")
    public String postTime() {
        return getText(postTime);
    }

    @Step("Return the post text")
    public String postText() {
        return getText(postText);
    }
}