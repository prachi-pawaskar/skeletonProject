package com.prachi.project.skeletonProject.lib;

/**
 * Created by prachi.pawaskar on 27-June-2016.
 */

import com.gargoylesoftware.htmlunit.BrowserVersion;
import com.gargoylesoftware.htmlunit.WebClient;
import com.prachi.project.skeletonProject.enumPackage.SupportedBrowser;
import org.apache.log4j.Logger;
import org.openqa.selenium.Capabilities;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxProfile;
import org.openqa.selenium.firefox.internal.ProfilesIni;
import org.openqa.selenium.htmlunit.HtmlUnitDriver;
//import org.openqa.selenium.phantomjs.PhantomJSDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;

import java.io.File;
import java.util.concurrent.TimeUnit;

/**
 * This class holds browser driver set up functions.
 */

public class UiSetUp extends Base {
    //Logger defined for class, logs created as per log4j.properties
    private static Logger log = Logger.getLogger(UiSetUp.class);

    //Staring the driver and hitting UI url
//    @BeforeClass
    public static void startDriver()  throws Exception{
        log.info("Starting web driver");
        if (BROWSER.equalsIgnoreCase(SupportedBrowser.firefox.name()) || (BROWSER == null || BROWSER == "")){
            log.info("UI test running on Firefox browser.");

//            ProfilesIni listProfiles = new ProfilesIni();
//            FirefoxProfile profile = listProfiles.getProfile("default");
//            driver = new FirefoxDriver(profile);

            driver = new FirefoxDriver();
            driver.manage().window().maximize();
            //Adding implicit wait in seconds.
            driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);

            //Get browser version
            Capabilities cap = ((RemoteWebDriver) driver).getCapabilities();
            String browserVersion = cap.getVersion().toString();
            extent.addSystemInfo("Browser Version",browserVersion);
        }
        else if(BROWSER.equalsIgnoreCase(SupportedBrowser.chrome.name()))
        {
            log.info("UI test running on Chrome browser.");

            String resourceFilePath = "src/main/java/com/prachi/project/skeletonProject/drivers/";
            String resourceURL = new File(resourceFilePath).getAbsolutePath();
            System.setProperty("webdriver.chrome.driver", resourceURL +"/chromedriver.exe");
            driver = new ChromeDriver();
            driver.manage().window().maximize();

            //Adding implicit wait in seconds.
            driver.manage().timeouts().implicitlyWait(90, TimeUnit.SECONDS);

            //Get browser version
            Capabilities cap = ((RemoteWebDriver) driver).getCapabilities();
            String browserVersion = cap.getVersion().toString();
            extent.addSystemInfo("Browser Version",browserVersion);
        }
        else if(BROWSER.equalsIgnoreCase(SupportedBrowser.ie.name()))
        {
            log.info("UI test running on IE browser.");

            String resourceFilePath = "src/main/java/com/prachi/project/skeletonProject/drivers/";
            String resourceURL = new File(resourceFilePath).getAbsolutePath();
            System.setProperty("webdriver.ie.driver", resourceURL +"/IEDriverServer.exe");
            DesiredCapabilities capabilities = DesiredCapabilities.internetExplorer();
            capabilities.setCapability("requireWindowFocus", true);
            driver = new InternetExplorerDriver(capabilities);
            driver.manage().window().maximize();

            //Adding implicit wait in seconds.
            driver.manage().timeouts().implicitlyWait(90, TimeUnit.SECONDS);

            //Get browser version
            Capabilities cap = ((RemoteWebDriver) driver).getCapabilities();
            String browserVersion = cap.getVersion().toString();
            extent.addSystemInfo("Browser Version",browserVersion);
        }
//        else if(BROWSER.equalsIgnoreCase(SupportedBrowser.HtmlUnitDriver.name()))
//        {
//            log.info("UI test running on headless HtmlUnitDriver browser.");
//            DesiredCapabilities capability = DesiredCapabilities.htmlUnit();
//            capability.setJavascriptEnabled(true);
//            capability.setBrowserName("htmlunit");
//            capability.setVersion("internet explorer");
//            capability.setPlatform(org.openqa.selenium.Platform.ANY);
//
//            driver = new HtmlUnitDriver(capability);
//
//
//            //Adding implicit wait in seconds.
//            driver.manage().timeouts().implicitlyWait(120, TimeUnit.SECONDS);
//        }



        //Get screen resolution
        String browserSize = String.valueOf(driver.manage().window().getSize());
        extent.addSystemInfo("Screen Resolution",browserSize);

    }

    //Stop the driver
//    @AfterClass
    public static void stopDriver() throws Exception{
        //To close all browser windows
        driver.close();
        //To stop driver process in background
        try{
        driver.quit();}
        catch (Exception e){
            //Do nothing.
        }
    }
}
