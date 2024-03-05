package tests;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import screens.HomeScreen;
import screens.LoginScreen;

public class LoginTest extends BaseTest{

    @BeforeMethod
    public void preparingNew_Login(){
        HomeScreen homescreen= getHomescreen();
        //homescreen.titleDisplayed();
        homescreen.clickbutton(homescreen.getLogin_button());

        LoginScreen loginscreen=getLoginScreen();
        //loginscreen.titleDisplayed();
        loginscreen.clickbutton(loginscreen.getSignUp_button());
        loginscreen.write_SignUp_info();
        loginscreen.clickbutton(loginscreen.getSigningUp_button());
        //loginscreen.verification_SignUp();
        loginscreen.clickbutton(loginscreen.getGetAlertOk_button());
    }
    @Test
    public void login(){

        //after the sign up, go the login section where the data is already written
        //click login button

        LoginScreen loginScreen=getLoginScreen();
        loginScreen.clickbutton(loginScreen.getLoginButton_writefields());
        loginScreen.titleDisplayed();
        loginScreen.waitElementVisibility(driver,loginScreen.getLoginButton_action());
        loginScreen.clickbutton(loginScreen.getLoginButton_action());
        loginScreen.verifyLogin();
        loginScreen.clickbutton(loginScreen.getGetAlertOk_button());

    }

}
