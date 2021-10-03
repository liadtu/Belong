package belongCancerApp.pageObject.login;

import belongCancerApp.pageObject.BasePage;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.iOSXCUITFindBy;
import io.qameta.allure.Step;

import java.util.List;

public class SignupPage extends BasePage {
    public SignupPage(AppiumDriver<MobileElement> driver) {
        super(driver);
    }

    @AndroidFindBy(className = "android.widget.Button")
    @iOSXCUITFindBy()
    protected List<MobileElement> termsPopupButtons;

    @AndroidFindBy(id = "com.belongtail.belong:id/relative_layout_user_type")
    @iOSXCUITFindBy()
    protected MobileElement userTypeInput;
    @AndroidFindBy(className = "android.widget.RelativeLayout")
    @iOSXCUITFindBy()
    protected List<MobileElement> userTypesList;
    @AndroidFindBy(id = "com.belongtail.belong:id/relative_layout_user_interests")
    @iOSXCUITFindBy()
    protected MobileElement cancerTypeInput;
    @AndroidFindBy(id = "com.belongtail.belong:id/relative_layout_illness_row")
    @iOSXCUITFindBy()
    protected List<MobileElement> cancerTypesList;
    @AndroidFindBy(id = "com.belongtail.belong:id/relative_layout_user_cancer_type")
    @iOSXCUITFindBy()
    protected MobileElement cancerSubTypeInput;
    @AndroidFindBy(id = "com.belongtail.belong:id/relative_layout_illness_row")
    @iOSXCUITFindBy()
    protected List<MobileElement> cancerSubTypesList;
    @AndroidFindBy(id = "com.belongtail.belong:id/edit_text_profile_user_name")
    @iOSXCUITFindBy()
    protected MobileElement nicknameField;
    @AndroidFindBy(id = "com.belongtail.belong:id/button_login_form_finish_next")
    @iOSXCUITFindBy()
    protected MobileElement finishButton;

    @AndroidFindBy(id = "com.belongtail.belong:id/text_view_congrats_header")
    @iOSXCUITFindBy()
    protected MobileElement createUserPopupTitle;
    @AndroidFindBy(id = "com.belongtail.belong:id/layout_buttons_sign_in")
    @iOSXCUITFindBy()
    protected MobileElement gotItButton;

    @Step("Click on button from terms popup: {button}")
    public void clickOnTermsPopupButton(String button) {
        for (MobileElement element : termsPopupButtons) {
            if (getText(element).equals(button)) {
                click(element);
                break;
            }
        }
    }

    @Step("Fill the signup form")
    public void fillSignupForm(String nickname) {
        click(userTypeInput);
        waitForElementClickable(userTypesList.get(0));
        click(userTypesList.get(userTypesList.size() - 1));
        click(cancerTypeInput);
        waitForElementVisibility(cancerTypesList.get(0));
        click(cancerTypesList.get(cancerTypesList.size() - 1));
        click(cancerSubTypeInput);
        waitForElementVisibility(cancerSubTypesList.get(0));
        click(cancerSubTypesList.get(cancerSubTypesList.size() - 1));
        click(nicknameField);
        fillText(nicknameField, nickname);
        click(finishButton);
    }

    @Step("Return the text of create user popup")
    public String createUserPopupTitle() {
        return getText(createUserPopupTitle);
    }

    @Step("Click on got it button")
    public void clickOnGotItButton() {
        click(gotItButton);
    }
}
