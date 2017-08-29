/**
 * Created by prachi a. pawaskar on 26-August-2016.
*/

=========================
Details:
=========================
This QA automation framework is created for TnF CMS project to handle UI cases.

=========================
System requirement:
=========================
> Java 7/7+ [Refer http://www.oracle.com/technetwork/java/javase/downloads/index.html]
> Maven [Refer http://www.avajava.com/tutorials/lessons/what-is-maven-and-how-do-i-install-it.html]

=========================
Framework details:
=========================
> Build tool/Repository manager: Maven
> Testing framework: TestNG
> Framework type: Hybrid Framework
> Web UI testing :  Selenium Webdriver
> Logger used: Log4j logger
> Reporting used: ExtendReports v2

=========================
SCM details:
=========================
SCM: Gitlab
Git URL: https://gitlab.com/taylor-francis/tandf-qa-automation.git
Branch: */cms-automation

=========================
Execution instructions:
=========================
> Through command line -
1. mvn test -DsuiteXmlFile={testng file name} -Denv={envValue} -Dbrowser={browser} -DloginRole={loginRole}
    //envValue can be production,uat, qa, dev
    //browser can be firefox or chrome or ie [Note: IE 11 can create issues due MS change in browser actions.]
    //loginRole can be any based on the details entered in envDetails.properties, eg: leadArchivist for leadArchivist_username
    //suiteXmlFile can be any test suite to run should be testng_Regression.xml, testng_Sanity.xml and testng_Smoke.xml
    eg: mvn test -DsuiteXmlFile=testng_Regression.xml -Denv=qa -Dbrowser=firefox -DloginRole=leadArchivist
2. mvn test -DsuiteXmlFile=testng_Regression.xml    //envValue=qa, browser=firefox and -DloginRole=leadArchivist default value

> Through IDE -
Run testng*.xml and append VM options -Denv=qa -Dbrowser=firefox -DloginRole=leadArchivist
Run testng*.xml and change env, browser and loginRole parameters

Note: Only uncommented classes from testng.xml will be executed.

=========================
Enable IE execution
=========================
> For IE 10:
1. "Enhanced Protected Mode" must be disabled for IE 10 and higher. This option is found in the Advanced tab of the Internet Options dialog.
2. The browser zoom level must be set to 100% so that the native mouse events can be set to the correct coordinates.

> For IE 11:
1. "Enhanced Protected Mode" must be disabled for IE 10 and higher. This option is found in the Advanced tab of the Internet Options dialog.
2.  For IE 11 only, you will need to set a registry entry on the target computer so that the driver can maintain a connection to the instance of Internet Explorer it creates.
3. For 32-bit Windows installations, the key you must examine in the registry editor is HKEY_LOCAL_MACHINE\SOFTWARE\Microsoft\Internet Explorer\Main\FeatureControl\FEATURE_BFCACHE.
4. For 64-bit Windows installations, the key is HKEY_LOCAL_MACHINE\SOFTWARE\Wow6432Node\Microsoft\Internet Explorer\Main\FeatureControl\FEATURE_BFCACHE.
5. Please note that the FEATURE_BFCACHE subkey may or may not be present, and should be created if it is not present.
Important: Inside this key, create a DWORD value named iexplore.exe with the value of 0.


=========================
Reports:
=========================
> HTML reports are created under: /reports/{detailTestReport_*}.html
> Reports have two sections:
1. Tests [for test scripts details]
2. Dashboard [for test summary]
> New report is created for each execution

Note: Please do not commit this file to bit bucket.

=========================
Logs:
=========================
> Logs are written in log file: /applog.log
> Only one file is maintained, contents are overwritten after each execution.

Note: Avoid committing this file.
