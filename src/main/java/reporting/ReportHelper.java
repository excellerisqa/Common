package reporting;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Iterator;

import org.apache.poi.ss.usermodel.BorderStyle;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellStyle;
import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.ss.usermodel.FillPatternType;
import org.apache.poi.ss.usermodel.Font;
import org.apache.poi.ss.usermodel.HorizontalAlignment;
import org.apache.poi.ss.usermodel.IndexedColors;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.VerticalAlignment;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFCellStyle;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import reporting.HTMLReportFormat.ReportData;
import utils.ObjectHelper;

public class ReportHelper {

	public static volatile XSSFWorkbook excelWorkbook;
	public File TestDatafile;
	public static XSSFSheet excelSheet;
	public static XSSFCell Cell;
	public static DataFormatter df;

	public ReportHelper() {
		TestDatafile = new File(new File(".", "//TestData//emailablereport.xlsx").getAbsolutePath());
		FileInputStream fis;
		try {
			fis = new FileInputStream(new File(".", "//TestData//emailablereport.xlsx").getAbsolutePath());

			excelWorkbook = new XSSFWorkbook(fis);
		} catch (Exception e) {
			e.printStackTrace();
		}
		// xls = new XLHandler(new File(new File(".",
		// "//TestData//emailablereport.xlsx").getAbsolutePath()));
	}

	public XSSFWorkbook getworkbook() {
		return excelWorkbook;
	}

	public int getNumberOfRows(int sheetNumber) {
		excelSheet = excelWorkbook.getSheetAt(sheetNumber);
		int NumberOfRows = excelSheet.getLastRowNum() + 1;
		return NumberOfRows;
	}

