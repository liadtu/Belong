package belongCancerApp.test;

import belongCancerApp.pageObject.MainPage;
import belongCancerApp.pageObject.ResultPage;
import belongCancerApp.pageObject.topMenu.FilesPage;
import belongCancerApp.pageObject.topMenu.InboxPage;
import belongCancerApp.pageObject.topMenu.MyFeedPage;
import belongCancerApp.pageObject.topMenu.TreatmentPage;
import io.qameta.allure.Description;
import org.testng.Assert;
import org.testng.annotations.Test;

public class MainTest extends BaseTest {

    @Test(priority = 1, description = "Top menu feature")
    @Description("Check that the icons in the top menu are working properly")
    public void topMenuFeature() {
        MainPage mainPage = new MainPage(driver);

        //Enter to My Feed screen
        mainPage.clickOnButtonFromMenu("My Feed");
        MyFeedPage myFeedPage = new MyFeedPage(driver);
        //Check that the user enter to my feed screen
        Assert.assertEquals(myFeedPage.myFeedTitle(), "Personal profile");
        // Save and back to main screen
        myFeedPage.clickOnButton("Save button");

        //Enter to Files screen
        mainPage.clickOnButtonFromMenu("Files");
        FilesPage filesPage = new FilesPage(driver);
        //Check that the user enter to my files screen
        Assert.assertEquals(filesPage.filesTitle(), "My Files");
        //Back to main screen
        filesPage.clickOnBackButton();

        //Enter to Treatment screen
        mainPage.clickOnButtonFromMenu("Treatment");
        TreatmentPage treatmentPage = new TreatmentPage(driver);
        //Agree the treatment terms
        treatmentPage.clickOnTreatmentTermsPopupButton("I AGREE");
        //Check that the user enter to treatment screen
        Assert.assertEquals(treatmentPage.treatmentTitle(), "Liadtobi");
        //Back to main screen
        treatmentPage.clickOnBackButton();

        //Enter to Inbox screen
        mainPage.clickOnButtonFromMenu("Inbox");
        InboxPage inboxPage = new InboxPage(driver);
        //Check that the user enter to my files screen
        Assert.assertEquals(inboxPage.inboxTitle(),"Inbox");
        //Back to main screen
        inboxPage.clickOnBackButton();

        //Check that the user return to main screen
        Assert.assertEquals(mainPage.userName(),"Hi Liadtobi");
    }

    @Test(priority = 2, description = "Hide post")
    @Description("Search value in the search field, " +
            "hide post from the results " +
            "and check that the post is not displayed")
    public void searchField(){
        MainPage mainPage = new MainPage(driver);
        //Type in search field
        mainPage.typeInSearchField("cancer");
        ResultPage resultPage = new ResultPage(driver);
        //Save the post text before hide
        String postTextBeforeHide = resultPage.postText();
        //Save the post time before hide
        String postTimeBeforeHide = resultPage.postTime();
        //Hide the post
        resultPage.hidePost();
        //Choose reason from the list
        resultPage.clickInReason("POST CONTENT IS UNPLEASANT");
        //Save the post text after hide
        String postTextAfterHide = resultPage.postText();
        //Save the post time after hide
        String postTimeAfterHide = resultPage.postTime();

        Assert.assertNotEquals(postTextBeforeHide,postTextAfterHide);
        Assert.assertNotEquals(postTimeBeforeHide,postTimeAfterHide);
    }
}