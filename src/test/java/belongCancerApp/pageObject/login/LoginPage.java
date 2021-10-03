package belongCancerApp.pageObject.login;

import belongCancerApp.pageObject.BasePage;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.iOSXCUITFindBy;
import io.qameta.allure.Step;

import java.util.List;

public class LoginPage extends BasePage {
    public LoginPage(AppiumDriver<MobileElement> driver) {
        super(driver);
    }

    @AndroidFindBy(className = "android.widget.Button")
    @iOSXCUITFindBy()
    protected List<MobileElement> loginButtons;

    @Step("Click on button: {button}")
    public void clickOnButton(String button) {
        waitForElementClickable(loginButtons.get(0));
        for (MobileElement element : loginButtons){
            if (getText(element).equals(button)){
                click(element);
                break;
            }
        }
    }
}
