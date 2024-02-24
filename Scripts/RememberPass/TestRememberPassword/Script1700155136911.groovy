import static com.kms.katalon.core.checkpoint.CheckpointFactory.findCheckpoint
import static com.kms.katalon.core.testcase.TestCaseFactory.findTestCase
import static com.kms.katalon.core.testdata.TestDataFactory.findTestData
import static com.kms.katalon.core.testobject.ObjectRepository.findTestObject
import static com.kms.katalon.core.testobject.ObjectRepository.findWindowsObject
import com.kms.katalon.core.util.KeywordUtil
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

WebUI.openBrowser('')

WebUI.navigateToUrl('https://hasaki.vn/')

WebUI.maximizeWindow()

WebUI.click(findTestObject('Object Repository/Page_Hasaki.vn  M Phm  Clinic/button_Khng ng'))

WebUI.mouseOver(findTestObject('Object Repository/Page_Hasaki.vn  M Phm  Clinic/img_loading'))

WebUI.click(findTestObject('Object Repository/Page_Hasaki.vn  M Phm  Clinic/a_ng nhp'))

WebUI.setText(findTestObject('Object Repository/Page_Hasaki.vn  M Phm  Clinic/input_username'), 'anhnguyen.lsc@gmail.com')

WebUI.setEncryptedText(findTestObject('Object Repository/Page_Hasaki.vn  M Phm  Clinic/input_pass'), 'KlKWPsSD8ChNKhnvrb/YjQ==')

WebUI.click(findTestObject('Object Repository/Page_Hasaki.vn  M Phm  Clinic/input_checkbox'))

WebUI.click(findTestObject('Object Repository/Page_Hasaki.vn  M Phm  Clinic/button_ng nhp'))

WebUI.mouseOver(findTestObject('Object Repository/Page_Ti khon ca ti  Hasaki.vn/div_Cho Anh                Ti khon         _190dd7'))

WebUI.click(findTestObject('Object Repository/Page_Ti khon ca ti  Hasaki.vn/a_Thot'))

WebUI.mouseOver(findTestObject('Object Repository/Page_Hasaki.vn  M Phm  Clinic/img_loading'))

WebUI.click(findTestObject('Object Repository/Page_Hasaki.vn  M Phm  Clinic/a_ng nhp'))

String username = WebUI.getAttribute(findTestObject('Object Repository/Page_Hasaki.vn  M Phm  Clinic/input_username'), 'value')

String password = WebUI.getAttribute(findTestObject('Object Repository/Page_Hasaki.vn  M Phm  Clinic/input_pass'), 'value')



if (username == '' || password == '') {
    KeywordUtil.markFailed('Test Case Failed: Username or password was not auto-filled.')
} else {
    println("Username: " + username)
    println("Password: " + password)
}
