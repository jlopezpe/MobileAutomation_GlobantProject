package tests;

import io.appium.java_client.android.AndroidDriver;
import org.testng.annotations.Test;
import screens.HomeScreen;

public class Navigate_ButtonTest extends BaseTest{

    @Test
    public void Navigate(){

        HomeScreen homescreen= getHomescreen();
    }
}