	public int getNumberOfCols(int sheetNumber, int rownum) {
		excelSheet = excelWorkbook.getSheetAt(sheetNumber);
		int NumberOfCols = excelSheet.getRow(rownum).getLastCellNum() + 1;
		return NumberOfCols;
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

	public String getDatabyCell(int sheetNumber, int row, int column) {
		String cellContent = null;
		excelSheet = excelWorkbook.getSheetAt(sheetNumber);
		Cell = excelSheet.getRow(row).getCell(column);
		df = new DataFormatter();
		cellContent = df.formatCellValue(Cell);
		return cellContent;
	}

	public int getunusedrowFrom(int sheetnumber, int startrow) throws Exception {
		int value = 0;
		try {
			int maxrows = getNumberOfRows(sheetnumber);

			loop: for (int i = startrow; i < maxrows; i++) {
				String data = getDatabyCell(0, i, 1);

				if (data == null || data.isEmpty() || data.equals("")) {
					value = i;
					break loop;
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return value;
	}

	public void setTestResult(String vstsid, String description, String result, String reason) throws Exception {

		XSSFSheet sheet1 = getworkbook().getSheetAt(0);

		// here
		if (HTMLReportFormat.reportList.size() == 0) {
			for (int i = 11; i < getNumberOfRows(0); i++) {
				deletedatainrow(sheet1, i, "");
			}
		}
		int setdataincell = getunusedrowFrom(0, 11);

		CellStyle cellStyle1 = sheet1.getWorkbook().createCellStyle();
		Font font1 = sheet1.getWorkbook().createFont();
		font1.setBold(false);
		font1.setColor(IndexedColors.BLACK.getIndex());
		font1.setFontHeightInPoints((short) 11);
		cellStyle1.setFont(font1);
		// cellStyle1.setFillBackgroundColor(IndexedColors.RED.getIndex());
		// cellStyle1.setFillForegroundColor(IndexedColors.GREY_25_PERCENT.getIndex());
		// cellStyle1.setFillPattern(FillPatternType.SOLID_FOREGROUND);
		cellStyle1.setAlignment(HorizontalAlignment.CENTER);
		cellStyle1.setVerticalAlignment(VerticalAlignment.CENTER);
		cellStyle1.setBorderBottom(BorderStyle.THIN);
		cellStyle1.setBorderTop(BorderStyle.THIN);
		cellStyle1.setBorderLeft(BorderStyle.THIN);
		cellStyle1.setBorderRight(BorderStyle.THIN);

		sheet1.createRow(setdataincell);

		// Set VSTSID
		sheet1.getRow(setdataincell).createCell(1).setCellStyle(cellStyle1);
		sheet1.getRow(setdataincell).getCell(1).setCellValue(vstsid);

		// Set VSTSID
		sheet1.getRow(setdataincell).createCell(2).setCellStyle(cellStyle1);
		sheet1.getRow(setdataincell).getCell(2).setCellValue(description);

		// Set VSTSID
		sheet1.getRow(setdataincell).createCell(4).setCellStyle(cellStyle1);
		sheet1.getRow(setdataincell).getCell(4).setCellValue(result.toUpperCase());

		// Set VSTSID
		sheet1.getRow(setdataincell).createCell(5).setCellStyle(cellStyle1);
		sheet1.getRow(setdataincell).getCell(5).setCellValue(reason);

		CellStyle cellstyle2 = sheet1.getWorkbook().createCellStyle();
		cellstyle2.setBorderBottom(BorderStyle.THIN);
		cellstyle2.setBorderTop(BorderStyle.THIN);
		cellstyle2.setBorderLeft(BorderStyle.THIN);
		cellstyle2.setBorderRight(BorderStyle.THIN);
		sheet1.getRow(setdataincell).createCell(3).setCellStyle(cellstyle2);

		FileOutputStream fos = new FileOutputStream(TestDatafile);
		excelWorkbook.write(fos);

		HTMLReportFormat.reportList.add(new ReportData(vstsid, description, result.toUpperCase(), reason));
	}

	public static void setStartEmailInfo() {
		Date todaydate = new Date();
		SimpleDateFormat DATE_FORMAT = new SimpleDateFormat("dd/MM/yyyy");
		SimpleDateFormat TIME_FORMAT = new SimpleDateFormat("hh:mm a");

		ObjectHelper.startdate = DATE_FORMAT.format(todaydate);
		ObjectHelper.starttime = TIME_FORMAT.format(todaydate);
	}

	public static void setCloseEmailInfo() {
		Date todaydate = new Date();
		SimpleDateFormat TIME_FORMAT = new SimpleDateFormat("hh:mm a");

		ObjectHelper.endtime = TIME_FORMAT.format(todaydate);
	}

	public void formatting() throws Exception {

		// Workbook workbook = WorkbookFactory.create(new File(new File(".",
		// "//TestData//emailablereport.xlsx").getAbsolutePath()));
		XSSFSheet sheet = getworkbook().getSheetAt(0);

		XSSFCellStyle mycellstyle = getworkbook().createCellStyle();
		mycellstyle.setAlignment(HorizontalAlignment.CENTER);
		mycellstyle.setVerticalAlignment(VerticalAlignment.CENTER);

		CellStyle cellStyle = sheet.getWorkbook().createCellStyle();
		Font font = sheet.getWorkbook().createFont();
		font.setBold(true);
		font.setColor(IndexedColors.RED.getIndex());
		font.setFontHeightInPoints((short) 15);
		cellStyle.setFont(font);
		cellStyle.setFillBackgroundColor(IndexedColors.RED.getIndex());
		cellStyle.setFillForegroundColor(IndexedColors.WHITE.getIndex());
		cellStyle.setFillPattern(FillPatternType.SOLID_FOREGROUND);
		cellStyle.setAlignment(HorizontalAlignment.CENTER);
		cellStyle.setVerticalAlignment(VerticalAlignment.CENTER);
		cellStyle.setBorderBottom(BorderStyle.THICK);
		cellStyle.setBorderTop(BorderStyle.THICK);
		cellStyle.setBorderLeft(BorderStyle.THICK);
		cellStyle.setBorderRight(BorderStyle.THICK);

		CellStyle cellStyleBorderThick = sheet.getWorkbook().createCellStyle();

		cellStyleBorderThick.setBorderBottom(BorderStyle.THICK);
		cellStyleBorderThick.setBorderTop(BorderStyle.THICK);
		cellStyleBorderThick.setBorderLeft(BorderStyle.THICK);
		cellStyleBorderThick.setBorderRight(BorderStyle.THICK);

		sheet.getRow(1).getCell(1).setCellStyle(cellStyleBorderThick);
		sheet.getRow(1).getCell(2).setCellStyle(cellStyleBorderThick);
		sheet.getRow(1).getCell(3).setCellStyle(cellStyleBorderThick);
		sheet.getRow(1).getCell(4).setCellStyle(cellStyleBorderThick);
		sheet.getRow(1).getCell(5).setCellStyle(cellStyleBorderThick);

		// Set Title
		sheet.getRow(1).getCell(1).setCellStyle(cellStyle);
		sheet.getRow(1).getCell(1).setCellValue(ObjectHelper.testtitle);

		CellStyle cellStyle1 = sheet.getWorkbook().createCellStyle();
		Font font1 = sheet.getWorkbook().createFont();
		font1.setBold(true);
		font1.setColor(IndexedColors.BLACK.getIndex());
		font1.setFontHeightInPoints((short) 15);
		cellStyle1.setFont(font1);
		cellStyle1.setFillBackgroundColor(IndexedColors.RED.getIndex());
		cellStyle1.setFillForegroundColor(IndexedColors.GREY_25_PERCENT.getIndex());
		cellStyle1.setFillPattern(FillPatternType.SOLID_FOREGROUND);
		cellStyle1.setAlignment(HorizontalAlignment.CENTER);
		cellStyle1.setVerticalAlignment(VerticalAlignment.CENTER);
		cellStyle1.setBorderBottom(BorderStyle.THIN);
		cellStyle1.setBorderTop(BorderStyle.THIN);
		cellStyle1.setBorderLeft(BorderStyle.THIN);
		cellStyle1.setBorderRight(BorderStyle.THIN);

		// Set Date
		sheet.getRow(3).getCell(3).setCellStyle(cellStyle1);
		sheet.getRow(3).getCell(3).setCellValue(ObjectHelper.startdate);
		// Set Start Time
		sheet.getRow(4).getCell(3).setCellStyle(cellStyle1);
		sheet.getRow(4).getCell(3).setCellValue(ObjectHelper.starttime);
		// Set End Time
		sheet.getRow(5).getCell(3).setCellStyle(cellStyle1);
		sheet.getRow(5).getCell(3).setCellValue(ObjectHelper.endtime);

		CellStyle cellStyle2 = sheet.getWorkbook().createCellStyle();
		Font font2 = sheet.getWorkbook().createFont();
		font2.setBold(true);
		font2.setColor(IndexedColors.BLACK.getIndex());
		font2.setFontHeightInPoints((short) 15);
		cellStyle2.setFont(font2);
		cellStyle2.setFillBackgroundColor(IndexedColors.RED.getIndex());
		cellStyle2.setFillForegroundColor(IndexedColors.YELLOW.getIndex());
		cellStyle2.setFillPattern(FillPatternType.SOLID_FOREGROUND);
		cellStyle2.setAlignment(HorizontalAlignment.CENTER);
		cellStyle2.setVerticalAlignment(VerticalAlignment.CENTER);
		cellStyle2.setBorderBottom(BorderStyle.THIN);
		cellStyle2.setBorderTop(BorderStyle.THIN);
		cellStyle2.setBorderLeft(BorderStyle.THIN);
		cellStyle2.setBorderRight(BorderStyle.THIN);

		// Set Total Tests
		sheet.getRow(6).getCell(3).setCellStyle(cellStyle2);
		sheet.getRow(6).getCell(3).setCellValue(ObjectHelper.totaltests);

		CellStyle cellStyle3 = sheet.getWorkbook().createCellStyle();
		Font font3 = sheet.getWorkbook().createFont();
		font3.setBold(true);
		font3.setColor(IndexedColors.BLACK.getIndex());
		font3.setFontHeightInPoints((short) 15);
		cellStyle3.setFont(font3);
		cellStyle3.setFillBackgroundColor(IndexedColors.RED.getIndex());
		cellStyle3.setFillForegroundColor(IndexedColors.BRIGHT_GREEN1.getIndex());
		cellStyle3.setFillPattern(FillPatternType.SOLID_FOREGROUND);
		cellStyle3.setAlignment(HorizontalAlignment.CENTER);
		cellStyle3.setVerticalAlignment(VerticalAlignment.CENTER);
		cellStyle3.setBorderBottom(BorderStyle.THIN);
		cellStyle3.setBorderTop(BorderStyle.THIN);
		cellStyle3.setBorderLeft(BorderStyle.THIN);
		cellStyle3.setBorderRight(BorderStyle.THIN);

		// Set Total Passed
		sheet.getRow(7).getCell(3).setCellStyle(cellStyle3);
		sheet.getRow(7).getCell(3).setCellValue(ObjectHelper.totaltests - ObjectHelper.totalfailed);

		CellStyle cellStyle4 = sheet.getWorkbook().createCellStyle();
		Font font4 = sheet.getWorkbook().createFont();
		font4.setBold(true);
		font4.setColor(IndexedColors.BLACK.getIndex());
		font4.setFontHeightInPoints((short) 15);
		cellStyle4.setFont(font4);
		cellStyle4.setFillBackgroundColor(IndexedColors.RED.getIndex());
		cellStyle4.setFillForegroundColor(IndexedColors.RED.getIndex());
		cellStyle4.setFillPattern(FillPatternType.SOLID_FOREGROUND);
		cellStyle4.setAlignment(HorizontalAlignment.CENTER);
		cellStyle4.setVerticalAlignment(VerticalAlignment.CENTER);
		cellStyle4.setBorderBottom(BorderStyle.THIN);
		cellStyle4.setBorderTop(BorderStyle.THIN);
		cellStyle4.setBorderLeft(BorderStyle.THIN);
		cellStyle4.setBorderRight(BorderStyle.THIN);

		// Set Total Failed
		sheet.getRow(8).getCell(3).setCellStyle(cellStyle4);
		sheet.getRow(8).getCell(3).setCellValue(ObjectHelper.totalfailed);

		FileOutputStream fos = new FileOutputStream(TestDatafile);
		excelWorkbook.write(fos);
	}

	public void autoSizeColumns(Workbook workbook) {
		int numberOfSheets = workbook.getNumberOfSheets();
		for (int i = 0; i < numberOfSheets; i++) {
			Sheet sheet = workbook.getSheetAt(i);
			if (sheet.getPhysicalNumberOfRows() > 0) {
				Row row = sheet.getRow(0);
				Iterator<Cell> cellIterator = row.cellIterator();
				while (cellIterator.hasNext()) {
					Cell cell = cellIterator.next();
					int columnIndex = cell.getColumnIndex();
					sheet.autoSizeColumn(columnIndex);
				}
			}
		}
	}

	// @SuppressWarnings("deprecation")
	// public void converttoPDF() throws Exception {
	// // First we read the XLSX in binary format into FileInputStream
	// FileInputStream input_document = new FileInputStream(new File(".",
	// "//TestData//emailablereport.xlsx").getAbsolutePath());
	// // Read workbook into XSSFWorkbook
	// XSSFWorkbook my_xls_workbook = new XSSFWorkbook(input_document);
	// // Read worksheet into XSSFSheet
	// XSSFSheet my_worksheet = my_xls_workbook.getSheetAt(0);
	// // To iterate over the rows
	// Iterator<Row> rowIterator = my_worksheet.iterator();
	// // We will create output PDF document objects at this point
	// Document iText_xls_2_pdf = new Document();
	// PdfWriter.getInstance(iText_xls_2_pdf, new FileOutputStream(new File(".",
	// "//TestData//emailablereport.pdf").getAbsolutePath()));
	// iText_xls_2_pdf.open();
	// // we have two columns in the Excel sheet, so we create a PDF table with two
	// // columns
	// PdfPTable my_table = new PdfPTable(5);
	// // cell object to capture data
	// PdfPCell table_cell;
	// // Loop through rows.
	// while (rowIterator.hasNext()) {
	// Row row = rowIterator.next();
	// Iterator<Cell> cellIterator = row.cellIterator();
	// while (cellIterator.hasNext()) {
	// Cell cell = cellIterator.next(); // Fetch CELL
	// switch (cell.getCellType()) { // Identify CELL type
	//
	// case Cell.CELL_TYPE_STRING:
	// // Push the data from Excel to PDF Cell
	// table_cell = new PdfPCell(new Phrase(cell.getStringCellValue()));
	// my_table.addCell(table_cell);
	// break;
	// }
	// // next line
	// }
	//
	// }
	// // Finally add the table to PDF document
	// iText_xls_2_pdf.add(my_table);
	// iText_xls_2_pdf.close();
	// // we created our pdf file..
	// input_document.close(); // close xlsx
	// my_xls_workbook.close();
	// }

	public static void main(String[] args) throws Exception {
		setStartEmailInfo();
		setCloseEmailInfo();

		ReportHelper rh = new ReportHelper();
		rh.formatting();
		for (int i = 0; i < 3; i++) {
			rh.setTestResult("10689", "Testing", "Pass", "Nothing");
		}

	}
}
