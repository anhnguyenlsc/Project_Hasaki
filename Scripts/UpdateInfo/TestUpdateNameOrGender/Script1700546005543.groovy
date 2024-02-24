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

WebUI.callTestCase(findTestCase('login'), [:], FailureHandling.STOP_ON_FAILURE)

WebUI.mouseOver(findTestObject('Object Repository/Page_Hasaki.vn  M Phm  Clinic/div_Cho Anh                Ti khon         _190dd7'))

WebUI.click(findTestObject('Object Repository/Page_Hasaki.vn  M Phm  Clinic/a_Ti khon ca bn'))

WebUI.click(findTestObject('Object Repository/Page_Ti khon ca ti  Hasaki.vn/a_Chnh sa'))

// Lưu tên ban đầu
def originalName = WebUI.getAttribute(findTestObject('Object Repository/Page_Thng Tin Ti khon  Hasaki.vn/input_fullName'),
	'value')

WebUI.setText(findTestObject('Object Repository/Page_Thng Tin Ti khon  Hasaki.vn/input_fullName'), 'Lan Anh Nguyễn')

// Lưu giới tính ban đầu
def originalGender = WebUI.getAttribute(findTestObject('Object Repository/Page_Thng Tin Ti khon  Hasaki.vn/input_gender'),
	'value')

WebUI.click(findTestObject('Object Repository/Page_Thng Tin Ti khon  Hasaki.vn/input_gender'))

// Lấy giá trị giới tính sau khi cập nhật
def updatedGender = WebUI.getAttribute(findTestObject('Object Repository/Page_Thng Tin Ti khon  Hasaki.vn/input_gender'),
	'value')

// Lấy tên sau khi cập nhật
def updatedName = WebUI.getAttribute(findTestObject('Object Repository/Page_Thng Tin Ti khon  Hasaki.vn/input_fullName'),
	'value')

// Cập nhật thông tin
WebUI.click(findTestObject('Object Repository/Page_Thng Tin Ti khon  Hasaki.vn/button_Cp nht'))

// Lấy thông báo từ hệ thống
def systemMessage = WebUI.getText(findTestObject('Object Repository/Page_Thng Tin Ti khon  Hasaki.vn/div_Cp nht thng tin ti khon thnh cng'))

// Kiểm tra xem cả tên và giới tính có thay đổi hay không
if (originalName == updatedName && originalGender == updatedGender && systemMessage == 'Cập nhật thông tin tài khoản thành công.') {
	KeywordUtil.markFailed('Cập nhật tên và giới tính không thành công nhưng hệ thống báo là cập nhật thành công')
} else {
	println('Cập nhật tên hoặc giới tính thành công')
}

WebUI.closeBrowser()

