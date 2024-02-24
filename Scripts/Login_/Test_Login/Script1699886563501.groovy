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

def data = findTestData('DataLogin')

for (int i = 1; i <= data.getRowNumbers(); i++) {
    WebUI.openBrowser('')

    WebUI.navigateToUrl('https://hasaki.vn/')

    WebUI.maximizeWindow()

    WebUI.click(findTestObject('Object Repository/Page_Hasaki.vn  M Phm  Clinic/button_Khng ng'))

    WebUI.mouseOver(findTestObject('Object Repository/Page_Hasaki.vn  M Phm  Clinic/img_loading'))

    WebUI.click(findTestObject('Object Repository/Page_Hasaki.vn  M Phm  Clinic/a_ng nhp'))

    String username = data.getValue('Username', i)

    String password = data.getValue('Password', i)

    WebUI.setText(findTestObject('Object Repository/Page_Hasaki.vn  M Phm  Clinic/input_username'), username)

    WebUI.setEncryptedText(findTestObject('Object Repository/Page_Hasaki.vn  M Phm  Clinic/input_password'), password)

    Thread.sleep(3000)

    WebUI.click(findTestObject('Object Repository/Page_Hasaki.vn  M Phm  Clinic/button_ng nhp'))

    // Sẽ có 4 error element là : 
    // - Sai mật khẩu, Sai tên đăng nhập, Không nhập Username, Không nhập Password
    // Cho mảng elements có 4 error elements này
    // 4 error element này tự add bằng XPath trong Object Repository
    TestObject[] elements = [findTestObject('Object Repository/Page_Hasaki.vn  M Phm  Clinic/wrongPassword'), findTestObject(
            'Object Repository/Page_Hasaki.vn  M Phm  Clinic/wrongUsername'), findTestObject('Object Repository/Page_Hasaki.vn  M Phm  Clinic/noUsername')
        , findTestObject('Object Repository/Page_Hasaki.vn  M Phm  Clinic/noPassword')]

    // Nếu nhập username và password đúng => 4 elements trên không xuất hiện => Status = Passed
    String status = 'Passed'

    // Khi nhập sai => 1 trong 4 elements trên sẽ xuất hiện
    // Duyệt từng phần tử trong mảng elements, nếu có 1 trong 4 elemtent đó => Status = Failed
    for (TestObject element : elements) {
        if (WebUI.verifyElementPresent(element, 0, FailureHandling.OPTIONAL)) {
            status = 'Failed'

            println('failed')

            break
        }
    }
    
    // Ghi xuống file excel, cột Status, hàng i
    CustomKeywords.'com.utilities.TestWriteExcel.demoWriteExcel'(status, i, 'Login')

    WebUI.closeBrowser()
}

