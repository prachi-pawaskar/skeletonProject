package com.prachi.project.skeletonProject;

import com.prachi.project.skeletonProject.keywords.FunctionalKeywords;
import com.prachi.project.skeletonProject.lib.Base;
import com.prachi.project.skeletonProject.lib.UiSetUp;
import com.relevantcodes.extentreports.LogStatus;
import org.apache.log4j.Logger;
import org.testng.annotations.*;

import java.io.IOException;
import java.lang.reflect.Method;
import java.util.List;



/**
 * Created by prachi.pawaskar on 17-10-2016.
 */
public class ApiValidation extends Base {

    //Logger defined for class, logs created as per log4j.properties
    private static Logger log = Logger.getLogger(ApiValidation.class);

    @BeforeClass
    public static void classSetUp() throws Exception {
        UiSetUp.startDriver();

        //Login to CMS
        //Prints the test case name and info to report
        etest = extent.startTest("Test Script: Login");
        etest.log(LogStatus.INFO, "Test Script 'Login' is running.");

         //End the login case
        extent.endTest(etest);
        extent.flush();



    }

    @AfterClass
    public static void classSetDown() throws Exception {
        //Logout of CMS
        //User log out
        //Prints the test case name and info to report
        etest = extent.startTest("Test Script: Logout");
        etest.log(LogStatus.INFO, "Test Script 'Logout' is running.");



        //End the login case
        extent.endTest(etest);
        extent.flush();

        UiSetUp.stopDriver();

        //Command to delete system %TEMP% files
        log.info("Deleting system temp files");
        Runtime.getRuntime().exec("cmd /c rd /s /q %temp%");
    }


    @BeforeMethod
    public static void testSetUp(Method testMethod) throws IOException, InterruptedException {

    }

    @AfterMethod
    public static void testSetDown() throws IOException, InterruptedException {
        extent.endTest(etest);
        extent.flush();
    }


    @DataProvider(name = "sampleDataCSV")
    private static Object[][] sampleDataCSV(Method m) throws IOException {
        return getTestDataDetails("sampleDataCSV");

    }


    @Test(dataProvider = "sampleDataCSV",enabled = true, priority = 0)
    public static void sampleDataCSVTest(String filename, String isbn) throws Exception {
        //Prints the test case name and info to report
        etest = extent.startTest("Test Script: assetManifestService, File: " + filename);
        etest.log(LogStatus.INFO, "Test Script: assetManifestService, File: '" + filename +"' is running.");

        etest.log(LogStatus.INFO, "*************************** sampleDataCSVTest running for File: " + filename);
        log.info("*************************** sampleDataCSVTest running for File: " + filename);
        //Call common function to ingest


    }



}
