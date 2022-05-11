package general

import com.katalon.plugin.keyword.extentReport.Extent
import com.kms.katalon.core.configuration.RunConfiguration
import com.relevantcodes.extentreports.ExtentReports
import com.relevantcodes.extentreports.ExtentTest


public class ExtentReport {

	public static Map extentSetup() {

		String execID = RunConfiguration.getExecutionSourceName()

		ExtentReports extent = new Extent().setupExtentReport(execID)

		String tcID = RunConfiguration.getExecutionSource().toString()
				.substring(RunConfiguration.getExecutionSource().toString().lastIndexOf('\\') + 1)

		ExtentTest extentTest = new Extent().startExtentTest(tcID, 'Extent Test', extent)

		Map m = [('execID') : execID, ('tcID') : tcID, ('extentTest') : extentTest, ('extent') : extent]
		return m;
	}
}
