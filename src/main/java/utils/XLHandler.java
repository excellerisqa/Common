package utils;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.util.Arrays;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class XLHandler {

	public XSSFWorkbook excelWorkbook;
	public XSSFSheet excelSheet;
	public XSSFCell Cell;
	public DataFormatter df;

	public File TestDatafile;

	public XLHandler(String relativepath) {
		TestDatafile = new File(new File(".", relativepath).getAbsolutePath());
		FileInputStream fis;
		try {
			fis = new FileInputStream(new File(".", relativepath).getAbsolutePath());

			excelWorkbook = new XSSFWorkbook(fis);			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public XLHandler(File filepath) {
		TestDatafile = filepath;
		FileInputStream fis;
		try {
			fis = new FileInputStream(filepath);

			excelWorkbook = new XSSFWorkbook(fis);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public XSSFWorkbook getworkbook() {
		return excelWorkbook;
	}

	public int getunusedrow(int sheetnumber, String testtype, String testcaseid) throws Exception {
		int value = 0;
		try {
			int maxrows = getNumberOfRows(sheetnumber);
			int maxcols = getNumberOfCols(sheetnumber);

			for (int i = 1; i < maxrows; i++) {
				if (getDatabyCell(sheetnumber, i, maxcols - 4).contains(testtype) && getDatabyCell(sheetnumber, i, maxcols - 3).equals("No")) {
					value = i;
					if (testcaseid != null) {
						setDatabyCell(sheetnumber, i, maxcols - 3, "Yes");
						setDatabyCell(sheetnumber, i, maxcols - 2, testcaseid);
					}
					break;
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return value;
	}

	public int getunusedrow(int sheetnumber, String testtype, String testcaseid, int testTypeColNum, int usedColNum) throws Exception {
		int value = 0;
		try {
			int maxrows = getNumberOfRows(sheetnumber);
			for (int i = 1; i < maxrows; i++) {
				if (getDatabyCell(sheetnumber, i, testTypeColNum).contains(testtype) && getDatabyCell(sheetnumber, i, usedColNum).equals("No")) {
					value = i;
					setDatabyCell(sheetnumber, i, usedColNum, "Yes");
					setDatabyCell(sheetnumber, i, usedColNum + 1, testcaseid);
					break;
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return value;
	}

	public int getunusedrowFrom(int sheetnumber, int startrow, String testcaseid) throws Exception {
		int value = 0;
		try {
			int maxrows = getNumberOfRows(sheetnumber);
			int maxcols = getNumberOfCols(sheetnumber);

			loop: for (int i = startrow; i < maxrows; i++) {
				String data = getDatabyCell(sheetnumber, i, 1);

				if (data == null || data.isEmpty() || data.equals("")) {
					value = i;
					if (testcaseid != null) {
						setDatabyCell(sheetnumber, i, maxcols - 3, "Yes");
						setDatabyCell(sheetnumber, i, maxcols - 2, testcaseid);
					}
					break loop;
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return value;
	}

	public int getrownumofvalue(String value, int sheetnumber, String filename, String testcaseid) throws Exception {
		int values = 0;

		int maxrows = getNumberOfRows(sheetnumber);
		int maxcols = getNumberOfCols(sheetnumber);

		for (int i = 1; i < maxrows; i++) {
			String[] data = readexcel(sheetnumber, i, filename);
			// search for string in array string
			if (Arrays.asList(data).contains(value)) {
				values = i;
				if (testcaseid != null) {
					setDatabyCell(sheetnumber, i, maxcols - 3, "Yes");
					setDatabyCell(sheetnumber, i, maxcols - 2, testcaseid);
				}
				break;
			}
		}
		return values;
	}

	public int getrownumofMatchingtwovalue(String value, String value1, int sheetnumber, String filename, String testcaseid) throws Exception {
		int values = 0;

		int maxrows = getNumberOfRows(sheetnumber);
		int maxcols = getNumberOfCols(sheetnumber);

		for (int i = 1; i < maxrows; i++) {
			String[] data = readexcel(sheetnumber, i, filename);
			// search for string in array string
			if (Arrays.asList(data).contains(value) && Arrays.asList(data).contains(value1)) {
				values = i;
				if (testcaseid != null) {
					setDatabyCell(sheetnumber, i, maxcols - 3, "Yes");
					setDatabyCell(sheetnumber, i, maxcols - 2, testcaseid);
				}
				break;
			}
		}
		return values;
	}

	public String getDatabyCell(int sheetNumber, int row, int column) throws Exception {
		String cellContent = null;
		excelSheet = excelWorkbook.getSheetAt(sheetNumber);
		Cell = excelSheet.getRow(row).getCell(column);
		df = new DataFormatter();
		cellContent = df.formatCellValue(Cell);
		return cellContent;
	}

	public void setDatabyCell(int sheetNumber, int row, int column, String value) throws Exception {

		excelSheet = excelWorkbook.getSheetAt(sheetNumber);
		if (excelSheet.getRow(row) == null) {
			excelSheet.createRow(row);
		}
		excelSheet.getRow(row).createCell(column).setCellValue(value);
		FileOutputStream fos = new FileOutputStream(TestDatafile);
		excelWorkbook.write(fos);
	}

	public void setDatabyCell(String sheetName, int row, int column, String value) throws Exception {

		excelSheet = excelWorkbook.getSheet(sheetName);
		if (excelSheet.getRow(row) == null) {
			excelSheet.createRow(row);
		}
		excelSheet.getRow(row).createCell(column).setCellValue(value);
		FileOutputStream fos = new FileOutputStream(TestDatafile);
		excelWorkbook.write(fos);
	}

	public void setDatabyCell(String sheetName, String dataName, int column, String value) throws Exception {

		excelSheet = excelWorkbook.getSheet(sheetName);
		int row = 0;
		for (int i = 0; i <= excelSheet.getLastRowNum(); i++) {
			Cell c = excelSheet.getRow(i).getCell(0);
			if (df.formatCellValue(c).equalsIgnoreCase(dataName)) {
				row = i;
				break;
			}
		}
		excelSheet.getRow(row).createCell(column).setCellValue(value);
		FileOutputStream fos = new FileOutputStream(TestDatafile);
		excelWorkbook.write(fos);
	}

	public int getNumberOfRows(int sheetNumber) {
		excelSheet = excelWorkbook.getSheetAt(sheetNumber);
		int NumberOfRows = excelSheet.getLastRowNum() + 1;
		return NumberOfRows;
	}

	/*
	 * DESCRIPTION: finds the total number of sheets in the file with which
	 * XLHandler is instantiated PARAMETER: none RETURNS : number of sheets in the
	 * file with which XLHandler is instantiated AUTHOR: Bhavna Karanjekar Modified
	 * By:
	 */
	public int getNumberOfSheets() {
		return excelWorkbook.getNumberOfSheets();
	}

	public int getNumberOfCols(int sheetNumber) {
		excelSheet = excelWorkbook.getSheetAt(sheetNumber);
		int NumberOfCols = excelSheet.getRow(0).getLastCellNum() + 1;
		return NumberOfCols;
	}

	public int getNumberOfCols(int sheetNumber, int rownum) {
		excelSheet = excelWorkbook.getSheetAt(sheetNumber);
		int NumberOfCols = excelSheet.getRow(rownum).getLastCellNum() + 1;
		return NumberOfCols;
	}

	@SuppressWarnings("unused")
	public static String[] readexcel(int sheetnumber, int row1, String filename) {
		String[] value = null; // 0 = value, 1 = value, 2 = value
		try {
			Workbook workbook = WorkbookFactory.create(new File(new File(".", "//TestData//" + filename).getAbsolutePath()));
			Sheet sheet = workbook.getSheetAt(sheetnumber);
			DataFormatter dataFormatter = new DataFormatter();
			int count = 1;
			for (Cell cell : sheet.getRow(row1)) {
				count++;
			}
			value = new String[count];
			for (Cell cell : sheet.getRow(row1)) {
				value[cell.getColumnIndex()] = dataFormatter.formatCellValue(cell);
			}
			workbook.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return value;
	}

	@SuppressWarnings("unused")
	public static void writeexcel(int sheetnumber, int row1, String value, String filename) {

		try {
			FileInputStream file = new FileInputStream(new File(".", "//TestData//" + filename).getAbsolutePath());
			XSSFWorkbook book = new XSSFWorkbook(file);
			XSSFSheet sheet = book.getSheetAt(sheetnumber);

			int count = 0;
			for (Cell cell : sheet.getRow(row1)) {
				count++;
			}

			Row row = sheet.getRow(row1);
			row.createCell(count);
			Cell column = row.getCell(count);
			column.setCellValue(value);
			file.close();
			FileOutputStream out = new FileOutputStream(new File(".", "//TestData//" + filename).getAbsolutePath());
			book.write(out);
			out.close();
			book.close();

		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	@SuppressWarnings("unused")
	public static void writeexcelAppendAtEnd(int sheetnumber, int row1, String value, String filename) {

		try {
			FileInputStream file = new FileInputStream(new File(".", "//TestData//" + filename).getAbsolutePath());
			XSSFWorkbook book = new XSSFWorkbook(file);
			XSSFSheet sheet = book.getSheetAt(sheetnumber);

			int count = 0;
			for (Cell cell : sheet.getRow(row1)) {
				count++;
			}
			count++; // adds after the last cell having data
			Row row = sheet.getRow(row1);
			row.createCell(count);
			Cell column = row.getCell(count);
			column.setCellValue(value);
			file.close();
			FileOutputStream out = new FileOutputStream(new File(".", "//TestData//" + filename).getAbsolutePath());
			book.write(out);
			out.close();
			book.close();

		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	public String getTCstepdata(int sheetnumber, String testcaseid, int stepnum, int colnum) throws Exception {
		String data = null;

		int maxrows = getNumberOfRows(sheetnumber);

		for (int i = 1; i < maxrows; i++) {
			if (getDatabyCell(sheetnumber, i, 0).equals("id:" + testcaseid)) {

				data = getDatabyCell(sheetnumber, i + stepnum, colnum);

				break;
			}
		}

		return data;
	}

	/*
	 * returns the string from the second column when the testDataName matches the
	 * first column Eg - TestData file contains "City" in row1Column0 and
	 * "Vancouver" in row1Column1,
	 * readCorrespondingValueFromTestDataName("<sheetName>","City") would return
	 * "Vancouver"
	 */
	public String readCorrespondingValueFromTestDataName(String sheetName, String testDataName) {
		String cellContent = null;
		excelSheet = excelWorkbook.getSheet(sheetName);
		df = new DataFormatter();
		for (int i = 0; i <= excelSheet.getLastRowNum(); i++) {
			if (excelSheet.getRow(i) == null) {
				excelSheet.createRow(i);
			}
			if (excelSheet.getRow(i).getCell(0) == null) {
				excelSheet.getRow(i).createCell(0);
			}

			Cell c = excelSheet.getRow(i).getCell(0);
			if (df.formatCellValue(c).equalsIgnoreCase(testDataName)) {
				cellContent = df.formatCellValue(excelSheet.getRow(i).getCell(1));
				break;
			}
		}
		return cellContent;
	}

	public int getNumberOfRows(String sheetName) {
		excelSheet = excelWorkbook.getSheet(sheetName);
		int numOfRows = excelSheet.getLastRowNum() + 1;
		return numOfRows;
	}

	public String getDatabyCell(String sheetName, int row, int column) {
		String cellContent = null;
		excelSheet = excelWorkbook.getSheet(sheetName);
		Cell = excelSheet.getRow(row).getCell(column);
		df = new DataFormatter();
		cellContent = df.formatCellValue(Cell);
		return cellContent;
	}

	@SuppressWarnings("unused")
	public static String[] readexcel(String sheetname, int row1, String filename) {
		String[] value = null; // 0 = value, 1 = value, 2 = value
		try {
			Workbook workbook = WorkbookFactory.create(new File(new File(".", "\\TestData\\" + filename).getAbsolutePath()));
			Sheet sheet = workbook.getSheet(sheetname);
			DataFormatter dataFormatter = new DataFormatter();
			int count = 0;
			for (Cell cell : sheet.getRow(row1)) {
				count++;
			}
			value = new String[count];
			for (Cell cell : sheet.getRow(row1)) {
				value[cell.getColumnIndex()] = dataFormatter.formatCellValue(cell);
			}
			workbook.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return value;
	}

	@SuppressWarnings("unused")
	public String[] readRow(String sheetName, int rowNum) {
		String[] value = null;
		try {
			Sheet sheet = excelWorkbook.getSheet(sheetName);
			DataFormatter dataFormatter = new DataFormatter();
			int count = 0;
			for (Cell cell : sheet.getRow(rowNum)) {
				count++;
			}
			value = new String[count];
			for (Cell cell : sheet.getRow(rowNum)) {
				value[cell.getColumnIndex()] = dataFormatter.formatCellValue(cell);
			}
			// excelWorkbook.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return value;
	}

	public String[] readRow(String sheetName, String dataName) {
		String[] value = null;
		int rowNum = 0;
		excelSheet = excelWorkbook.getSheet(sheetName);
		df = new DataFormatter();
		for (int i = 0; i <= excelSheet.getLastRowNum(); i++) {
			Cell c = excelSheet.getRow(i).getCell(0);
			if (df.formatCellValue(c).equalsIgnoreCase(dataName)) {
				rowNum = i;
				break;
			}
		}

		try {
			// Sheet sheet = excelWorkbook.getSheet(sheetName);
			// DataFormatter dataFormatter = new DataFormatter();
			int count = 0;
			for (@SuppressWarnings("unused")
			Cell cell : excelSheet.getRow(rowNum)) {
				count++;
			}
			value = new String[count];
			for (Cell cell : excelSheet.getRow(rowNum)) {
				value[cell.getColumnIndex()] = df.formatCellValue(cell);
			}
			// excelWorkbook.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return value;
	}

	public void deletedatainrow(XSSFSheet sheet, int row1, String value) {
		try {

			int maxcols = getNumberOfCols(0, row1);

			for (int i = 1; i < maxcols; i++) {
				Row row = sheet.getRow(row1);
				row.createCell(i);
				Cell column = row.getCell(i);
				column.setCellValue(value);
			}

		} catch (Exception e) {
			e.printStackTrace();
		}

	}
}
