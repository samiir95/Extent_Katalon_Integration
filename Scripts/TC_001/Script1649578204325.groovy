import org.openqa.selenium.WebDriver
import org.openqa.selenium.chrome.ChromeDriver

import com.kms.katalon.core.configuration.RunConfiguration
import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUI
import com.relevantcodes.extentreports.ExtentReports
import com.relevantcodes.extentreports.ExtentTest
import com.relevantcodes.extentreports.LogStatus

import io.github.bonigarcia.wdm.WebDriverManager

String execID = RunConfiguration.getExecutionSourceName()

ExtentReports extent = CustomKeywords.'com.katalon.plugin.keyword.extentReport.Extent.setupExtentReport'(execID)

String tcID = 'Test Case 1'

ExtentTest extentTest = CustomKeywords.'com.katalon.plugin.keyword.extentReport.Extent.startExtentTest'(tcID, 'Extent Test', 
    extent)

//WebUI.openBrowser('')

extentTest.log(LogStatus.INFO, 'Browser Launched')

System.setProperty("webdriver.chrome.driver", "chrome_driver/chromedriver.exe");

WebDriver driver = new ChromeDriver();

String baseUrl = 'https://www.youtube.com'

driver.get(baseUrl + '/')

driver.manage().window().maximize()

extentTest.log(LogStatus.INFO, 'Navigated to www.google.com')

// get title.
String title = driver.getTitle()

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

CustomKeywords.'com.katalon.plugin.keyword.extentReport.Extent.tearDownTest'(driver, extent, extentTest)
