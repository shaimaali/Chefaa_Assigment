package utils;

import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.File;
import java.io.FileInputStream;

public class ReadTestDataFromExcelFile {
    private String data;
    public String excelSetup(int sheetNo, int row, int col) {
        File file=new File("data/GetData.xlsx");
        try {
            FileInputStream fis = new FileInputStream(file);
            XSSFWorkbook wb = new XSSFWorkbook(fis);
            XSSFSheet sh1 = wb.getSheetAt(sheetNo);
            data = sh1.getRow(row).getCell(col).getStringCellValue();
        }catch (Exception e) {
            e.printStackTrace();
        }
        return data;

    }
}
