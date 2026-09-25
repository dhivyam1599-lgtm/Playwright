package utils;

import org.apache.poi.ss.usermodel.*;

import java.io.FileInputStream;
import java.io.IOException;

public class ExcelReader {

    private Workbook workbook;
    private Sheet sheet;

    public ExcelReader(String filePath, String sheetName) throws IOException {

        FileInputStream fis = new FileInputStream(filePath);

        workbook = WorkbookFactory.create(fis);

        sheet = workbook.getSheet(sheetName);
    }

    public String getCellData(int rowNumber, String columnName) {

        Row headerRow = sheet.getRow(0);
        Row dataRow = sheet.getRow(rowNumber);

        int columnNumber = -1;

        for (Cell cell : headerRow) {

            if (cell.getStringCellValue()
                    .equalsIgnoreCase(columnName)) {

                columnNumber = cell.getColumnIndex();
                break;
            }
        }

        if (columnNumber == -1) {
            throw new RuntimeException(
                    "Column not found: " + columnName
            );
        }

        Cell cell = dataRow.getCell(columnNumber);

        DataFormatter formatter = new DataFormatter();

        return formatter.formatCellValue(cell);
    }
    public PracticeFormData getPracticeFormData(int rowNumber) {

        String firstName = getCellData(rowNumber, "FirstName");
        String lastName = getCellData(rowNumber, "LastName");
        String email = getCellData(rowNumber, "Email");
        String mobile = getCellData(rowNumber, "Mobile");
        String state = getCellData(rowNumber, "State");
        String city = getCellData(rowNumber, "City");
        String address = getCellData(rowNumber, "Address");

        return new PracticeFormData(
                firstName,
                lastName,
                email,
                mobile,
                state,
                city,
                address
        );
    }

    public void close() throws IOException {
        workbook.close();
    }
}