import static com.kms.katalon.core.checkpoint.CheckpointFactory.findCheckpoint
import static com.kms.katalon.core.testcase.TestCaseFactory.findTestCase
import static com.kms.katalon.core.testdata.TestDataFactory.findTestData
import static com.kms.katalon.core.testobject.ObjectRepository.findTestObject

import com.kms.katalon.core.checkpoint.Checkpoint as Checkpoint
import com.kms.katalon.core.model.FailureHandling as FailureHandling
import com.kms.katalon.core.testcase.TestCase as TestCase
import com.kms.katalon.core.testdata.TestData as TestData
import com.kms.katalon.core.testobject.TestObject as TestObject

import com.kms.katalon.core.webservice.keyword.WSBuiltInKeywords as WS
import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUI
import com.kms.katalon.core.mobile.keyword.MobileBuiltInKeywords as Mobile

import internal.GlobalVariable as GlobalVariable

import com.kms.katalon.core.annotation.BeforeTestCase
import com.kms.katalon.core.annotation.BeforeTestSuite
import com.kms.katalon.core.annotation.AfterTestCase
import com.kms.katalon.core.annotation.AfterTestSuite
import com.kms.katalon.core.context.TestCaseContext
import com.kms.katalon.core.context.TestSuiteContext

class OpenBrowser {
	/**
	 * Executes before every test case starts.
	 * @param testCaseContext related information of the executed test case.
	 */
	
	def targetFolderSetelahLogin = 'Test Cases/Dashboard Setelah Login'
	
	@BeforeTestCase
	def openBrowser(TestCaseContext testCaseContext) {
		String testCaseId = testCaseContext.getTestCaseId()
	
		WebUI.openBrowser('')
		WebUI.navigateToUrl('https://dev.premium.enigmacamp.com/')
		
		
		if(isTestCaseinTargetFolderSetelahLogin(testCaseId)) {
			WebUI.click(findTestObject('Dashboard Sebelum Login/e. button_Login'))
			WebUI.setText(findTestObject('Login/input_Email_email'), 'yudha.dlesmana@gmail.com')
			WebUI.setEncryptedText(findTestObject('Login/input_Password_password'), 'h8OM8R2hSRVY06rr2nhzfQ==')
			WebUI.click(findTestObject('Login/button_Login'))
		}

	}

	/**
	 * Executes after every test case ends.
	 * @param testCaseContext related information of the executed test case.
	 */
	/*@AfterTestCase
	def closeBrowser(TestCaseContext testCaseContext) {
		String testCaseId = testCaseContext.getTestCaseId()
		
		//test case in folder
		if (isTestCaseInTargetFolder(testCaseId)) {
			WebUI.closeBrowser()
		}
	}*/
	
	//function for check Test Case in folder 
	def isTestCaseinTargetFolderSetelahLogin(String testCaseId) {
		return testCaseId.contains(targetFolderSetelahLogin)
	}
}