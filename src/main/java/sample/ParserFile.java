package sample;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class ParserFile {
    private String fileName = "/Users/ChesenFew/Documents/Тесты/testMail.xlsx";


    public List readFromExcel() {
        List<String> list = new ArrayList<>();

        //инициализируем потоки
        XSSFWorkbook workbook = null;
        try {
            workbook = new XSSFWorkbook(new FileInputStream(this.fileName));
        } catch (IOException e) {
            e.printStackTrace();
        }

        // разбитие листа
        XSSFSheet sheet = workbook.getSheetAt(0);

        //узнаем количество не пустых строк
        int rowCount = sheet.getPhysicalNumberOfRows();

        //проходимся по таблице итератором
        Iterator<Row> it = sheet.iterator();
        while (it.hasNext()) {
            Row row = it.next();
            Iterator<Cell> cells = row.iterator();
            while (cells.hasNext()) {
                Cell cell = cells.next();
                list.add(cell.getStringCellValue());
            }
        }
        return list;
    }

    public String getFileName() {
        return fileName;
    }

    public void setFileName( String fileName ) {
        this.fileName = fileName;
    }
}
