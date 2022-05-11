import org.openqa.selenium.WebDriver as WebDriver
import org.openqa.selenium.remote.RemoteWebDriver as RemoteWebDriver
import org.openqa.selenium.support.events.EventFiringWebDriver as EventFiringWebDriver
import com.kms.katalon.core.webui.driver.DriverFactory as DriverFactory
import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUI
import com.relevantcodes.extentreports.ExtentTest as ExtentTest
import com.relevantcodes.extentreports.LogStatus as LogStatus
import general.ExtentReport as ExtentReport

Map m = ExtentReport.extentSetup()

ExtentTest extentTest = m.get('extentTest')

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
    String dest = CustomKeywords.'com.katalon.plugin.keyword.extentReport.Extent.getScreeshot'(driver, m.get('execID'), 
        m.get('tcID'))

    extentTest.log(LogStatus.FAIL, 'Error Snapshot : ' + extentTest.addScreenCapture(dest))
}

// Close application.
driver.quit()

extentTest.log(LogStatus.INFO, 'Browser closed')

CustomKeywords.'com.katalon.plugin.keyword.extentReport.Extent.tearDownTest'(((((driver) as EventFiringWebDriver).getWrappedDriver()) as RemoteWebDriver), 
    m.get('extent'), extentTest)