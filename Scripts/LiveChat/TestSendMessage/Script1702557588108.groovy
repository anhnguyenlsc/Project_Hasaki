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

// Lấy số lượng tin nhắn trước khi gửi tin nhắn
List<TestObject> messagesBefore = WebUI.findWebElements(findTestObject('Object Repository/LiveChat/icon_message'), 10) 
println('Số lượng tin nhắn trước khi gửi: ' + messagesBefore.size())

WebUI.setText(findTestObject('Object Repository/Page_Hasaki.vn  M Phm  Clinic/textarea_Toner cho da du mn th nn dng loi no_1_2'), 
    'Toner cho da dầu mụn thì nên dùng loại nào ạ')

WebUI.click(findTestObject('Object Repository/LiveChat/bntSend'))

WebUI.delay(10)

// Lấy số lượng tin nhắn sau khi gửi tin nhắn
List<TestObject> messagesAfter = WebUI.findWebElements(findTestObject('Object Repository/LiveChat/icon_message'), 10)
println('Số lượng tin nhắn sau khi gửi: ' + messagesAfter.size())

// Kiểm tra xem số lượng tin nhắn có tăng lên không
if (messagesAfter.size() > messagesBefore.size()) {
    println('Số lượng tin nhắn đã tăng lên.')
} else {
    println('Số lượng tin nhắn không thay đổi.')
}

WebUI.closeBrowser()

