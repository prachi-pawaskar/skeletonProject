package com.prachi.project.skeletonProject.lib;

/**
 * Created by prachi.pawaskar on 27-June-2016.
 */

import com.prachi.project.skeletonProject.enumPackage.SupportedBrowser;
import com.relevantcodes.extentreports.LogStatus;
import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.awt.*;
import java.awt.datatransfer.StringSelection;
import java.awt.event.KeyEvent;
import java.io.IOException;
import java.lang.reflect.Method;
import java.net.URL;
import java.net.URLDecoder;
import java.util.*;
import java.util.List;
import java.util.concurrent.TimeUnit;
import java.util.regex.Pattern;

import static com.prachi.project.skeletonProject.lib.Base.*;


/**
 * This class holds wrapper functions for selenium actions.
 */

public class UiKeywords {

    //Logger defined for class, logs created as per log4j.properties
    private static Logger log = Logger.getLogger(UiKeywords.class);

    private static Boolean isTextDisplayed = false;

    public static void sendKeysToElement(String elementType, String elementValue, String data,Boolean needObjectMap) throws IOException {
        String rawElementValue = null;
        try{
            if(needObjectMap == true){
             rawElementValue = Base.getUiValue(elementValue);}
            else {
                rawElementValue = elementValue;
            }
            log.info("Sending keys to element: " + rawElementValue + " of type: "+ elementType);
            log.info("Keys sending to element: " + data);

            if (elementType.equalsIgnoreCase("class")) {
                driver.findElement(By.className(rawElementValue)).sendKeys(data);
            }
            if (elementType.equalsIgnoreCase("xpath")) {
                driver.findElement(By.xpath(rawElementValue)).sendKeys(data);
            }
            if (elementType.equalsIgnoreCase("id")) {
                driver.findElement(By.id(rawElementValue)).sendKeys(data);
            }
            if (elementType.equalsIgnoreCase("tagName")) {
                driver.findElement(By.tagName(rawElementValue)).sendKeys(data);
            }
            if (elementType.equalsIgnoreCase("name")) {
                driver.findElement(By.name(rawElementValue)).sendKeys(data);
            }
            if (elementType.equalsIgnoreCase("linkText")) {
                driver.findElement(By.linkText(rawElementValue)).sendKeys(data);
            }
            if (elementType.equalsIgnoreCase("partialLinkText")) {
                driver.findElement(By.partialLinkText(rawElementValue)).sendKeys(data);
            }
            if (elementType.equalsIgnoreCase("css")) {
                driver.findElement(By.cssSelector(rawElementValue)).sendKeys(data);
            }
            etest.log(LogStatus.INFO, "Keys sent to element successfully: " + data);
        } catch (Exception e){
            log.error(e);
            log.error("Error in executing keyword: sendKeysToElement");
            etest.log(LogStatus.ERROR, "Error in executing keyword: sendKeysToElement");
            etest.log(LogStatus.FAIL, "Failed in executing keyword: sendKeysToElement");
            String image = etest.addScreenCapture(takeScreenshot());
            etest.log(LogStatus.FAIL,"Image:" + image);
        }
    }

    public static void clearElement(String elementType, String elementValue, Boolean needObjectMap) throws IOException {
        String rawElementValue = null;
        try{
            if(needObjectMap == true){
                rawElementValue = Base.getUiValue(elementValue);}
            else {
                rawElementValue = elementValue;
            }
            log.info("Clear element: " + rawElementValue + " of type: "+ elementType);

            if (elementType.equalsIgnoreCase("class")) {
                driver.findElement(By.className(rawElementValue)).clear();
            }
            if (elementType.equalsIgnoreCase("xpath")) {
                driver.findElement(By.xpath(rawElementValue)).clear();
            }
            if (elementType.equalsIgnoreCase("id")) {
                driver.findElement(By.id(rawElementValue)).clear();
            }
            if (elementType.equalsIgnoreCase("tagName")) {
                driver.findElement(By.tagName(rawElementValue)).clear();
            }
            if (elementType.equalsIgnoreCase("name")) {
                driver.findElement(By.name(rawElementValue)).clear();
            }
            if (elementType.equalsIgnoreCase("linkText")) {
                driver.findElement(By.linkText(rawElementValue)).clear();
            }
            if (elementType.equalsIgnoreCase("partialLinkText")) {
                driver.findElement(By.partialLinkText(rawElementValue)).clear();
            }
            if (elementType.equalsIgnoreCase("css")) {
                driver.findElement(By.cssSelector(rawElementValue)).clear();
            }
            etest.log(LogStatus.INFO, "Cleared element successfully");
        } catch (Exception e){
            log.error(e);
            log.error("Error in executing keyword: clearElement");
            etest.log(LogStatus.ERROR, "Error in executing keyword: clearElement");
            etest.log(LogStatus.FAIL, "Failed in executing keyword: clearElement");
            String image = etest.addScreenCapture(takeScreenshot());
            etest.log(LogStatus.FAIL,"Image:" + image);
        }
    }

    public static void navigateToUrl(String urlTogo){
        try{
            log.info("Navigating to URL: " + urlTogo);
            driver.get(urlTogo);
            etest.log(LogStatus.INFO, "Navigated to URL successfully: " + urlTogo);
        } catch (Exception e){
            log.error(e);
            log.error("Error in executing keyword: navigateToUrl");
            etest.log(LogStatus.ERROR, "Error in executing keyword: navigateToUrl");
            etest.log(LogStatus.FAIL, "Failed in executing keyword: navigateToUrl");
            String image = etest.addScreenCapture(takeScreenshot());
            etest.log(LogStatus.FAIL,"Image:" + image);
        }
    }

    public static void clickElement(String elementType, String elementValue,Boolean needObjectMap) throws IOException, InterruptedException {

        //Wait for the element to load before clicking it
        waitUntilElementLoads(elementType,elementValue,needObjectMap);
        String rawElementValue = null;
        try{

            if(needObjectMap == true){
                rawElementValue = Base.getUiValue(elementValue);}
            else {
                rawElementValue = elementValue;
            }
            log.info("Clicking element: " + rawElementValue + " of type: "+ elementType);

            if (elementType.equalsIgnoreCase("class")) {
                driver.findElement(By.className(rawElementValue)).click();
            }
            if (elementType.equalsIgnoreCase("xpath")) {
                driver.findElement(By.xpath(rawElementValue)).click();
            }
            if (elementType.equalsIgnoreCase("id")) {
                driver.findElement(By.id(rawElementValue)).click();
            }
            if (elementType.equalsIgnoreCase("tagName")) {
                driver.findElement(By.tagName(rawElementValue)).click();
            }
            if (elementType.equalsIgnoreCase("name")) {
                driver.findElement(By.name(rawElementValue)).click();
            }
            if (elementType.equalsIgnoreCase("linkText")) {
                driver.findElement(By.linkText(rawElementValue)).click();
            }
            if (elementType.equalsIgnoreCase("partialLinkText")) {
                driver.findElement(By.partialLinkText(rawElementValue)).click();
            }
            if (elementType.equalsIgnoreCase("css")) {
                driver.findElement(By.cssSelector(rawElementValue)).click();
            }
            etest.log(LogStatus.INFO, "Clicked element: " + rawElementValue + " of type: "+ elementType + " successfully");
        } catch (Exception e){
            log.error(e);
            log.error("Error in executing keyword: clickElement");
            etest.log(LogStatus.ERROR, "Error in executing keyword: clickElement");
            etest.log(LogStatus.FAIL, "Failed in executing keyword: clickElement");
            String image = etest.addScreenCapture(takeScreenshot());
            etest.log(LogStatus.FAIL,"Image:" + image);
        }
        //Wait after click action
        Thread.sleep(2000);
    }

