package packaged

import static com.kms.katalon.core.checkpoint.CheckpointFactory.findCheckpoint
import static com.kms.katalon.core.testcase.TestCaseFactory.findTestCase
import static com.kms.katalon.core.testdata.TestDataFactory.findTestData
import static com.kms.katalon.core.testobject.ObjectRepository.findTestObject
import static com.kms.katalon.core.testobject.ObjectRepository.findWindowsObject

import com.kms.katalon.core.annotation.Keyword
import com.kms.katalon.core.checkpoint.Checkpoint
import com.kms.katalon.core.cucumber.keyword.CucumberBuiltinKeywords as CucumberKW
import com.kms.katalon.core.mobile.keyword.MobileBuiltInKeywords as Mobile
import com.kms.katalon.core.model.FailureHandling
import com.kms.katalon.core.testcase.TestCase
import com.kms.katalon.core.testdata.TestData
import com.kms.katalon.core.testobject.TestObject
import com.kms.katalon.core.webservice.keyword.WSBuiltInKeywords as WS
import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUI
import com.kms.katalon.core.windows.keyword.WindowsBuiltinKeywords as Windows
import groovy.sql.Sql

import internal.GlobalVariable

public class getOTP {

	@Keyword
	def String checkOTP(String mobileNumber, String type) {
		// Construct the database connection URL
		String connUrl = GlobalVariable.G_dbURL
		String username = GlobalVariable.G_Username
		String password = GlobalVariable.G_Password
		String driverClassName = GlobalVariable.G_dbDriver

		// Initialize the connection
		def data = Sql.newInstance(connUrl, username, password, driverClassName)
		String otp = ""
		String query = "SELECT code FROM ms_auth.adr_auth_otp WHERE mobile_number = '${mobileNumber}' AND type = '${type}'"

		try {
			data.eachRow(query) { row ->
				otp = row[0] // Assuming OTP is in the first column of the result set
			}
		} catch (Exception e) {
			println "Error executing query: ${e.message}"
		} finally {
			data.close() // Ensure the database connection is closed
		}

		println "Retrieved OTP: " + otp
		return otp
	}
}