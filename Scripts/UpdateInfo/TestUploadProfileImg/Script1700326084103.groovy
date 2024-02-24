import static com.kms.katalon.core.checkpoint.CheckpointFactory.findCheckpoint
import static com.kms.katalon.core.testcase.TestCaseFactory.findTestCase
import static com.kms.katalon.core.testdata.TestDataFactory.findTestData
import static com.kms.katalon.core.testobject.ObjectRepository.findTestObject
import static com.kms.katalon.core.testobject.ObjectRepository.findWindowsObject
import com.kms.katalon.core.util.KeywordUtil as KeywordUtil
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

// Lấy giá trị thuộc tính 'src' ban đầu
String originalSrc = WebUI.getAttribute(findTestObject('Object Repository/Page_Thng Tin Ti khon  Hasaki.vn/imgavatarImg'), 
    'https://hasaki.vn/images/graphics/account-full.svg')

WebUI.click(findTestObject('Object Repository/Page_Thng Tin Ti khon  Hasaki.vn/imgavatarImg'))

WebUI.click(findTestObject('Object Repository/Page_Thng Tin Ti khon  Hasaki.vn/a_Ti nh ca bn'))

WebUI.click(findTestObject('Object Repository/Page_Thng Tin Ti khon  Hasaki.vn/div_Ti nh ca bn'))

// Lấy giá trị thuộc tính 'src' sau khi tải lên
String newSrc = WebUI.getAttribute(findTestObject('Object Repository/Page_Thng Tin Ti khon  Hasaki.vn/imgavatarImg'), 'https://hasaki.vn/images/graphics/account-full.svg')

//So sánh 2 src
if (originalSrc.equals(newSrc)) {
    KeywordUtil.markFailed('Test case failed: Không thể tải lên hình ảnh')
} else {
    println('Hình ảnh đã được tải lên thành công')
}

WebUI.closeBrowser()