    public static void navigateBack() throws InterruptedException {
        log.info("Navigating back");
        try{
            driver.navigate().back();
            etest.log(LogStatus.INFO, "Navigating to back page.");
        } catch (Exception e){
            log.error(e);
            log.error("Error in executing keyword: navigateBack");
            etest.log(LogStatus.ERROR, "Error in executing keyword: navigateBack");
            etest.log(LogStatus.FAIL, "Failed in executing keyword: navigateBack");
            String image = etest.addScreenCapture(takeScreenshot());
            etest.log(LogStatus.FAIL,"Image:" + image);
        }
        //Wait after click action
        Thread.sleep(2000);
    }


    public static void refreshPage() throws InterruptedException {
        log.info("Refreshing page");
        try{
            driver.navigate().refresh();
            etest.log(LogStatus.INFO, "Page refreshed.");
        } catch (Exception e){
            log.error(e);
            log.error("Error in executing keyword: refreshPage");
            etest.log(LogStatus.ERROR, "Error in executing keyword: refreshPage");
            etest.log(LogStatus.FAIL, "Failed in executing keyword: refreshPage");
            String image = etest.addScreenCapture(takeScreenshot());
            etest.log(LogStatus.FAIL,"Image:" + image);
        }
        //Wait after click action
        Thread.sleep(2000);
    }

    public static Boolean elementShouldBeVisible(String elementType, String elementValue,Boolean needObjectMap) throws IOException{

        try{
            if (BROWSER.equalsIgnoreCase(SupportedBrowser.firefox.name())){
                driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
            }
            else if(BROWSER.equalsIgnoreCase(SupportedBrowser.chrome.name())){
                driver.manage().timeouts().implicitlyWait(6, TimeUnit.SECONDS);
            }
            else if (BROWSER.equalsIgnoreCase(SupportedBrowser.ie.name())){
                driver.manage().timeouts().implicitlyWait(9, TimeUnit.SECONDS);
            }
            else if (BROWSER.equalsIgnoreCase(SupportedBrowser.HtmlUnitDriver.name())){
                driver.manage().timeouts().implicitlyWait(120, TimeUnit.SECONDS);
            }
        } catch (Exception e){
            log.error(e);
            log.error("Error in execution: Setting Timeout");
            etest.log(LogStatus.ERROR, "Error in execution: Setting Timeout");
            etest.log(LogStatus.FAIL, "Failed in execution: Setting Timeout");
        }
        String rawElementValue = null;
        try{
            if(needObjectMap == true){
                rawElementValue = Base.getUiValue(elementValue);}
            else {
                rawElementValue = elementValue;
            }
        } catch (Exception e){
            log.error(e);
            log.error("Error in executing keyword: elementShouldBeVisible");
            etest.log(LogStatus.ERROR, "Error in executing keyword: elementShouldBeVisible");
            etest.log(LogStatus.FAIL, "Failed in executing keyword: elementShouldBeVisible");
            String image = etest.addScreenCapture(takeScreenshot());
            etest.log(LogStatus.FAIL,"Image:" + image);
        }
        Boolean isDisplayed = false;
        log.info("Verifying element: " + rawElementValue + " of type: "+ elementType + " is visible or not");
        try{
            if (elementType.equalsIgnoreCase("class")) {
                isDisplayed = driver.findElement(By.className(rawElementValue)).isDisplayed();
            }
            if (elementType.equalsIgnoreCase("xpath")) {
                isDisplayed = driver.findElement(By.xpath(rawElementValue)).isDisplayed();
            }
            if (elementType.equalsIgnoreCase("id")) {
                isDisplayed = driver.findElement(By.id(rawElementValue)).isDisplayed();
            }
            if (elementType.equalsIgnoreCase("tagName")) {
                isDisplayed = driver.findElement(By.tagName(rawElementValue)).isDisplayed();
            }
            if (elementType.equalsIgnoreCase("name")) {
                isDisplayed = driver.findElement(By.name(rawElementValue)).isDisplayed();
            }
            if (elementType.equalsIgnoreCase("linkText")) {
                isDisplayed = driver.findElement(By.linkText(rawElementValue)).isDisplayed();
            }
            if (elementType.equalsIgnoreCase("partialLinkText")) {
                isDisplayed = driver.findElement(By.partialLinkText(rawElementValue)).isDisplayed();
            }
            if (elementType.equalsIgnoreCase("css")) {
                isDisplayed = driver.findElement(By.cssSelector(rawElementValue)).isDisplayed();
            }
            etest.log(LogStatus.INFO, "Verified element: " + rawElementValue + " of type: "+ elementType + " is visible or not");
        } catch (Exception e){
//            if(Thread.currentThread().getStackTrace()[2].getMethodName().startsWith("cleanUp") ||
//                    Thread.currentThread().getStackTrace()[2].getMethodName().equalsIgnoreCase("deleteMultipleEntry")||
//                    Thread.currentThread().getStackTrace()[2].getMethodName().equalsIgnoreCase("verifyValidationFolder")||
//                    Thread.currentThread().getStackTrace()[2].getMethodName().equalsIgnoreCase("verifyHoldingPenFolder")||
//                    Thread.currentThread().getStackTrace()[2].getMethodName().equalsIgnoreCase("goToHoldingPen") ||
//                    Thread.currentThread().getStackTrace()[2].getMethodName().equalsIgnoreCase("isArchiveFolderSuccessful")||
//                    Thread.currentThread().getStackTrace()[2].getMethodName().equalsIgnoreCase("verifyValidationFolderIsEmpty")||
//                    Thread.currentThread().getStackTrace()[2].getMethodName().equalsIgnoreCase("verifyValidationFolderIsEmptyForZip")||
//                    Thread.currentThread().getStackTrace()[2].getMethodName().equalsIgnoreCase("verifyHoldingPenFolderForZip")||
//                    Thread.currentThread().getStackTrace()[2].getMethodName().equalsIgnoreCase("verifyValidationFolderForZip")||
//                    Thread.currentThread().getStackTrace()[2].getMethodName().equalsIgnoreCase("isArchiveFolderSuccessful_Shared")){
//                //If clean script is calling this assertion do not return exception
//                // As clean up queue can be empty
//            }
//            else{
                log.error(e);
                log.error("Error in executing keyword: elementShouldBeVisible");
                etest.log(LogStatus.ERROR, "Error in executing keyword: elementShouldBeVisible");
                etest.log(LogStatus.FAIL, "Failed in executing keyword: elementShouldBeVisible");
//            }
        }
//        if(Thread.currentThread().getStackTrace()[2].getMethodName().startsWith("cleanUp")  ||
//                Thread.currentThread().getStackTrace()[2].getMethodName().equalsIgnoreCase("deleteMultipleEntry")||
//                Thread.currentThread().getStackTrace()[2].getMethodName().equalsIgnoreCase("verifyValidationFolder")||
//                Thread.currentThread().getStackTrace()[2].getMethodName().equalsIgnoreCase("verifyHoldingPenFolder")||
//                Thread.currentThread().getStackTrace()[2].getMethodName().equalsIgnoreCase("goToHoldingPen")||
//                Thread.currentThread().getStackTrace()[2].getMethodName().equalsIgnoreCase("isArchiveFolderSuccessful")||
//                Thread.currentThread().getStackTrace()[2].getMethodName().equalsIgnoreCase("verifyValidationFolderIsEmpty")||
//                Thread.currentThread().getStackTrace()[2].getMethodName().equalsIgnoreCase("verifyValidationFolderIsEmptyForZip")||
//                Thread.currentThread().getStackTrace()[2].getMethodName().equalsIgnoreCase("verifyHoldingPenFolderForZip")||
//                Thread.currentThread().getStackTrace()[2].getMethodName().equalsIgnoreCase("verifyValidationFolderForZip")||
//                Thread.currentThread().getStackTrace()[2].getMethodName().equalsIgnoreCase("isArchiveFolderSuccessful_Shared")){
//            //If clean script is calling this assertion do not return exception
//            // As clean up queue can be empty
//        }
//        else{
            //Performing assertions
            if (isDisplayed == true) {
                log.info("Actual: \'" + rawElementValue + "\' is visible");
                log.info("Test Passed: Element visible");
                etest.log(LogStatus.PASS, "Element: " + rawElementValue + " of type: "+ elementType + " is visible.");
            }else
            {
                log.info("Actual: \'" + rawElementValue + "\' is not visible");
                log.info("Test Failed: Element not visible");
                etest.log(LogStatus.FAIL, "Element: " + rawElementValue + " of type: "+ elementType + " is not visible.");
                String image = etest.addScreenCapture(takeScreenshot());
                etest.log(LogStatus.FAIL,"Image:" + image);
            }
//        }

        try{
            if (BROWSER.equalsIgnoreCase(SupportedBrowser.firefox.name())){
                driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
            }
            else if(BROWSER.equalsIgnoreCase(SupportedBrowser.chrome.name())){
                driver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
            }
            else if (BROWSER.equalsIgnoreCase(SupportedBrowser.ie.name())){
                driver.manage().timeouts().implicitlyWait(90, TimeUnit.SECONDS);
            }
            else if (BROWSER.equalsIgnoreCase(SupportedBrowser.HtmlUnitDriver.name())){
                driver.manage().timeouts().implicitlyWait(120, TimeUnit.SECONDS);
            }
        } catch (Exception e){
            log.error(e);
            log.error("Error in execution: Timeout");
            etest.log(LogStatus.ERROR, "Error in execution: Timeout");
            etest.log(LogStatus.FAIL, "Failed in execution: Timeout");
        }
        return isDisplayed;
    }

