package tests;

import io.appium.java_client.android.AndroidDriver;
import org.testng.Assert;
import org.testng.annotations.Test;
import screens.*;

public class Navigate_ButtonTest extends BaseTest{

    @Test
    public void Navigate(){

        HomeScreen homescreen= getHomescreen();
        homescreen.titleDisplayed();
        homescreen.clickbutton(homescreen.getWebview_button());

        WebviewScreen webviewscreen= getWebviewScreen();
        webviewscreen.titleDisplayed();
        webviewscreen.clickbutton(webviewscreen.getLogin_button());

        LoginScreen loginscreen= getLoginScreen();
        loginscreen.titleDisplayed();
        loginscreen.clickbutton((loginscreen.getForms_button()));

        FormsScreen formcomponents= getFormScreen();
        formcomponents.titleDisplayed();
        formcomponents.clickbutton((formcomponents.getSwipe_button()));

        SwipeScreen swipescreen= getSwipeScreen();
        swipescreen.titleDisplayed();
        swipescreen.clickbutton((swipescreen.getDrag_button()));

        DragScreen dragscreen= getDragScreen();
        dragscreen.titleDisplayed();


    }
}
