package tests;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import screens.HomeScreen;
import screens.LoginScreen;

public class SignUpTest extends BaseTest{


    @BeforeMethod
    public void preparing_loginScreen(){
        HomeScreen homescreen= getHomescreen();
        homescreen.titleDisplayed();
        homescreen.clickbutton(homescreen.getLogin_button());

    }
    @Test
    public void SigningUp(){

        //going to the login screen

        LoginScreen loginscreen=getLoginScreen();
        loginscreen.titleDisplayed();
        loginscreen.clickbutton(loginscreen.getSignUp_button());
        loginscreen.write_SignUp_info();
        loginscreen.clickbutton(loginscreen.getSigningUp_button());
        loginscreen.verification_SignUp();



    }
}