    public static Boolean isElementVisible(String elementType, String elementValue,Boolean needObjectMap) throws IOException{

        try{
            if (BROWSER.equalsIgnoreCase(SupportedBrowser.firefox.name())){
                driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
            }
            else if(BROWSER.equalsIgnoreCase(SupportedBrowser.chrome.name())){
                driver.manage().timeouts().implicitlyWait(6, TimeUnit.SECONDS);
            }
            else if (BROWSER.equalsIgnoreCase(SupportedBrowser.ie.name())){
                driver.manage().timeouts().implicitlyWait(9, TimeUnit.SECONDS);
            }
            else if (BROWSER.equalsIgnoreCase(SupportedBrowser.HtmlUnitDriver.name())){
                driver.manage().timeouts().implicitlyWait(120, TimeUnit.SECONDS);
            }
        } catch (Exception e){
            log.error(e);
            log.error("Error in execution: Setting Timeout");
            etest.log(LogStatus.ERROR, "Error in execution: Setting Timeout");
            etest.log(LogStatus.FAIL, "Failed in execution: Setting Timeout");
        }
        String rawElementValue = null;
        try{
        if(needObjectMap == true){
            rawElementValue = Base.getUiValue(elementValue);}
        else {
            rawElementValue = elementValue;
        }
        } catch (Exception e){
            log.error(e);
            log.error("Error in executing keyword: isElementVisible");
            etest.log(LogStatus.ERROR, "Error in executing keyword: isElementVisible");
            etest.log(LogStatus.FAIL, "Failed in executing keyword: isElementVisible");
            String image = etest.addScreenCapture(takeScreenshot());
            etest.log(LogStatus.FAIL,"Image:" + image);
        }
        Boolean isDisplayed = false;
        log.info("Verifying element: " + rawElementValue + " of type: "+ elementType + " is visible or not");
        try{
            if (elementType.equalsIgnoreCase("class")) {
                isDisplayed = driver.findElement(By.className(rawElementValue)).isDisplayed();
            }
            if (elementType.equalsIgnoreCase("xpath")) {
                isDisplayed = driver.findElement(By.xpath(rawElementValue)).isDisplayed();
            }
            if (elementType.equalsIgnoreCase("id")) {
                isDisplayed = driver.findElement(By.id(rawElementValue)).isDisplayed();
            }
            if (elementType.equalsIgnoreCase("tagName")) {
                isDisplayed = driver.findElement(By.tagName(rawElementValue)).isDisplayed();
            }
            if (elementType.equalsIgnoreCase("name")) {
                isDisplayed = driver.findElement(By.name(rawElementValue)).isDisplayed();
            }
            if (elementType.equalsIgnoreCase("linkText")) {
                isDisplayed = driver.findElement(By.linkText(rawElementValue)).isDisplayed();
            }
            if (elementType.equalsIgnoreCase("partialLinkText")) {
                isDisplayed = driver.findElement(By.partialLinkText(rawElementValue)).isDisplayed();
            }
            if (elementType.equalsIgnoreCase("css")) {
                isDisplayed = driver.findElement(By.cssSelector(rawElementValue)).isDisplayed();
            }
            etest.log(LogStatus.INFO, "Verified element: " + rawElementValue + " of type: "+ elementType + " is visible or not");
        } catch (Exception e){
                //If clean script is calling this assertion do not return exception
                // As clean up queue can be empty
        }

        try{
            if (BROWSER.equalsIgnoreCase(SupportedBrowser.firefox.name())){
                driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
            }
            else if(BROWSER.equalsIgnoreCase(SupportedBrowser.chrome.name())){
                driver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
            }
            else if (BROWSER.equalsIgnoreCase(SupportedBrowser.ie.name())){
                driver.manage().timeouts().implicitlyWait(90, TimeUnit.SECONDS);
            }
            else if (BROWSER.equalsIgnoreCase(SupportedBrowser.HtmlUnitDriver.name())){
                driver.manage().timeouts().implicitlyWait(120, TimeUnit.SECONDS);
            }
        } catch (Exception e){
            log.error(e);
            log.error("Error in execution: Timeout");
            etest.log(LogStatus.ERROR, "Error in execution: Timeout");
            etest.log(LogStatus.FAIL, "Failed in execution: Timeout");
        }
        return isDisplayed;
    }


