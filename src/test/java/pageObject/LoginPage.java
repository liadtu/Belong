package pageObject;

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
    protected List<MobileElement> buttonsList;

    @Step("Click on button: {button}")
    public void clickOnButton(String button) {
        for (MobileElement element : buttonsList) {
            if (getText(element).equals(button)) {
                click(element);
                break;
            }
        }
    }
}
