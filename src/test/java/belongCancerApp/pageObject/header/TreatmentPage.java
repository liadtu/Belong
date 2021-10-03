package belongCancerApp.pageObject.header;

import belongCancerApp.pageObject.BasePage;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.iOSXCUITFindBy;
import io.qameta.allure.Step;

import java.util.List;

public class TreatmentPage extends BasePage {
    public TreatmentPage(AppiumDriver<MobileElement> driver) {
        super(driver);
    }

    @AndroidFindBy(className = "android.widget.Button")
    @iOSXCUITFindBy()
    protected List<MobileElement> treatmentTermsPopupButtons;
    @AndroidFindBy(xpath = "/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.RelativeLayout/androidx.drawerlayout.widget.DrawerLayout/android.view.ViewGroup/android.widget.LinearLayout[1]/android.view.ViewGroup/android.widget.TextView")
    @iOSXCUITFindBy()
    protected MobileElement treatmentTitle;
    @AndroidFindBy(accessibility = "Navigate up")
    @iOSXCUITFindBy()
    protected MobileElement backButton;


    @Step("Click on button from the treatment terms popup : {button}")
    public void clickOnTreatmentTermsPopupButton(String button){
        waitForElementVisibility(treatmentTermsPopupButtons.get(0));
        for (MobileElement element: treatmentTermsPopupButtons){
            if (getText(element).equals(button)){
                click(element);
                break;
            }
        }
    }

    @Step("Return the text of treatment page title")
    public String treatmentTitle() {
        return getText(treatmentTitle);
    }

    @Step("Click on back button")
    public void clickOnBackButton() {
        click(backButton);
    }
}