    public static Boolean elementShouldNotBeVisible(String elementType, String elementValue,Boolean needObjectMap) throws IOException{

        try{
            if (BROWSER.equalsIgnoreCase(SupportedBrowser.firefox.name())){
            driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
            }
            else if(BROWSER.equalsIgnoreCase(SupportedBrowser.chrome.name())){
                driver.manage().timeouts().implicitlyWait(6, TimeUnit.SECONDS);
            }
            else if (BROWSER.equalsIgnoreCase(SupportedBrowser.ie.name())){
                driver.manage().timeouts().implicitlyWait(9, TimeUnit.SECONDS);
            }
            else if (BROWSER.equalsIgnoreCase(SupportedBrowser.HtmlUnitDriver.name())){
                driver.manage().timeouts().implicitlyWait(120, TimeUnit.SECONDS);
            }
        } catch (Exception e){
            log.error(e);
            log.error("Error in execution: Setting Timeout");
            etest.log(LogStatus.ERROR, "Error in execution: Setting Timeout");
            etest.log(LogStatus.FAIL, "Failed in execution: Setting Timeout");
        }

        String rawElementValue = null;
        try{
        if(needObjectMap == true){
            rawElementValue = Base.getUiValue(elementValue);}
        else {
            rawElementValue = elementValue;
        }
        } catch (Exception e){
            log.error(e);
            log.error("Error in executing keyword: elementShouldNotBeVisible");
            etest.log(LogStatus.ERROR, "Error in executing keyword: elementShouldNotBeVisible");
            etest.log(LogStatus.FAIL, "Failed in executing keyword: elementShouldNotBeVisible");
            String image = etest.addScreenCapture(takeScreenshot());
            etest.log(LogStatus.FAIL,"Image:" + image);
        }
        Boolean isDisplayed = false;
        log.info("Verifying element: " + rawElementValue + " of type: "+ elementType + " is not displayed");
        try{
            if (elementType.equalsIgnoreCase("class")) {
                isDisplayed = driver.findElement(By.className(rawElementValue)).isDisplayed();
            }
            if (elementType.equalsIgnoreCase("xpath")) {
                isDisplayed = driver.findElement(By.xpath(rawElementValue)).isDisplayed();
            }
            if (elementType.equalsIgnoreCase("id")) {
                isDisplayed = driver.findElement(By.id(rawElementValue)).isDisplayed();
            }
            if (elementType.equalsIgnoreCase("tagName")) {
                isDisplayed = driver.findElement(By.tagName(rawElementValue)).isDisplayed();
            }
            if (elementType.equalsIgnoreCase("name")) {
                isDisplayed = driver.findElement(By.name(rawElementValue)).isDisplayed();
            }
            if (elementType.equalsIgnoreCase("linkText")) {
                isDisplayed = driver.findElement(By.linkText(rawElementValue)).isDisplayed();
            }
            if (elementType.equalsIgnoreCase("partialLinkText")) {
                isDisplayed = driver.findElement(By.partialLinkText(rawElementValue)).isDisplayed();
            }
            if (elementType.equalsIgnoreCase("css")) {
                isDisplayed = driver.findElement(By.cssSelector(rawElementValue)).isDisplayed();
            }
            etest.log(LogStatus.INFO, "Verified element: " + rawElementValue + " of type: "+ elementType + " is not displayed");
        } catch (Exception e){
            //Do nothing as exception is expected

        }
            //Performing assertions
            if (isDisplayed == true) {
                log.info("Actual: \'" + rawElementValue + "\' is visible");
                log.info("Test Failed: Element visible");
                etest.log(LogStatus.FAIL, "Element: " + rawElementValue + " of type: "+ elementType + " is visible.");
                String image = etest.addScreenCapture(takeScreenshot());
                etest.log(LogStatus.FAIL,"Image:" + image);
            }else
            {
                log.info("Actual: \'" + rawElementValue + "\' is not visible");
                log.info("Test Passed: Element not visible as expected");
                etest.log(LogStatus.PASS, "Element: " + rawElementValue + " of type: "+ elementType + " is not visible as expected.");
            }
        try{
            if (BROWSER.equalsIgnoreCase(SupportedBrowser.firefox.name())){
                driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
            }
            else if(BROWSER.equalsIgnoreCase(SupportedBrowser.chrome.name())){
                driver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
            }
            else if (BROWSER.equalsIgnoreCase(SupportedBrowser.ie.name())){
                driver.manage().timeouts().implicitlyWait(90, TimeUnit.SECONDS);
            }
            else if (BROWSER.equalsIgnoreCase(SupportedBrowser.HtmlUnitDriver.name())){
                driver.manage().timeouts().implicitlyWait(120, TimeUnit.SECONDS);
            }
        } catch (Exception e){
            log.error(e);
            log.error("Error in execution: Setting Timeout");
            etest.log(LogStatus.ERROR, "Error in execution: Setting Timeout");
            etest.log(LogStatus.FAIL, "Failed in execution: Setting Timeout");
        }
        return isDisplayed;
    }


    public static Boolean elementShouldBeSelected(String elementType, String elementValue,Boolean needObjectMap) throws IOException{

        String rawElementValue = null;
        Boolean isSelected = false;
        try{
            if(needObjectMap == true){
                rawElementValue = Base.getUiValue(elementValue);}
            else {
                rawElementValue = elementValue;
            }
            log.info("Verifying element: " + rawElementValue + " of type: "+ elementType + " is selected or not");

            if (elementType.equalsIgnoreCase("class")) {
                isSelected = driver.findElement(By.className(rawElementValue)).isSelected();
            }
            if (elementType.equalsIgnoreCase("xpath")) {
                isSelected = driver.findElement(By.xpath(rawElementValue)).isSelected();
            }
            if (elementType.equalsIgnoreCase("id")) {
                isSelected = driver.findElement(By.id(rawElementValue)).isSelected();
            }
            if (elementType.equalsIgnoreCase("tagName")) {
                isSelected = driver.findElement(By.tagName(rawElementValue)).isSelected();
            }
            if (elementType.equalsIgnoreCase("name")) {
                isSelected = driver.findElement(By.name(rawElementValue)).isSelected();
            }
            if (elementType.equalsIgnoreCase("linkText")) {
                isSelected = driver.findElement(By.linkText(rawElementValue)).isSelected();
            }
            if (elementType.equalsIgnoreCase("partialLinkText")) {
                isSelected = driver.findElement(By.partialLinkText(rawElementValue)).isSelected();
            }
            if (elementType.equalsIgnoreCase("css")) {
                isSelected = driver.findElement(By.cssSelector(rawElementValue)).isSelected();
            }
            etest.log(LogStatus.INFO, "Verified element: " + rawElementValue + " of type: "+ elementType + " is selected or not");
        } catch (Exception e){
                log.error(e);
                log.error("Error in executing keyword: elementShouldBeSelected");
                etest.log(LogStatus.ERROR, "Error in executing keyword: elementShouldBeSelected");
                etest.log(LogStatus.FAIL, "Failed in executing keyword: elementShouldBeSelected");
        }
        //Performing assertions
        if (isSelected == true) {
             log.info("Actual: \'" + rawElementValue + "\' is selected");
            log.info("Test Passed: Element is selected");
            etest.log(LogStatus.PASS, "Element: " + rawElementValue + " of type: "+ elementType + " is selected.");
        }else
        {
            log.info("Actual: \'" + rawElementValue + "\' is not selected");
            log.info("Test Failed: Element is not selected");
            etest.log(LogStatus.FAIL, "Element: " + rawElementValue + " of type: "+ elementType + " is not selected.");
            String image = etest.addScreenCapture(takeScreenshot());
            etest.log(LogStatus.FAIL,"Image:" + image);
        }

        return isSelected;
    }

    public static Boolean elementShouldNotBeSelected(String elementType, String elementValue,Boolean needObjectMap) throws IOException{

        String rawElementValue = null;
        Boolean isSelected = false;
        try{
            if(needObjectMap == true){
                rawElementValue = Base.getUiValue(elementValue);}
            else {
                rawElementValue = elementValue;
            }

            log.info("Verifying element: " + rawElementValue + " of type: "+ elementType + " is selected or not");

            if (elementType.equalsIgnoreCase("class")) {
                isSelected = driver.findElement(By.className(rawElementValue)).isSelected();
            }
            if (elementType.equalsIgnoreCase("xpath")) {
                isSelected = driver.findElement(By.xpath(rawElementValue)).isSelected();
            }
            if (elementType.equalsIgnoreCase("id")) {
                isSelected = driver.findElement(By.id(rawElementValue)).isSelected();
            }
            if (elementType.equalsIgnoreCase("tagName")) {
                isSelected = driver.findElement(By.tagName(rawElementValue)).isSelected();
            }
            if (elementType.equalsIgnoreCase("name")) {
                isSelected = driver.findElement(By.name(rawElementValue)).isSelected();
            }
            if (elementType.equalsIgnoreCase("linkText")) {
                isSelected = driver.findElement(By.linkText(rawElementValue)).isSelected();
            }
            if (elementType.equalsIgnoreCase("partialLinkText")) {
                isSelected = driver.findElement(By.partialLinkText(rawElementValue)).isSelected();
            }
            if (elementType.equalsIgnoreCase("css")) {
                isSelected = driver.findElement(By.cssSelector(rawElementValue)).isSelected();
            }
            etest.log(LogStatus.INFO, "Verified element: " + rawElementValue + " of type: "+ elementType + " is selected or not");
        } catch (Exception e){
            log.error(e);
            log.error("Error in executing keyword: elementShouldNotBeSelected");
            etest.log(LogStatus.ERROR, "Error in executing keyword: elementShouldNotBeSelected");
            etest.log(LogStatus.FAIL, "Failed in executing keyword: elementShouldNotBeSelected");
        }
        //Performing assertions
        if (isSelected == false) {
            log.info("Actual: \'" + rawElementValue + "\' is not selected");
            log.info("Test Passed: Element is not selected as expected");
            etest.log(LogStatus.PASS, "Element: " + rawElementValue + " of type: "+ elementType + " is not selected as expected.");
        }else
        {
            log.info("Actual: \'" + rawElementValue + "\' is selected");
            log.info("Test Failed: Element is selected");
            etest.log(LogStatus.FAIL, "Element: " + rawElementValue + " of type: "+ elementType + " is selected.");
            String image = etest.addScreenCapture(takeScreenshot());
            etest.log(LogStatus.FAIL,"Image:" + image);
        }

        return isSelected;
    }


