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

def data = findTestData('DataPhoneNumber')

for (int i = 1; i <= data.getRowNumbers(); i++) {
WebUI.callTestCase(findTestCase('login'), [:], FailureHandling.STOP_ON_FAILURE)

WebUI.mouseOver(findTestObject('Object Repository/Page_Hasaki.vn  M Phm  Clinic/div_Cho Anh                Ti khon         _190dd7'))

WebUI.click(findTestObject('Object Repository/Page_Hasaki.vn  M Phm  Clinic/a_Ti khon ca bn'))

WebUI.click(findTestObject('Object Repository/Page_Ti khon ca ti  Hasaki.vn/a_Chnh sa'))

WebUI.click(findTestObject('Object Repository/btnUpdatePhone'))
	
	String phone_number = data.getValue('Phone_Number', i)
	
	WebUI.setText(findTestObject('Object Repository/Page_Thay i s in thoi  Hasaki.vn/input_phone'), phone_number)
	
	Thread.sleep(3000)
	
	WebUI.click(findTestObject('Object Repository/Page_Thay i s in thoi  Hasaki.vn/button_Gi OTP'))

	TestObject[] elements = [
		findTestObject('Object Repository/Page_Thay i s in thoi  Hasaki.vn/div_S in thoi ca bn  c ng k. Vui lng s dng _d727da'),
		findTestObject('Object Repository/Page_Thay i s in thoi  Hasaki.vn/span_S in thoi khng hp l'),
		findTestObject('Object Repository/Page_Thay i s in thoi  Hasaki.vn/span_Thng tin bt buc')
	]
	

	String status = "Passed"
	
	for (TestObject element : elements) {
		if (WebUI.verifyElementPresent(element, 0, FailureHandling.OPTIONAL)) {
			status = "Failed"
			println("failed")
			break
		}
	}
	
	// Ghi xuống file excel, cột Status, hàng i
	CustomKeywords.'com.utilities.TestWriteExcel.demoWriteExcel'(status, i, 'UpdatePhone')

	WebUI.closeBrowser()
}

