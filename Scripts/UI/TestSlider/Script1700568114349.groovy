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
import com.kms.katalon.core.util.KeywordUtil

WebUI.openBrowser('')

WebUI.maximizeWindow()

WebUI.navigateToUrl('https://hasaki.vn/')

WebUI.click(findTestObject('Object Repository/Page_Hasaki.vn  M Phm  Clinic/button_Khng ng'))

// Lấy thông tin về slide hiện tại
String oldSlideInfo = WebUI.getAttribute(findTestObject('Object Repository/Slider/slider'), 'src')

// Nhấp vào nút 'Next'
WebUI.click(findTestObject('Object Repository/Page_Hasaki.vn  M Phm  Clinic/a_Next'))

// Lấy thông tin về slide mới
String newSlideInfo = WebUI.getAttribute(findTestObject('Object Repository/Slider/slider_new'), 'src')

// So sánh thông tin slide cũ và mới
if (oldSlideInfo.equals(newSlideInfo)) {
	KeywordUtil.markFailed('The slide did not change after clicking Next.')
} else {
	KeywordUtil.markPassed('The slide changed after clicking Next.')
	//Kiểm tra phản hồi của slider khi tương tác (sau khi  sử dụng phương thức WebUI.click)
	KeywordUtil.logInfo('The slider responded as expected.')
}

WebUI.closeBrowser()