    public static Boolean textShouldBeVisible(String elementType, String elementValue, String data, Boolean needObjectMapForData, Boolean needObjectMapForElement) throws IOException {

        String actualText = null;
        String rawElementValue = null;
        String expectedData = null;
        try{
            //Read raw element value
            if(needObjectMapForElement == true){
                rawElementValue = Base.getUiValue(elementValue);}
            else {
                rawElementValue = elementValue;
            }

            //Read raw text value
            if(needObjectMapForData == true){
                expectedData = getTextValue(data);
            } else {
                expectedData = data;
            }

            if (elementType.equalsIgnoreCase("class")) {
                actualText = driver.findElement(By.className(rawElementValue)).getText().trim();
            }
            if (elementType.equalsIgnoreCase("xpath")) {
                actualText = driver.findElement(By.xpath(rawElementValue)).getText().trim();
            }
            if (elementType.equalsIgnoreCase("id")) {
                actualText = driver.findElement(By.id(rawElementValue)).getText().trim();
            }
            if (elementType.equalsIgnoreCase("tagName")) {
                actualText = driver.findElement(By.tagName(rawElementValue)).getText().trim();
            }
            if (elementType.equalsIgnoreCase("name")) {
                actualText = driver.findElement(By.name(rawElementValue)).getText().trim();
            }
            if (elementType.equalsIgnoreCase("linkText")) {
                actualText = driver.findElement(By.linkText(rawElementValue)).getText().trim();
            }
            if (elementType.equalsIgnoreCase("partialLinkText")) {
                actualText = driver.findElement(By.partialLinkText(rawElementValue)).getText().trim();
            }
            if (elementType.equalsIgnoreCase("css")) {
                actualText = driver.findElement(By.cssSelector(rawElementValue)).getText().trim();
            }
            etest.log(LogStatus.INFO, "Reading data from element: " + rawElementValue + " is successful.");
        } catch (Exception e) {
            log.error(e);
            log.error("Error in executing keyword: textShouldBeVisible");
            etest.log(LogStatus.ERROR, "Error in executing keyword: textShouldBeVisible");
            etest.log(LogStatus.FAIL, "Fail in executing keyword: textShouldBeVisible");
        }

        try{
            //Assertions
            isTextDisplayed = actualText.equals(expectedData);}
        catch (Exception e){
            log.error("Exception in assertion: " + e);
        }

        //Logging test expected and actual
        log.info("Expected: \'" + expectedData + "\' to be visible for element \'" + rawElementValue + "\'");

        //Performing assertions
        if (isTextDisplayed == true) {
            log.info("Actual: \'" + expectedData + "\' is visible for element \'" + rawElementValue + "\'");
            log.info("Test Passed: Element text is visible");
            etest.log(LogStatus.PASS, "Text Visibility check for " + "\'" + expectedData + "\' , \n" + "Text \'" + expectedData + "\'" + " is visible on UI for element \'" + rawElementValue + "\'");
        }else
        {
            log.info("Actual: \'" + data + "\' is not visible");
            log.info("Test Failed: Element text is not visible");
            etest.log(LogStatus.FAIL, "Text Visibility check for " + "\'" + expectedData + "\', \n" + "Text \'" +expectedData +"\'" + " is not visible on UI for element \'" + rawElementValue + "\'" );
            String image = etest.addScreenCapture(takeScreenshot());
            etest.log(LogStatus.FAIL,"Image:" + image);
        }

        return isTextDisplayed;
    }

    public static Boolean isTextShouldBeVisible(String elementType, String elementValue, String data, Boolean needObjectMapForData, Boolean needObjectMapForElement) throws IOException {

        String actualText = null;
        String rawElementValue = null;
        String expectedData = null;
        try{
            //Read raw element value
            if(needObjectMapForElement == true){
                rawElementValue = Base.getUiValue(elementValue);}
            else {
                rawElementValue = elementValue;
            }

            //Read raw text value
            if(needObjectMapForData == true){
                expectedData = getTextValue(data);
            } else {
                expectedData = data;
            }

            if (elementType.equalsIgnoreCase("class")) {
                actualText = driver.findElement(By.className(rawElementValue)).getText().trim();
            }
            if (elementType.equalsIgnoreCase("xpath")) {
                actualText = driver.findElement(By.xpath(rawElementValue)).getText().trim();
            }
            if (elementType.equalsIgnoreCase("id")) {
                actualText = driver.findElement(By.id(rawElementValue)).getText().trim();
            }
            if (elementType.equalsIgnoreCase("tagName")) {
                actualText = driver.findElement(By.tagName(rawElementValue)).getText().trim();
            }
            if (elementType.equalsIgnoreCase("name")) {
                actualText = driver.findElement(By.name(rawElementValue)).getText().trim();
            }
            if (elementType.equalsIgnoreCase("linkText")) {
                actualText = driver.findElement(By.linkText(rawElementValue)).getText().trim();
            }
            if (elementType.equalsIgnoreCase("partialLinkText")) {
                actualText = driver.findElement(By.partialLinkText(rawElementValue)).getText().trim();
            }
            if (elementType.equalsIgnoreCase("css")) {
                actualText = driver.findElement(By.cssSelector(rawElementValue)).getText().trim();
            }
            etest.log(LogStatus.INFO, "Reading data from element: " + rawElementValue + " is successful.");
        } catch (Exception e) {
            log.error(e);
            log.error("Error in executing keyword: isTextShouldBeVisible");
            etest.log(LogStatus.ERROR, "Error in executing keyword: isTextShouldBeVisible");
            etest.log(LogStatus.FAIL, "Fail in executing keyword: isTextShouldBeVisible");
        }

        try{
            //Assertions
            isTextDisplayed = actualText.equals(expectedData);}
        catch (Exception e){
            log.error("Exception in assertion: " + e);
        }


        return isTextDisplayed;
    }


