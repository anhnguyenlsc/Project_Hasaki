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

def data = findTestData('DataChangePass')

for (int i = 1; i <= data.getRowNumbers(); i++) {
	WebUI.callTestCase(findTestCase('login'), [:], FailureHandling.STOP_ON_FAILURE)
	
	WebUI.mouseOver(findTestObject('Object Repository/Page_Hasaki.vn  M Phm  Clinic/div_Cho Anh                Ti khon         _190dd7'))
	
	WebUI.click(findTestObject('Object Repository/Page_Hasaki.vn  M Phm  Clinic/a_Ti khon ca bn'))
	
	WebUI.click(findTestObject('Object Repository/Page_Ti khon ca ti  Hasaki.vn/a_Chnh sa'))
	
	WebUI.click(findTestObject('Object Repository/Page_Thng Tin Ti khon  Hasaki.vn/a_Cp nht'))
	
	String password = data.getValue('Password', i)
	
	String password_new = data.getValue('Password_New', i)
	
	String password_confirm = data.getValue('Password_Confirm', i)
	
	WebUI.setEncryptedText(findTestObject('Object Repository/Page_Thay i mt khu  Hasaki.vn/input_password'), password)
	
	WebUI.setEncryptedText(findTestObject('Object Repository/Page_Thay i mt khu  Hasaki.vn/input_passwordNew'), password_new)
	
	WebUI.setEncryptedText(findTestObject('Object Repository/Page_Thay i mt khu  Hasaki.vn/input_passwordConfirm'), password_confirm)
	
	Thread.sleep(3000)
	
	WebUI.click(findTestObject('Object Repository/Page_Thay i mt khu  Hasaki.vn/button_Cp nht'))
	
	String status = "Failed";
	
	TestObject successElement = findTestObject('Object Repository/Page_Thng Tin Ti khon  Hasaki.vn/div_Mt khu ca bn  c thay i thnh cng');
	
	TestObject[] elements = [
	    findTestObject('Object Repository/Page_Thay i mt khu  Hasaki.vn/div_Mt khu hin ti khng ng'),
	    findTestObject('Object Repository/Page_Thay i mt khu  Hasaki.vn/span_Mt khu khng trng khp'),
	    findTestObject('Object Repository/Page_Thay i mt khu  Hasaki.vn/div_Nhp li'),
	    findTestObject('Object Repository/Page_Thay i mt khu  Hasaki.vn/div_Mt khu hin ti                          _478670'),
	    findTestObject('Object Repository/Page_Thay i mt khu  Hasaki.vn/div_Mt khu hin ti                          _c88135'),
	    findTestObject('Object Repository/Page_Thay i mt khu  Hasaki.vn/span_Thng tin bt buc')
	];
	
	
	if (WebUI.verifyElementPresent(successElement, 0, FailureHandling.OPTIONAL)) {
	    status = "Passed";
	} else {
	    for (TestObject element : elements) {
	        if (WebUI.verifyElementPresent(element, 0, FailureHandling.OPTIONAL)) {
	            status = "Failed";
	            break;
	        }
	    }
	}

	
	// Ghi xuống file excel, cột Status, hàng i
	CustomKeywords.'com.utilities.TestWriteExcel.demoWriteExcel'(status, i, 'ChangePassword')

	WebUI.closeBrowser()
}

