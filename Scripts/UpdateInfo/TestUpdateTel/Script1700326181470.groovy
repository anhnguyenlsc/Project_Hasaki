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

WebUI.mouseOver(findTestObject('Object Repository/Page_Hasaki.vn  M Phm  Clinic/div_Cho Anh                Ti khon         _190dd7'))

WebUI.click(findTestObject('Object Repository/Page_Hasaki.vn  M Phm  Clinic/a_Ti khon ca bn'))

WebUI.click(findTestObject('Object Repository/Page_Ti khon ca ti  Hasaki.vn/a_Chnh sa'))

WebUI.click(findTestObject('Object Repository/btnUpdatePhone'))

String updatedPhoneNumber = '0329335539' // Số điện thoại vừa cập nhật

//WebUI.setText(findTestObject('Object Repository/Page_Thay i s in thoi  Hasaki.vn/input_phone'), '0329335539')
//
//WebUI.click(findTestObject('Object Repository/Page_Thay i s in thoi  Hasaki.vn/button_Gi OTP'))
//
//WebUI.setText(findTestObject('Object Repository/Page_Thay i s in thoi  Hasaki.vn/input_otp'), '869378')
//
//WebUI.click(findTestObject('Object Repository/Page_Thay i s in thoi  Hasaki.vn/button_Cp nht'))
String displayedPhoneNumber = WebUI.getText(findTestObject('Object Repository/Page_Thng Tin Ti khon  Hasaki.vn/div_0329335539'))

// So sánh số điện thoại này với số điện thoại vừa cập nhật
if (displayedPhoneNumber.equals(updatedPhoneNumber)) {
    println('Cập nhật số điện thoại thành công')
} else {
    println('Cập nhật số điện thoại không thành công')
}

WebUI.closeBrowser()

