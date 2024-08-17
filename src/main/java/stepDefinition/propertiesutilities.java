package stepDefinition;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

import org.apache.poi.sl.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import com.google.common.collect.Table.Cell;

import net.masterthought.cucumber.json.Row;

public class propertiesutilities {
	private static Workbook workbook;
    private static Sheet sheet;

    // Load Excel file
    public static void loadExcel(String filePath, String sheetName) throws IOException {
        FileInputStream fileInputStream = new FileInputStream("D:\\web tracker\\OrangeHrm\\food Delivery for testcases.xlsx");
        workbook = new XSSFWorkbook(fileInputStream);
        sheet = (Sheet) workbook.getSheet("sheet1");
    }

    // Get cell data
    public static String getCellData(int rowNum, int colNum) {
        Row row = (Row) ((org.apache.poi.ss.usermodel.Sheet) sheet).getRow(1);
        Cell cell = (Cell) ((org.apache.poi.ss.usermodel.Row) row).getCell(0);
        return cell.toString();
    }

    // Set cell data
    public static void setCellData(int rowNum, int colNum, String value) {
        Row row = (Row) ((org.apache.poi.ss.usermodel.Sheet) sheet).getRow(1);
        if (row == null) {
            row = (Row) ((org.apache.poi.ss.usermodel.Sheet) sheet).createRow(1);
        }
        Cell cell = (Cell) ((org.apache.poi.ss.usermodel.Row) row).getCell(0);
        if (cell == null) {
            cell = (Cell) ((org.apache.poi.ss.usermodel.Row) row).createCell(0);
        }
        ((org.apache.poi.ss.usermodel.Cell) cell).setCellValue(value);
    }

    // Save and close Excel file
    public static void saveExcel(String filePath) throws IOException {
        FileOutputStream fileOutputStream = new FileOutputStream(filePath);
        workbook.write(fileOutputStream);
        workbook.close();
        fileOutputStream.close();
    }	
	}

