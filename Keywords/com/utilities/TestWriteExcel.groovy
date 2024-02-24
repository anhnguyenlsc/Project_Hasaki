package com.utilities

import static com.kms.katalon.core.checkpoint.CheckpointFactory.findCheckpoint
import static com.kms.katalon.core.testcase.TestCaseFactory.findTestCase
import static com.kms.katalon.core.testdata.TestDataFactory.findTestData
import static com.kms.katalon.core.testobject.ObjectRepository.findTestObject
import static com.kms.katalon.core.testobject.ObjectRepository.findWindowsObject

import com.kms.katalon.core.annotation.Keyword
import com.kms.katalon.core.checkpoint.Checkpoint
import com.kms.katalon.core.cucumber.keyword.CucumberBuiltinKeywords as CucumberKW
import com.kms.katalon.core.mobile.keyword.MobileBuiltInKeywords as Mobile
import com.kms.katalon.core.model.FailureHandling
import com.kms.katalon.core.testcase.TestCase
import com.kms.katalon.core.testdata.TestData
import com.kms.katalon.core.testobject.TestObject
import com.kms.katalon.core.webservice.keyword.WSBuiltInKeywords as WS
import com.kms.katalon.core.webui.common.EBrowser
import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUI
import com.kms.katalon.core.windows.keyword.WindowsBuiltinKeywords as Windows

import org.apache.poi.xssf.usermodel.XSSFCell
import org.apache.poi.xssf.usermodel.XSSFRow
import org.apache.poi.xssf.usermodel.XSSFSheet
import org.apache.poi.xssf.usermodel.XSSFWorkbook

import com.kms.katalon.core.configuration.RunConfiguration

import internal.GlobalVariable

public class TestWriteExcel {
	@Keyword
	public void demoWriteExcel(String strTest, int rowNum, String sheetName) throws IOException {
		// Lấy đường dẫn của project
		String path = RunConfiguration.getProjectDir()
		// File excel này sẽ copy và paste ở ngoài, bên trong Katalon sẽ không nhận
		// Nếu muốn xem file excel thì mở Project ở ngoài, vào Data Files
		// Tạo một đối tượng FileInputStream để đọc dữ liệu từ file Excel tại đường dẫn đã cho
		FileInputStream fis = new FileInputStream(path+'\\Data Files\\DataFile.xlsx')
		// Tạo một đối tượng XSSFWorkbook từ FileInputStream để làm việc với file Excel
		XSSFWorkbook workbook = new XSSFWorkbook(fis)
		// Lấy ra sheet từ workbook dựa vào tên sheet được cung cấp
		XSSFSheet sheet = workbook.getSheet(sheetName)

		// rowNum là số thứ tự của hàng, truyền vào từ biến i
		XSSFRow row = sheet.getRow(rowNum)
		if (row == null) {
			row = sheet.createRow(rowNum)
		}
		int colNum = row.getLastCellNum()

		//log ra kiểm tra quá trình chạy
		println('Total number of columns : ' +colNum)
		println('Value in strTest is : ' +strTest)
		// Tạo mới một ô ở cuối hàng
		XSSFCell cell = row.createCell(colNum)
		cell.setCellValue(strTest)
		// Tạo một đối tượng FileOutputStream để ghi dữ liệu vào file Excel tại đường dẫn đã cho
		FileOutputStream fos = new FileOutputStream(path+'\\Data Files\\DataFile.xlsx')
		// Ghi workbook vào FileOutputStream
		workbook.write(fos)
		fos.close()
	}
}