    public static Boolean textShouldMatch(String elementType, String elementValue, String data, Boolean needObjectMapForData, Boolean needObjectMapForElement) throws IOException {

        String actualText = null;
        String rawElementValue = null;
        String expectedData = null;
        try{
        //Read raw element value
            if(needObjectMapForElement == true){
                rawElementValue = Base.getUiValue(elementValue);}
            else {
                rawElementValue = elementValue;
            }

            //Read raw text value
            if(needObjectMapForData == true){
                expectedData = getTextValue(data);
            } else {
                expectedData = data;
            }

            if (elementType.equalsIgnoreCase("class")) {
                actualText = driver.findElement(By.className(rawElementValue)).getText().trim();
            }
            if (elementType.equalsIgnoreCase("xpath")) {
                actualText = driver.findElement(By.xpath(rawElementValue)).getText().trim();
            }
            if (elementType.equalsIgnoreCase("id")) {
                actualText = driver.findElement(By.id(rawElementValue)).getText().trim();
            }
            if (elementType.equalsIgnoreCase("tagName")) {
                actualText = driver.findElement(By.tagName(rawElementValue)).getText().trim();
            }
            if (elementType.equalsIgnoreCase("name")) {
                actualText = driver.findElement(By.name(rawElementValue)).getText().trim();
            }
            if (elementType.equalsIgnoreCase("linkText")) {
                actualText = driver.findElement(By.linkText(rawElementValue)).getText().trim();
            }
            if (elementType.equalsIgnoreCase("partialLinkText")) {
                actualText = driver.findElement(By.partialLinkText(rawElementValue)).getText().trim();
            }
            if (elementType.equalsIgnoreCase("css")) {
                actualText = driver.findElement(By.cssSelector(rawElementValue)).getText().trim();
            }
            etest.log(LogStatus.INFO, "Reading data from element: " + rawElementValue + " is successful.");
        } catch (Exception e) {
            log.error(e);
            log.error("Error in executing keyword: textShouldMatch");
            etest.log(LogStatus.ERROR, "Error in executing keyword: textShouldMatch");
            etest.log(LogStatus.FAIL, "Fail in executing keyword: textShouldMatch");
        }

        try{
            //Assertions
            isTextDisplayed = Pattern.matches(expectedData,actualText);}
//                    actualText.contains(expectedData);}
        catch (Exception e){
            log.error("Exception in assertion: " + e);
        }

        //Logging test expected and actual
        log.info("Expected: \'" + expectedData + "\' to be match for element \'" + rawElementValue + "\'");

        //Performing assertions
        if (isTextDisplayed == true) {
            log.info("Actual: \'" + expectedData + "\' is matched for element \'" + rawElementValue + "\'");
            log.info("Test Passed: Element text is visible");
            etest.log(LogStatus.PASS, "Text Visibility check for " + "\'" + expectedData + "\' , \n" + "Text \'" + expectedData + "\'" + " is visible on UI for element \'" + rawElementValue + "\'");
        }else
        {
            log.info("Actual: \'" + data + "\' is not visible");
            log.info("Test Failed: Element text is not visible");
            etest.log(LogStatus.FAIL, "Text Visibility check for " + "\'" + expectedData + "\', \n" + "Text \'" +expectedData +"\'" + " is not visible on UI for element \'" + rawElementValue + "\'" );
            String image = etest.addScreenCapture(takeScreenshot());
            etest.log(LogStatus.FAIL,"Image:" + image);
        }

        return isTextDisplayed;
    }

    public static Boolean textShouldContain(String elementType, String elementValue, String data, Boolean needObjectMapForData, Boolean needObjectMapForElement) throws IOException {

        String actualText = null;
        String rawElementValue = null;
        String expectedData = null;
        try{
            //Read raw element value
            if(needObjectMapForElement == true){
                rawElementValue = Base.getUiValue(elementValue);}
            else {
                rawElementValue = elementValue;
            }
            //Read raw text value

            if(needObjectMapForData == true){
                expectedData = getTextValue(data);
            } else {
                expectedData = data;
            }
            if (elementType.equalsIgnoreCase("class")) {
                actualText = driver.findElement(By.className(rawElementValue)).getText().trim();
            }
            if (elementType.equalsIgnoreCase("xpath")) {
                actualText = driver.findElement(By.xpath(rawElementValue)).getText().trim();
            }
            if (elementType.equalsIgnoreCase("id")) {
                actualText = driver.findElement(By.id(rawElementValue)).getText().trim();
            }
            if (elementType.equalsIgnoreCase("tagName")) {
                actualText = driver.findElement(By.tagName(rawElementValue)).getText().trim();
            }
            if (elementType.equalsIgnoreCase("name")) {
                actualText = driver.findElement(By.name(rawElementValue)).getText().trim();
            }
            if (elementType.equalsIgnoreCase("linkText")) {
                actualText = driver.findElement(By.linkText(rawElementValue)).getText().trim();
            }
            if (elementType.equalsIgnoreCase("partialLinkText")) {
                actualText = driver.findElement(By.partialLinkText(rawElementValue)).getText().trim();
            }
            if (elementType.equalsIgnoreCase("css")) {
                actualText = driver.findElement(By.cssSelector(rawElementValue)).getText().trim();
            }
            etest.log(LogStatus.INFO, "Reading data from element: " + rawElementValue + " is successful.");
        } catch (Exception e) {
            log.error(e);
            log.error("Error in executing keyword: textShouldContain");
            etest.log(LogStatus.ERROR, "Error in executing keyword: textShouldContain");
            etest.log(LogStatus.FAIL, "Fail in executing keyword: textShouldContain");
        }

        try{
            //Assertions
//            isTextDisplayed = Pattern.matches(expectedData,actualText);
            isTextDisplayed = actualText.contains(expectedData);
        }
//                    actualText.contains(expectedData);}
        catch (Exception e){
            log.error("Exception in assertion: " + e);
        }

        //Logging test expected and actual
        log.info("Expected: \'" + expectedData + "\' to be match for element \'" + rawElementValue + "\'");

        //Performing assertions
        if (isTextDisplayed == true) {
            log.info("Actual: \'" + expectedData + "\' is matched for element \'" + rawElementValue + "\'");
            log.info("Test Passed: Element text is visible");
            etest.log(LogStatus.PASS, "Text Visibility check for " + "\'" + expectedData + "\' , \n" + "Text \'" + expectedData + "\'" + " is visible on UI for element \'" + rawElementValue + "\'");
        }else
        {
            log.info("Actual: \'" + data + "\' is not visible");
            log.info("Test Failed: Element text is not visible");
            etest.log(LogStatus.FAIL, "Text Visibility check for " + "\'" + expectedData + "\', \n" + "Text \'" +expectedData +"\'" + " is not visible on UI for element \'" + rawElementValue + "\'" );
            String image = etest.addScreenCapture(takeScreenshot());
            etest.log(LogStatus.FAIL,"Image:" + image);
        }

        return isTextDisplayed;
    }

    public static String returnElementText(String elementType, String elementValue, Boolean needObjectMapForElement) throws IOException {

        String actualText = null;
        String rawElementValue = null;
        try{
            //Read raw element value
            if(needObjectMapForElement == true){
                rawElementValue = Base.getUiValue(elementValue);}
            else {
                rawElementValue = elementValue;
            }

            if (elementType.equalsIgnoreCase("class")) {
                actualText = driver.findElement(By.className(rawElementValue)).getText().trim();
            }
            if (elementType.equalsIgnoreCase("xpath")) {
                actualText = driver.findElement(By.xpath(rawElementValue)).getText().trim();
            }
            if (elementType.equalsIgnoreCase("id")) {
                actualText = driver.findElement(By.id(rawElementValue)).getText().trim();
            }
            if (elementType.equalsIgnoreCase("tagName")) {
                actualText = driver.findElement(By.tagName(rawElementValue)).getText().trim();
            }
            if (elementType.equalsIgnoreCase("name")) {
                actualText = driver.findElement(By.name(rawElementValue)).getText().trim();
            }
            if (elementType.equalsIgnoreCase("linkText")) {
                actualText = driver.findElement(By.linkText(rawElementValue)).getText().trim();
            }
            if (elementType.equalsIgnoreCase("partialLinkText")) {
                actualText = driver.findElement(By.partialLinkText(rawElementValue)).getText().trim();
            }
            if (elementType.equalsIgnoreCase("css")) {
                actualText = driver.findElement(By.cssSelector(rawElementValue)).getText().trim();
            }
            etest.log(LogStatus.INFO, "Reading data from element: " + rawElementValue + " is successful.");
        } catch (Exception e) {
            log.error(e);
            log.error("Error in executing keyword: returnElementText");
            etest.log(LogStatus.ERROR, "Error in executing keyword: returnElementText");
            etest.log(LogStatus.FAIL, "Fail in executing keyword: returnElementText");
        }


        return actualText;
    }


