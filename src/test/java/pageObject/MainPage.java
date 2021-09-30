package pageObject;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.iOSXCUITFindBy;
import io.qameta.allure.Step;

public class MainPage extends BasePage {

    public MainPage(AppiumDriver<MobileElement> driver) {
        super(driver);
    }

    @AndroidFindBy(id = "com.belongtail.belong:id/text_view_minidash_header")
    @iOSXCUITFindBy()
    protected MobileElement userName;
    @AndroidFindBy(id = "com.belongtail.belong:id/layout_belongers_cell")
    @iOSXCUITFindBy()
    protected MobileElement myFeedButton;
    @AndroidFindBy(id = "com.belongtail.belong:id/layout_binder_cell")
    @iOSXCUITFindBy()
    protected MobileElement filesButton;
    @AndroidFindBy(id = "com.belongtail.belong:id/layout_treatment_cell")
    @iOSXCUITFindBy()
    protected MobileElement treatmentButton;
    @AndroidFindBy(id = "com.belongtail.belong:id/layout_saved_disc_cell")
    @iOSXCUITFindBy()
    protected MobileElement inboxButton;
    @AndroidFindBy(id = "android:id/button1")
    @iOSXCUITFindBy()
    protected MobileElement continueButton;
    @AndroidFindBy(id = "com.belongtail.belong:id/search_src_text")
    @iOSXCUITFindBy()
    protected MobileElement searchField;


    @Step("Return the user name")
    public String userName() {
        return getText(userName);
    }

    @Step("Click on the button from the menu")
    public void clickOnButtonFromMenu(String option) {
        switch (option) {
            case "My Feed":
                click(myFeedButton);
                click(continueButton);
                break;
            case "Files":
                click(filesButton);
                break;
            case "Treatment":
                click(treatmentButton);
                break;
            case "Inbox":
                click(inboxButton);
                break;
        }
    }

    @Step("Type in search field")
    public void typeInSearchField(String value) {
        click(searchField);
        fillText(searchField, value);
        clickEnter();
    }
}
