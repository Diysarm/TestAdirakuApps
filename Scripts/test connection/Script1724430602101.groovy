import static com.kms.katalon.core.checkpoint.CheckpointFactory.findCheckpoint
import static com.kms.katalon.core.testcase.TestCaseFactory.findTestCase
import static com.kms.katalon.core.testdata.TestDataFactory.findTestData
import static com.kms.katalon.core.testobject.ObjectRepository.findTestObject
import static com.kms.katalon.core.testobject.ObjectRepository.findWindowsObject
import com.kms.katalon.core.checkpoint.Checkpoint as Checkpoint
import com.kms.katalon.core.cucumber.keyword.CucumberBuiltinKeywords as CucumberKW
import com.kms.katalon.core.mobile.keyword.MobileBuiltInKeywords as Mobile
import com.kms.katalon.core.model.FailureHandling as FailureHandling
import com.kms.katalon.core.testcase.TestCase as TestCase
import com.kms.katalon.core.testdata.TestData as TestData
import com.kms.katalon.core.testng.keyword.TestNGBuiltinKeywords as TestNGKW
import com.kms.katalon.core.testobject.TestObject as TestObject
import com.kms.katalon.core.webservice.keyword.WSBuiltInKeywords as WS
import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUI
import com.kms.katalon.core.windows.keyword.WindowsBuiltinKeywords as Windows
import internal.GlobalVariable as GlobalVariable
import org.openqa.selenium.Keys as Keys
import groovy.sql.Sql

def data = Sql.newInstance(GlobalVariable.G_dbURL, GlobalVariable.G_Username, GlobalVariable.G_Password, GlobalVariable.G_dbDriver)

String query = "SELECT code FROM ms_auth.adr_auth_otp WHERE mobile_number = '081812344321' and type ='login'"

String otp = ""

try {
	data.eachRow(query) { row ->
		otp = row[0] // Assuming OTP is in the first column of the result set
	}
} catch (Exception e) {
	println "Error executing query: ${e.message}"
} finally {
	data.close() // Close the database connection
}

// Print the OTP to the console for verification
println "Retrieved OTP: " + otp

// Use the OTP in your test case
Mobile.setText(findTestObject('your_object_path'), otp, 0)