    public static void urlShouldBeLoaded(String checkType, String expectedTypeValue,Boolean needObjectMap) throws IOException {
        String actualValue = null;
        Boolean isComponentPresent = false;
        String rawExpectedTypeValue = null;
        try{
            if(needObjectMap == true){
                rawExpectedTypeValue = Base.getUiValue(expectedTypeValue);}
            else {
                rawExpectedTypeValue = expectedTypeValue;
            }

            //Get the current URL
            URL aURL = new URL(driver.getCurrentUrl());

            //"By" based on <objectType> value
            if (checkType.equalsIgnoreCase("protocol")) {
                actualValue = aURL.getProtocol();
            }
            if (checkType.equalsIgnoreCase("authority")) {
                actualValue = aURL.getAuthority();
            }
            if (checkType.equalsIgnoreCase("host")) {
                actualValue = aURL.getHost();
            }
            if (checkType.equalsIgnoreCase("port")) {
                actualValue = String.valueOf(aURL.getPort());
            }
            if (checkType.equalsIgnoreCase("path")) {
                actualValue = aURL.getPath();
            }
            if (checkType.equalsIgnoreCase("query")) {
                actualValue = aURL.getQuery();
            }
            if (checkType.equalsIgnoreCase("filename")) {
                actualValue = aURL.getFile();
            }
            if (checkType.equalsIgnoreCase("ref")) {
                actualValue = aURL.getRef();
            }
            etest.log(LogStatus.INFO, "Reading data of checkType: " + checkType + " is successful.");
        } catch (Exception e){
            log.error(e);
            log.error("Error in executing keyword: urlShouldBeLoaded");
            etest.log(LogStatus.ERROR, "Error in executing keyword: urlShouldBeLoaded");
            etest.log(LogStatus.FAIL, "Fail in executing keyword: urlShouldBeLoaded");
        }

        try {
            //Decode url component for safety
            if (actualValue == null && rawExpectedTypeValue == null) {
                //Don't assert when actual and expected are null
                isComponentPresent = true;
            } else {
                actualValue = URLDecoder.decode(actualValue, "UTF-8");

                //Assertions
                isComponentPresent = actualValue.equals(rawExpectedTypeValue);
            }
        }catch (Exception e){
            log.error("Exception in assertion: " + e);
        }

        //Logging test expected and actual
        log.info("Expected: \'" + rawExpectedTypeValue + "\' to be present in URL");

        //Performing assertions
        if (isComponentPresent == true) {
            log.info("Actual: \'" + rawExpectedTypeValue + "\' is present in URL");
            log.info("Test Passed: Value present in URL");
            etest.log(LogStatus.PASS, "Component check on URL for" + "\'" + rawExpectedTypeValue + "\' , \n" + "\'" + rawExpectedTypeValue + "\'" + " is present in URL");
        }else
        {
            log.info("Actual: \'" + rawExpectedTypeValue + "\' is not present in URL");
            log.info("Test Failed: Value is not present in URL");
            etest.log(LogStatus.FAIL, "Component check on URL for" +  rawExpectedTypeValue  + "\' , \n" + "\'" + rawExpectedTypeValue + "\'" + " is not present in URL");
            String image = etest.addScreenCapture(takeScreenshot());
            etest.log(LogStatus.FAIL,"Image:" + image);
        }
    }

    public static void robotClicks(String key){
        try{
            etest.log(LogStatus.INFO, "Performing keyboard action for key: " + key);
            Robot robot=new Robot();
            Thread.sleep(2000);
            if(key.equalsIgnoreCase("escape")){
                robot.keyPress(KeyEvent.VK_ESCAPE);
//                robot.keyRelease(KeyEvent.VK_ENTER);
                Thread.sleep(6000);
            }
            log.info("Performed keyboard action for key: " + key);
            etest.log(LogStatus.INFO, "Performed keyboard action for key: " + key);
        }catch (Exception e){
            log.error(e);
            log.error("Error in executing keyword: robotClicks");
            etest.log(LogStatus.ERROR, "Error in executing keyword: robotClicks");
            etest.log(LogStatus.FAIL, "Fail in executing keyword: robotClicks");
        }
    }

    public static void uploadFunction(String fileLocation, String elementValue,Boolean needObjectMap ) throws AWTException, InterruptedException, IOException {
        String rawElementValue = null;
        try{
            if(needObjectMap == true){
                rawElementValue = Base.getUiValue(elementValue);}
            else {
                rawElementValue = elementValue;
            }

            etest.log(LogStatus.INFO, "Uploading File: " + fileLocation);
            WebElement element= driver.findElement(By.xpath(rawElementValue));
            element.sendKeys(fileLocation);
//            StringSelection s=new StringSelection(fileLocation);
//            Toolkit.getDefaultToolkit().getSystemClipboard().setContents(s,null);
//            Robot robot=new Robot();
//            robot.keyPress(java.awt.event.KeyEvent.VK_ENTER);
//            robot.keyRelease(java.awt.event.KeyEvent.VK_ENTER);
//            robot.keyPress(java.awt.event.KeyEvent.VK_CONTROL);
//            robot.keyPress(java.awt.event.KeyEvent.VK_V);
//            robot.keyRelease(java.awt.event.KeyEvent.VK_V);
//            robot.keyRelease(java.awt.event.KeyEvent.VK_CONTROL);
//            Thread.sleep(5000);
//            robot.keyPress(java.awt.event.KeyEvent.VK_ENTER);
//            robot.keyRelease(java.awt.event.KeyEvent.VK_ENTER);
//            Thread.sleep(5000);
            log.info("Uploaded File: " + fileLocation);
            etest.log(LogStatus.INFO, "Uploaded File: " + fileLocation);
        }catch (Exception e){
            log.error(e);
            log.error("Error in executing keyword: uploadFunction");
            etest.log(LogStatus.ERROR, "Error in executing keyword: uploadFunction");
            etest.log(LogStatus.FAIL, "Fail in executing keyword: uploadFunction");
        }
    }

    public static void waitForMilliSeconds(int waitTime){
        try{
            Thread.sleep(waitTime);
            log.info("Waiting for: " + waitTime + " milliseconds");
            etest.log(LogStatus.INFO, "Waited for: " + waitTime + " milliseconds");
        }catch (Exception e){
            log.error(e);
            log.error("Error in executing keyword: waitForMilliSeconds");
            etest.log(LogStatus.ERROR, "Error in executing keyword: waitForMilliSeconds");
            etest.log(LogStatus.FAIL, "Fail in executing keyword: waitForMilliSeconds");
        }
    }

    public static void waitUntilTextVisible(String textToBeVisible){
        try{
            String pageSourceCode = null;
            boolean sourceContains = false;
            int index = 0;
            do{
                pageSourceCode = driver.getPageSource();
                sourceContains = pageSourceCode.contains(textToBeVisible);
                index = ++index;
                Thread.sleep(2000);
            } while(sourceContains == false || index < 5);

            if(sourceContains == true) {
                //Performing assertions
                log.info("Test Passed: Text present in page source code");
                etest.log(LogStatus.PASS, "Page source code check", "Expected text : " + "\'" + textToBeVisible + "\'" + " present in page source code");
            }else
            {
                log.info("Test Failed: Text not present in page source code!");
                etest.log(LogStatus.FAIL, "Page source code check", "Expected text : " + "\'" + textToBeVisible + "\'" + " not present in page source code");
                String image = etest.addScreenCapture(takeScreenshot());
                etest.log(LogStatus.FAIL,"Image:" + image);
            }

        }catch (Exception e){
            log.error(e);
            log.error("Error in executing keyword: waitUntilVisible");
            etest.log(LogStatus.ERROR, "Error in executing keyword: waitUntilVisible");
            etest.log(LogStatus.FAIL, "Fail in executing keyword: waitUntilVisible");
        }
    }

