package cn.ebing.dog.api.utils;

import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.util.IOUtils;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class AccessExcelUitl {

	public static List<List<String>> readExcel(String sourceFilePath) {
		Workbook workbook = null;
		try {
			workbook = getReadWorkBookType(sourceFilePath);
		} catch (Exception e) {
			e.printStackTrace();
		}
		List<List<String>> result = new ArrayList<List<String>>();

		//获取第一个sheet
		Sheet sheet = workbook.getSheetAt(0);

		int maxRow = sheet.getPhysicalNumberOfRows();
		int maxCol = sheet.getRow(0).getPhysicalNumberOfCells();

		for (int rowNum = 1; rowNum < maxRow; rowNum++) {
			Row row = sheet.getRow(rowNum);
			List<String> rows = new ArrayList<String>();
			for (int col = 0; col < maxCol; col++) {
				Cell cell = row.getCell(col);
				rows.add(getCellValue(cell));
			}
			result.add(rows);
		}
		return result;
	}

	private Workbook getWriteWorkBoolType(String filePath) throws Exception {
		if (filePath.toLowerCase().endsWith("xlsx")) {
			return new XSSFWorkbook();
		} else if (filePath.toLowerCase().endsWith("xls")) {
			return new HSSFWorkbook();
		} else {
			throw new Exception("zdfds");
		}
	}

	private static Workbook getReadWorkBookType(String filePath) throws Exception {
		//xls-2003, xlsx-2007
		FileInputStream is = null;

		try {
			is = new FileInputStream(filePath);
			if (filePath.toLowerCase().endsWith("xlsx")) {
				return new XSSFWorkbook(is);
			} else if (filePath.toLowerCase().endsWith("xls")) {
				return new HSSFWorkbook(is);
			} else {
				throw new Exception("文件类型异常");
			}
		} catch (IOException e) {
			//  抛出自定义的业务异常
			throw new Exception("文件 IO 异常");
		} finally {
			IOUtils.closeQuietly(is);
		}
	}

	/**
	 * 判断单元格类型取值
	 */
	private static String getCellValue(Cell cell) {
		if (cell == null) {
			return "";
		}
		String value = "";
		switch (cell.getCellType()) {
			case Cell.CELL_TYPE_BLANK: value = ""; break;
			case Cell.CELL_TYPE_FORMULA: value = String.valueOf(cell.getNumericCellValue()); break;
			case Cell.CELL_TYPE_STRING: value = cell.getStringCellValue(); break;
			case Cell.CELL_TYPE_BOOLEAN: value = String.valueOf(cell.getBooleanCellValue()); break;
			case Cell.CELL_TYPE_ERROR: value = String.valueOf(cell.getErrorCellValue()); break;
			default: value = "";
		}
		return value;
	}
}
