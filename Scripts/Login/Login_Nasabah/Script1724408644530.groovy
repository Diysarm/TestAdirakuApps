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

Mobile.startApplication('C:\\Users\\muhra\\Downloads\\app-release (35).apk', true)

Mobile.verifyElementVisible(findTestObject('Initial_Screen/Button _X'), 0)

Mobile.tap(findTestObject('Initial_Screen/Button _X'), 0)

Mobile.takeScreenshot('', FailureHandling.STOP_ON_FAILURE)

Mobile.verifyElementVisible(findTestObject('Button_Berikutnya_popup'), 0)

Mobile.takeScreenshot('', FailureHandling.STOP_ON_FAILURE)

Mobile.tap(findTestObject('Button_Berikutnya_popup'), 0)

Mobile.verifyElementText(findTestObject('Button_Tutup_popup'), 'Tutup')

Mobile.verifyElementVisible(findTestObject('Button_Tutup_popup'), 0)

Mobile.tap(findTestObject('Button_Tutup_popup'), 0)

Mobile.tap(findTestObject('Button_Profile'), 0)

Mobile.setText(findTestObject('Login/FieldText_NoHP'), noHP, 0)

Mobile.tap(findTestObject('Login/Button_Masuk'), 0)
