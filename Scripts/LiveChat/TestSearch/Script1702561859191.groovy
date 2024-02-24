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

WebUI.click(findTestObject('Object Repository/Page_Hasaki.vn  M Phm  Clinic/img__icon_iq4kl_47 loading'))

String searchText = 'toner'
WebUI.setText(findTestObject('Object Repository/Page_Hasaki.vn  M Phm  Clinic/inputHsk-Search'), searchText)

WebUI.sendKeys(findTestObject('Object Repository/Page_Hasaki.vn  M Phm  Clinic/inputHsk-Search'), Keys.chord(Keys.ENTER))

// Chờ đợi một khoảng thời gian nhất định
WebUI.delay(10)

// Kiểm tra xem một phần tử cụ thể có xuất hiện trong kết quả tìm kiếm hay không
if (WebUI.verifyElementPresent(findTestObject('Object Repository/LiveChat/chat'), 10, FailureHandling.OPTIONAL)) {
    println('Tìm kiếm thành công.')
} else {
    println('Tìm kiếm không thành công.')
}

WebUI.closeBrowser()




