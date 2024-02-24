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

WebUI.mouseOver(findTestObject('Object Repository/Page_Hasaki.vn  M Phm  Clinic/img_lazy loaded'))

// Kiểm tra xem nút "Next" có hiển thị hay không
if (WebUI.waitForElementVisible(findTestObject('Object Repository/Page_Hasaki.vn  M Phm  Clinic/a_Next'), 10, FailureHandling.OPTIONAL)) {
    println('Nút "Next" đã hiển thị.')
} else {
    println('Nút "Next" không hiển thị.')
}

// Kiểm tra xem nút "Previous" có hiển thị hay không
if (WebUI.waitForElementVisible(findTestObject('Object Repository/Page_Hasaki.vn  M Phm  Clinic/a_Previous'), 10, FailureHandling.OPTIONAL)) {
    println('Nút "Previous" đã hiển thị.')
} else {
    println('Nút "Previous" không hiển thị.')
}

WebUI.closeBrowser()


