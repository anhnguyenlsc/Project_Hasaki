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

WebUI.callTestCase(findTestCase('login'), [:], FailureHandling.STOP_ON_FAILURE)

// Tìm đối tượng chat trực tuyến
TestObject liveChatObject = findTestObject('Object Repository/Page_Hasaki.vn  M Phm  Clinic/img__icon_iq4kl_47 loading')

// Kiểm tra xem đối tượng chat trực tuyến có hiển thị không
boolean isLiveChatVisible = WebUI.waitForElementVisible(liveChatObject, 10, FailureHandling.OPTIONAL)

if (isLiveChatVisible) {
    println('Chat trực tuyến có hiển thị')
} else {
    println('Chat trực tuyến không hiển thị')
}

WebUI.click(findTestObject('Object Repository/Page_Hasaki.vn  M Phm  Clinic/img__icon_iq4kl_47 loading'))

TestObject liveChatConnect = findTestObject('Object Repository/LiveChat/connect_selector')

// Kiểm tra xem đối tượng thông báo kết nối chat trực tuyến có hiển thị không
boolean isLiveChatConnected = WebUI.waitForElementVisible(liveChatConnect, 10, FailureHandling.OPTIONAL)

if (isLiveChatConnected) {
	println('Live chat kết nối')
} else {
	println('Live chat không kết nối')
}

WebUI.closeBrowser()

