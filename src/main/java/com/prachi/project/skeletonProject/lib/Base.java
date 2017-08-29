package com.prachi.project.skeletonProject.lib;

/**
 * Created by prachi.pawaskar on 27-June-2016.
 */

import com.prachi.project.skeletonProject.enumPackage.SupportedBrowser;
import com.prachi.project.skeletonProject.enumPackage.SupportedEnv;
import com.prachi.project.skeletonProject.enumPackage.SupportedTag;
import com.prachi.project.skeletonProject.keywords.FunctionalKeywords;
import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;
import com.relevantcodes.extentreports.ReporterType;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Parameters;

import java.io.*;
import java.lang.reflect.Method;
import java.math.BigInteger;
import java.security.SecureRandom;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Properties;

/**
 * This class holds functions to set global configs like env URLs, username password etc.
 */

public class Base {
    //Logger defined for class, logs created as per log4j.properties
    private static org.apache.log4j.Logger log = org.apache.log4j.Logger.getLogger(Base.class);

    //Variables
    public static String ENV = System.getProperty("env"),
            BROWSER = System.getProperty("browser"),
            TAG = System.getProperty("tag"),
            LOGINROLE = System.getProperty("loginRole");

    // Extend reports and test variable
    public static ExtentReports extent;
    public static ExtentTest etest;

    // Report html created under /reports/*
    private static long millis = System.currentTimeMillis();
    public static String reportLocation = "reports/detailTestReport_" +  millis + ".html";

    public static String url, username, password, gt_url,manifestService_baseUrl,manifestService_uri,raps_username,raps_password;
    public static String defaultLoginRole;


    //Webdriver variables for UI
    public static WebDriver driver;

    @BeforeSuite
    @Parameters({ "env","browser","tag","loginRole" })
    public static void setUpBrowser(String env, String browser,String tag, String loginRole) throws Exception {
        //Command to delete system %TEMP% files
        log.info("Deleting system temp files");
        Runtime.getRuntime().exec("cmd /c rd /s /q %temp%");

        //Set Env, browser and Tag
        setDefaultENV(env,browser,tag,loginRole);
        //Set credentials as env
        setDefaultCredentials();

        //Initialize extend reports
        extent = new ExtentReports(reportLocation, true);
        extent.startReporter(ReporterType.DB, (new File(reportLocation)).getParent() + File.separator + "extent.db");
        extent.addSystemInfo("Log File","applog.log");
        extent.addSystemInfo("Browser",BROWSER);

        extent.addSystemInfo("Environment",ENV);
//        extent.addSystemInfo("Test Group",TAG);
        extent.addSystemInfo("Login Role",LOGINROLE);

        log.info("Report location: " + reportLocation);


    }

    @AfterSuite
    public static void setDown() throws Exception {

    }

    private static void setDefaultCredentials() throws IOException {
        try {
            log.info("Reading envDetails.properties file to set the credentials.");
            String propFileName = "src/main/resources/envConfig/" + ENV +"/envDetails.properties";
            log.info("Relative path: " + propFileName);
            String propFile = new File(propFileName).getAbsolutePath();
            log.info("Absolute path: " + propFile);
            Properties prop = new Properties();
            InputStream input = new FileInputStream(propFile);
            // load a properties file
            prop.load(input);

            log.info("Reading data from envDetails.properties file!");
            //Retrieve value from prop file
            url = prop.getProperty("url").toString();
            log.info("Env URL: " + url);

            username = prop.getProperty("leadArchivist_username").toString();
            log.info("username: " + username);

            password = prop.getProperty("leadArchivist_password").toString();
            log.info("username: " + password);


        } catch (Exception e){
            log.error("Following exception in returning property value: " + e.toString());
        }
    }


    public static void setDefaultENV(String env, String browser, String tag, String loginRole)  throws Exception{
        //If testng parameter for env is blank, default is qa_red
        if (env == null || env == "") {env = SupportedEnv.qa.name();}
        //If mvn parameter for env is blank, default is qa_red
        if (ENV == null || ENV == "") {ENV = env;}
        log.info("Env running on: " +ENV);
//        extent.addSystemInfo("Environment",ENV);

        //If testng parameter for browser is blank, default is firefox
        if (browser == null || browser == "") {browser = SupportedBrowser.firefox.name();}
        //If mvn parameter for browser is blank, default is firefox
        if (BROWSER == null || BROWSER == "") {BROWSER = browser;}
        log.info("UI running on: "+ BROWSER);
//        extent.addSystemInfo("Browser: ",browser);

        //If testng parameter for tag is blank, default is regression
        if (tag == null || tag == "") {tag = SupportedTag.regression.name();}
        //If mvn parameter for env is blank, default is qa_red
        if (TAG == null || TAG == "") {TAG = tag;}
        log.info("Active Tag: " +TAG);
//        extent.addSystemInfo("Active tag: ",TAG);

        //If testng parameter for loginRole is blank, default is leadArchivist
        if (loginRole == null || loginRole == "") {loginRole = "username";}
        //If mvn parameter for env is blank, default is qa_red
        if (LOGINROLE == null || LOGINROLE == "") {LOGINROLE = loginRole;}
        log.info("Active loginRole: " +loginRole);
    }

