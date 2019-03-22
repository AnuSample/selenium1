package seleniumday1;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;

public class ExcelSheet {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub

		String dt_path = "/Users/PraveenPillai/Desktop/testcases.xls";
		String[][] recData = readExceldata(dt_path, "Sheet1");

		for (int i = 0; i < recData.length; i++) {
			for (int j = 0; j < recData[0].length; j++) {

				System.out.print(recData[i][j] + "  ");
			}
			System.out.println();
		}
	}

	public static String[][] readExceldata(String dataTablepath, String sheetName) throws IOException {
		String dt_path = "/Users/PraveenPillai/Desktop/testcases.xls";
		/* Step1: Get the xl path */
		File xlfile = new File(dataTablepath);

		// Step 2: Access the xl file
		FileInputStream xlDoc = new FileInputStream(xlfile);

		// Step 3: Access the workbook;
		HSSFWorkbook wb = new HSSFWorkbook(xlDoc);

		// Step 4: Access the excel sheet
		HSSFSheet sheet = wb.getSheet(sheetName);

		String val;
		int iRowCount = sheet.getLastRowNum() + 1;
		int iColCount = sheet.getRow(0).getLastCellNum();
		String[][] xlData = new String[iRowCount][iColCount];

		// String val=sheet.getRow(3).getCell(1).getStringCellValue();
		// System.out.println(val);

		for (int i = 0; i < iRowCount; i++) {
			for (int j = 0; j < iColCount; j++) {
				xlData[i][j] = sheet.getRow(i).getCell(j).getStringCellValue();

				
			}
		}
		return xlData;
	}

}

/*
 * String dt_path = "/Users/PraveenPillai/Desktop/testcases.xls"; Step1: Get the
 * xl path File xlfile = new File(dt_path);
 * 
 * // Step 2: Access the xl file FileInputStream xlDoc = new
 * FileInputStream(xlfile);
 * 
 * // Step 3: Access the workbook; HSSFWorkbook wb = new HSSFWorkbook(xlDoc);
 * 
 * // Step 4: Access the excel sheet HSSFSheet sheet = wb.getSheet("Sheet1");
 * 
 * String val; int iRowCount = sheet.getLastRowNum() + 1; int iColCount =
 * sheet.getRow(0).getLastCellNum(); System.out.println(iRowCount);
 * System.out.println(iColCount);
 * 
 * // String val=sheet.getRow(3).getCell(1).getStringCellValue(); //
 * System.out.println(val);
 * 
 * for (int i = 0; i < iRowCount; i++) { for (int j = 0; j < iColCount; j++) {
 * val = sheet.getRow(i).getCell(j).getStringCellValue();
 * 
 * System.out.print(val+ "  "); } System.out.println(); }
 */