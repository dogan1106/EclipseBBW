import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ExcelReader {

    public static void main(String[] args) throws IOException {
        String path = "C:\\Users\\D.Dogan\\eclipse-workspace\\Prorammieren1\\src\\Mappe1.xlsx";
        File file = new File(path);
        FileInputStream inputStream = new FileInputStream(file);
        Workbook workbook = new XSSFWorkbook(inputStream);
        Sheet sheet = workbook.getSheetAt(0);
        for (Row row : sheet) {
            String artikelnr = row.getCell(0).getStringCellValue();
            double price = 0.0;
            CellType priceCellType = row.getCell(1).getCellType();
            if (priceCellType == CellType.NUMERIC) {
                price = row.getCell(1).getNumericCellValue();
            }
            int stock = 0;
            CellType stockCellType = row.getCell(2).getCellType();
            if (stockCellType == CellType.NUMERIC) {
                stock = (int) row.getCell(2).getNumericCellValue();
            }
            String mengeneinheit = row.getCell(3).getStringCellValue();
            System.out.println("Material: " + artikelnr + ", Preis: " + price + ", Bestand: " + stock + ", Mengeneinheit: " + mengeneinheit);
        }
        workbook.close();
        inputStream.close();
    }
}