    //Method to read value from properties file.
    public static String getUiValue(String lookingForValue) throws IOException {
        String returnedValue = null;
        try {
            String propFile = null;
            propFile = "src/main/java/com/prachi/project/skeletonProject/objectRepo/uiObject.properties";
            Properties prop = new Properties();
            InputStream input = new FileInputStream(propFile);
            // load a properties file
            prop.load(input);
            //Retrieve value from prop file
            returnedValue = prop.getProperty(lookingForValue).toString();
        }
        catch (Exception e){
            log.error("Following exception in returning property value: " + e.toString());
        }
        return returnedValue;
    }

    public static String getTextValue(String lookingForValue) throws IOException {
        String returnedValue = null;
        try {
            String propFile = null;
            propFile = "src/main/java/com/prachi/project/skeletonProject/objectRepo/textObject.properties";
            Properties prop = new Properties();
            InputStream input = new FileInputStream(propFile);
            // load a properties file
            prop.load(input);
            //Retrieve value from prop file
            returnedValue = prop.getProperty(lookingForValue).toString();
        }
        catch (Exception e){
            log.error("Following exception in returning property value: " + e.toString());
        }
        return returnedValue;
    }

    //Method to read value from properties file.
    public static String getEnvValue(String lookingForValue) throws IOException {
        String returnedValue = null;
        try {
            String propFile = null;
            propFile = "src/main/resources/envConfig/" + ENV +"/envDetails.properties";
            Properties prop = new Properties();
            InputStream input = new FileInputStream(propFile);
            // load a properties file
            prop.load(input);
            //Retrieve value from prop file
            returnedValue = prop.getProperty(lookingForValue).toString();
        }
        catch (Exception e){
            log.error("Following exception in returning property value: " + e.toString());
        }
        return returnedValue;
    }

    //Method to take screenshot for report
    public static String takeScreenshot(){
        String imageLocation = null;
        String imageName = "reportImage_" + getRandomString();
        // Take screenshot and store as a file format
        File src= ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
        try {
            //Get test script data to read.
            String resourceImageFilePath = "reports/reportImages/";
            String resourceImageURL = new File(resourceImageFilePath).getAbsolutePath();
            // now copy the  screenshot to desired location using copyFile //method
            FileUtils.copyFile(src, new File(resourceImageURL +"\\"+ imageName+".png"));
            imageLocation = resourceImageURL +"\\" + imageName+".png";
        }
        catch (IOException e)
        {
            log.error("Error in capturing screenshot: " + e);
        }
        return imageLocation;
    }

    // Generate random string
    public static String getRandomString()  {
        final class RandomGenerator {
            private SecureRandom random = new SecureRandom();

            public String randomString() {
                return new BigInteger(130, random).toString(32);
            }
        }
        return new RandomGenerator().randomString();
    }

    public static Object[][] getFileNames(String assetJourney) throws IOException {
        List<String> listFileNames = new ArrayList<String>();
        List<String> listISBN = new ArrayList<String>();

        log.info("Scanning CSV to find active files for use case to use!");

        String csvFile = "src/main/resources/testData/" + assetJourney + ".csv";

        //Reading Active script names
        BufferedReader br = null;
        String line = "";
        String cvsSplitBy = ",";
        br = new BufferedReader(new FileReader(csvFile));

        while ((line = br.readLine()) != null) {
            if (line.startsWith("#")){
                //Don't read the line, it's a comment
            } else {
                Object[] active = line.split(cvsSplitBy);
                if (active[0].toString().equalsIgnoreCase("active")) {
                    listFileNames.add(active[1].toString());
                    listISBN.add(active[2].toString());
                }
            }
        }

        Object[][] data = new Object[listFileNames.size()][2];
        //initialize data
        for(int i=0; i<listFileNames.size();i++){
            data[i][0] = listFileNames.get(i);
            data[i][1] = listISBN.get(i);
        }
        return data;
    }

    public static Object[][] getTestDataDetails(String assetJourney) throws IOException {
        log.info("Scanning CSV to find active files for use case to use!");

        String csvFile = "src/main/resources/testData/" + assetJourney + ".csv";

        //Reading Active script names
        BufferedReader br = null;
        String line = "";
        String cvsSplitBy = ",";
        br = new BufferedReader(new FileReader(csvFile));

        ArrayList<ArrayList<String>> md = new ArrayList<ArrayList<String>>();
        Object[] active = null;


        while ((line = br.readLine()) != null) {
            if (line.startsWith("#")){
                //Don't read the line, it's a comment
            } else {
                active = line.split(cvsSplitBy);
                if (active[0].toString().equalsIgnoreCase("active")) {
                    ArrayList<String> row = new ArrayList<String>();
                    for(int i=1;i<active.length;i++){
                        row.add(active[i].toString());
                    }
                    md.add(row);
                }
            }
        }
        Object[][] data = new Object[md.size()][active.length-1];
        //initialize data
        int index=0;
        for(ArrayList<String> r : md){
            for(int i=0;i<r.size();i++){
                data[index][i] = r.get(i).toString();
            }
            ++index;
        }
        return data;
    }

}
