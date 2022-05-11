import org.openqa.selenium.WebDriver as WebDriver
import org.openqa.selenium.remote.RemoteWebDriver as RemoteWebDriver
import org.openqa.selenium.support.events.EventFiringWebDriver as EventFiringWebDriver
import com.kms.katalon.core.configuration.RunConfiguration as RunConfiguration
import com.kms.katalon.core.context.TestCaseContext as TestCaseContext
import com.kms.katalon.core.webui.driver.DriverFactory as DriverFactory
import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUI
import com.relevantcodes.extentreports.ExtentReports as ExtentReports
import com.relevantcodes.extentreports.ExtentTest as ExtentTest
import com.relevantcodes.extentreports.LogStatus as LogStatus

String execID = RunConfiguration.getExecutionSourceName()

ExtentReports extent = CustomKeywords.'com.katalon.plugin.keyword.extentReport.Extent.setupExtentReport'(execID)

TestCaseContext testCaseContext;

String tcID = RunConfiguration.getExecutionSource().toString().substring(RunConfiguration.getExecutionSource().toString().lastIndexOf("\\")+1)


ExtentTest extentTest = CustomKeywords.'com.katalon.plugin.keyword.extentReport.Extent.startExtentTest'(tcID, 'Extent Test', 
    extent)

extentTest.log(LogStatus.INFO, 'Browser Launched')

WebUI.openBrowser('')

WebDriver driver = DriverFactory.getWebDriver()

String baseUrl = 'https://www.youtube.com'

WebUI.navigateToUrl(baseUrl + '/')

WebUI.maximizeWindow()

extentTest.log(LogStatus.INFO, 'Navigated to www.google.com')

// get title.
//String title = driver.getTitle()
String title = WebUI.getWindowTitle()

println(title)

extentTest.log(LogStatus.INFO, 'Get the WebSite title')

// Verify title.
//Assert.assertTrue(title.contains("Search hundreds of energy supplier offers near you"));
if (title.equalsIgnoreCase('Google')) {
    extentTest.log(LogStatus.PASS, 'Title verified')
} else {
    String dest = CustomKeywords.'com.katalon.plugin.keyword.extentReport.Extent.getScreeshot'(driver, execID, tcID)

    extentTest.log(LogStatus.FAIL, 'Error Snapshot : ' + extentTest.addScreenCapture(dest))
}

// Close application.
driver.quit()

extentTest.log(LogStatus.INFO, 'Browser closed')

CustomKeywords.'com.katalon.plugin.keyword.extentReport.Extent.tearDownTest'(((((driver) as EventFiringWebDriver).getWrappedDriver()) as RemoteWebDriver), 
    extent, extentTest)