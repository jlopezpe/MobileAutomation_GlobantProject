package tests;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.options.UiAutomator2Options;
import org.testng.annotations.BeforeMethod;
import screens.*;

import java.io.FileInputStream;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.Properties;
//import static sun.awt.FontConfiguration.loadProperties;

public class BaseTest {

    private static final String PROPERTIES_FILE="src/test/resources/config.properties";
    private static final Properties properties= new Properties();

    public static AndroidDriver driver;

    @BeforeMethod(alwaysRun = true)
    public void environmentSetUp(){
        loadProperties();
        UiAutomator2Options capabilities= new UiAutomator2Options();
        setUpCapabilities(capabilities);

        try{
            driver=new AndroidDriver(new URL("http://127.0.0.1:4723"),capabilities);
        }
        catch (MalformedURLException exception){
            System.out.println(exception.getMessage());
        }

    }

    public void loadProperties(){
        try{
            FileInputStream fileInputStream=new FileInputStream(PROPERTIES_FILE);
            properties.load(fileInputStream);
        }
        catch (IOException e){
            throw new RuntimeException("Error loading properties"+PROPERTIES_FILE);
        }
    }

    public static void setUpCapabilities(UiAutomator2Options capabilities){

        capabilities.setPlatformName(getCapability("platformName"));
        capabilities.setDeviceName(getCapability("deviceName"));
        capabilities.setAppPackage(getCapability("appPackage"));
        capabilities.setAppActivity(getCapability("appActivity"));
    }

    public static String getCapability(String variable){
        return properties.getProperty(variable);
    }

    public HomeScreen getHomescreen(){
        return new HomeScreen(driver);
    }

    public WebviewScreen getWebviewScreen(){
        return new WebviewScreen(driver);
    }

    public LoginScreen getLoginScreen(){
        return new LoginScreen(driver);
    }

    public FormsScreen getFormScreen(){
        return new FormsScreen(driver);
    }

    public SwipeScreen getSwipeScreen(){
        return new SwipeScreen(driver);
    }

    public DragScreen getDragScreen(){
        return new DragScreen(driver);
    }






}
