package utilities;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.FileInputStream;
import java.util.HashMap;
import java.util.List;

/**
 * The type Data helper.
 */
public class DataHelper {

    /**
     * Data list.
     *
     * @return the list
     */
    @SuppressWarnings("null")
    public static List<HashMap<String, String>> data() {

        List<HashMap<String, String>> mydata = null;
        try {

            FileInputStream fs = new FileInputStream("classpath:TestData-seleniumframework.xlsx");
            @SuppressWarnings("resource")
            XSSFWorkbook workbook = new XSSFWorkbook(fs);
            XSSFSheet sheet = workbook.getSheet("SignInSignOut");
            Row HeaderRow = sheet.getRow(0);

            for (int i = 1; i < sheet.getPhysicalNumberOfRows(); i++) {
                Row currentRow = sheet.getRow(i);
                HashMap<String, String> currentHash = new HashMap<String, String>();
                for (int j = 0; j < currentRow.getPhysicalNumberOfCells(); j++) {
                    Cell currentCell = currentRow.getCell(j);

                    switch (currentCell.getCellType()) {
                        case Cell.CELL_TYPE_STRING:
                            LogUtil.infoLog(DataHelper.class, currentCell.getStringCellValue() + "\t");
                            currentHash.put(HeaderRow.getCell(j).getStringCellValue(), currentCell.getStringCellValue());
                            break;
                    }
                }
                mydata.add(currentHash);
            }
            fs.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return mydata;
    }

    public static String maskingPhone(String phone) {
        if (phone.contains("+1")) {
            phone = phone.replace("+1", "");
        }
        return new StringBuilder("(").append(phone.substring(0, 3)).append(") ").
                append("***- ").append(phone.substring(6)).toString();
    }

}
