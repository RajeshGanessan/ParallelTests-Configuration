
package testng;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ExcelUtils {

	static XSSFWorkbook workbook;
	static XSSFCell cell;
	static XSSFRow row;
	static XSSFSheet sheet;
	static FileInputStream file;
	static FileOutputStream outputFile;

	public ExcelUtils(String excelPath, String sheetName) {

		try {
			file = new FileInputStream(new File(excelPath));
			workbook = new XSSFWorkbook(file);
			sheet = workbook.getSheet(sheetName);

		} catch (IOException e) {
			e.printStackTrace();
		}

	}

	// To get the no of rows
	public int getRowCount() {

		try {

			int rowCount = sheet.getPhysicalNumberOfRows();
			return rowCount;
		} catch (Exception e) {
			System.out.println(e.getMessage());
			e.printStackTrace();
			return 0;
		}

	}

	// To get String cell value
	public String getCellData(int rowNum, int celNum) throws IOException {

		String cellValue = null;

		try {

			cellValue = sheet.getRow(rowNum).getCell(celNum).toString();
			return cellValue;

		} catch (Exception e) {
			System.out.println(e.getMessage());
			e.printStackTrace();
			return null;
		} finally {
			file.close();
		}
	}

	// To get cell value from different Sheet
	public String getCellDataFromSheet(int rowNum, int cellNum, String sheetName) throws IOException {

		sheet = workbook.getSheet(sheetName);

		String cellVal = "";
		try {

			cellVal = sheet.getRow(rowNum).getCell(cellNum).toString();
			return cellVal;
		} catch (Exception e) {
			System.out.println(e.getMessage());
			e.printStackTrace();
			return null;
		} finally {
			file.close();
		}

	}

	// To get numeric Value
	public double getCellNumeric(int rowNum, int celNum) {

		try {

			double cellValue = sheet.getRow(rowNum).getCell(celNum).getNumericCellValue();
			return cellValue;
		} catch (Exception e) {
			e.printStackTrace();
			return 0;
		}
	}

	// to set Stringvalue
	public void setCellData(int rowNum, int celNum, String data) throws IOException {

		try {
			row = sheet.getRow(rowNum);
			if (row == null) {

				row = sheet.createRow(rowNum);

				row.createCell(celNum).setCellValue(data);
			} else {
				row.createCell(celNum).setCellValue(data);

			}

		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();

		} finally {
			file.close();
			outputFile = new FileOutputStream(
					new File(System.getProperty("user.dir") + "/src/main/java/TestData/ExcelData.xlsx"));
			workbook.write(outputFile);
			outputFile.close();
		}
	}
}
