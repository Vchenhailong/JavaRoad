package utils;

import lombok.Data;
import org.apache.commons.io.FileUtils;
import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;

import java.io.File;
import java.io.IOException;

/**
 * Created with IntelliJ IDEA.
 * Description: 解析Excel（97-2003版本）的内容
 *
 * @author hailongchen
 * Date: 2017-12-07
 * Time: 14:30
 */
@Data
public class CustomizeParseExcel03 {

    private String fileName;

    private int index;

    public void parseExcel() {
        try {
            HSSFWorkbook workbook =
                    new HSSFWorkbook(FileUtils.openInputStream(new File(fileName)));
            //选取工作簿sheet
//            HSSFSheet sheet = workbook.getSheet("java-auto");
            HSSFSheet sheet = workbook.getSheetAt(index);
            int sHeader = 0;
            //获取最后一行
            int rowNum = sheet.getLastRowNum();
            //根据行深，进行每行的列遍历
            for (int i = sHeader; i <= rowNum; i++) {
                HSSFRow row = sheet.getRow(i);
                //获取当前行最后单元格的列号
                int cellSize = row.getLastCellNum();
                //根据列深进行遍历，获取每行的单元格中的值
                for (int j = 0; j < cellSize; j++) {
                    HSSFCell cell = row.getCell(j);
                    String value = cell.getStringCellValue();
                    System.out.print(value + "  ");
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
