import org.openqa.selenium.WebDriver

import com.kms.katalon.core.annotation.SetUp
import com.kms.katalon.core.webui.driver.DriverFactory
import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUI

println('123 ...............................')

@SetUp
void startup(def skipped = false) {
    WebUI.openBrowser('')

	WebDriver myDriver = DriverFactory.getWebDriver()

    myDriver.get('https://www.google.com/')
}