    public static void waitUntilElementLoads(String elementType, String elementValue,Boolean needObjectMap) throws IOException {
        String rawElementValue = null;
        WebElement element;
        try{
            if(needObjectMap == true){
                rawElementValue = Base.getUiValue(elementValue);}
            else {
                rawElementValue = elementValue;
            }
            log.info("Waiting for element: " + rawElementValue + " of type: "+ elementType + " to load.");
            if (elementType.equalsIgnoreCase("class")) {
                element = (new WebDriverWait(driver, 20)).until(ExpectedConditions.presenceOfElementLocated(By.className(rawElementValue)));
            }
            if (elementType.equalsIgnoreCase("xpath")) {
                element = (new WebDriverWait(driver, 20)).until(ExpectedConditions.presenceOfElementLocated(By.xpath(rawElementValue)));
            }
            if (elementType.equalsIgnoreCase("id")) {
                element = (new WebDriverWait(driver, 20)).until(ExpectedConditions.presenceOfElementLocated(By.id(rawElementValue)));
            }
            if (elementType.equalsIgnoreCase("tagName")) {
                element = (new WebDriverWait(driver, 20)).until(ExpectedConditions.presenceOfElementLocated(By.tagName(rawElementValue)));
            }
            if (elementType.equalsIgnoreCase("name")) {
                element = (new WebDriverWait(driver, 20)).until(ExpectedConditions.presenceOfElementLocated(By.name(rawElementValue)));
            }
            if (elementType.equalsIgnoreCase("linkText")) {
                element = (new WebDriverWait(driver, 20)).until(ExpectedConditions.presenceOfElementLocated(By.linkText(rawElementValue)));
            }
            if (elementType.equalsIgnoreCase("partialLinkText")) {
                element = (new WebDriverWait(driver, 20)).until(ExpectedConditions.presenceOfElementLocated(By.partialLinkText(rawElementValue)));
            }
            if (elementType.equalsIgnoreCase("css")) {
                element = (new WebDriverWait(driver, 20)).until(ExpectedConditions.presenceOfElementLocated(By.cssSelector(rawElementValue)));
            }
        } catch (Exception e){
            log.error(e);
            log.error("Error in executing keyword: waitUntilElementLoads");
            etest.log(LogStatus.ERROR, "Error in executing keyword: waitUntilElementLoads");
            etest.log(LogStatus.FAIL, "Failed in executing keyword: waitUntilElementLoads");
            String image = etest.addScreenCapture(takeScreenshot());
            etest.log(LogStatus.FAIL,"Image:" + image);
        }
    }

    public static void waitUntilElementDisappears(String elementType, String elementValue,Boolean needObjectMap) throws IOException {
        String rawElementValue = null;
        Boolean element;
        try{
            if(needObjectMap == true){
                rawElementValue = Base.getUiValue(elementValue);}
            else {
                rawElementValue = elementValue;
            }

            log.info("Waiting for element: " + rawElementValue + " of type: "+ elementType + " to unload.");

            if (elementType.equalsIgnoreCase("class")) {
                element = (new WebDriverWait(driver, 10)).until(ExpectedConditions.invisibilityOfElementLocated(By.className(rawElementValue)));
            }
            if (elementType.equalsIgnoreCase("xpath")) {
                element = (new WebDriverWait(driver, 10)).until(ExpectedConditions.invisibilityOfElementLocated(By.xpath(rawElementValue)));
            }
            if (elementType.equalsIgnoreCase("id")) {
                element = (new WebDriverWait(driver, 10)).until(ExpectedConditions.invisibilityOfElementLocated(By.id(rawElementValue)));
            }
            if (elementType.equalsIgnoreCase("tagName")) {
                element = (new WebDriverWait(driver, 10)).until(ExpectedConditions.invisibilityOfElementLocated(By.tagName(rawElementValue)));
            }
            if (elementType.equalsIgnoreCase("name")) {
                element = (new WebDriverWait(driver, 10)).until(ExpectedConditions.invisibilityOfElementLocated(By.name(rawElementValue)));
            }
            if (elementType.equalsIgnoreCase("linkText")) {
                element = (new WebDriverWait(driver, 10)).until(ExpectedConditions.invisibilityOfElementLocated(By.linkText(rawElementValue)));
            }
            if (elementType.equalsIgnoreCase("partialLinkText")) {
                element = (new WebDriverWait(driver, 10)).until(ExpectedConditions.invisibilityOfElementLocated(By.partialLinkText(rawElementValue)));
            }
            if (elementType.equalsIgnoreCase("css")) {
                element = (new WebDriverWait(driver, 10)).until(ExpectedConditions.invisibilityOfElementLocated(By.cssSelector(rawElementValue)));
            }
        } catch (Exception e){
            log.error(e);
            log.error("Error in executing keyword: waitUntilElementDisappears");
            etest.log(LogStatus.ERROR, "Error in executing keyword: waitUntilElementDisappears");
            etest.log(LogStatus.FAIL, "Failed in executing keyword: waitUntilElementDisappears");
            String image = etest.addScreenCapture(takeScreenshot());
            etest.log(LogStatus.FAIL,"Image:" + image);
        }
    }

    public static List<WebElement> findMultipleElements(String elementType, String elementValue,Boolean needObjectMap) throws IOException {
        String rawElementValue = null;
        List<WebElement> matchedlElments = null;
        try{
            if(needObjectMap == true){
                rawElementValue = Base.getUiValue(elementValue);}
            else {
                rawElementValue = elementValue;
            }
            log.info("Waiting for element: " + rawElementValue + " of type: "+ elementType + " to load.");
            if (elementType.equalsIgnoreCase("class")) {
                matchedlElments = driver.findElements(By.className(rawElementValue));
            }
            if (elementType.equalsIgnoreCase("xpath")) {
                matchedlElments = driver.findElements(By.xpath(rawElementValue));
            }
            if (elementType.equalsIgnoreCase("id")) {
                matchedlElments = driver.findElements(By.id(rawElementValue));
            }
            if (elementType.equalsIgnoreCase("tagName")) {
                matchedlElments = driver.findElements(By.tagName(rawElementValue));
            }
            if (elementType.equalsIgnoreCase("name")) {
                matchedlElments = driver.findElements(By.name(rawElementValue));
            }
            if (elementType.equalsIgnoreCase("linkText")) {
                matchedlElments = driver.findElements(By.linkText(rawElementValue));
            }
            if (elementType.equalsIgnoreCase("partialLinkText")) {
                matchedlElments = driver.findElements(By.partialLinkText(rawElementValue));
            }
            if (elementType.equalsIgnoreCase("css")) {
                matchedlElments = driver.findElements(By.cssSelector(rawElementValue));
            }
        } catch (Exception e){
            log.error(e);
            log.error("Error in executing keyword: findMultipleElements");
            etest.log(LogStatus.ERROR, "Error in executing keyword: findMultipleElements");
            etest.log(LogStatus.FAIL, "Failed in executing keyword: findMultipleElements");
            String image = etest.addScreenCapture(takeScreenshot());
            etest.log(LogStatus.FAIL,"Image:" + image);
        }
        return matchedlElments;
    }

    public static void textShouldBeEqual(String one, String two){
        try{
            if(one.equals(two)){
                log.info("Test Passed: Text is equal");
                etest.log(LogStatus.PASS, "Text is equal");
            }
            else {
                log.info("Test Failed: Text is not equal");
                etest.log(LogStatus.FAIL, "Text is not equal");
                String image = etest.addScreenCapture(takeScreenshot());
                etest.log(LogStatus.FAIL,"Image:" + image);
            }
        }catch (Exception e){
            log.error(e);
            log.error("Error in executing keyword: textShouldBeEqual");
            etest.log(LogStatus.ERROR, "Error in executing keyword: textShouldBeEqual");
            etest.log(LogStatus.FAIL, "Failed in executing keyword: textShouldBeEqual");
            String image = etest.addScreenCapture(takeScreenshot());
            etest.log(LogStatus.FAIL,"Image:" + image);
        }
    }
}
