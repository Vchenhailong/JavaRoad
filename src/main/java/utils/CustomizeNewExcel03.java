package utils;

import org.apache.commons.io.FileUtils;
import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;

/**
 * Created with IntelliJ IDEA.
 * Description: 通过POI创建Excel（97-2003版本）文件，并通过commons-io包的API对Excel进行操作
 *
 * @author hailongchen
 * Date: 2017-12-07
 * Time: 11:51
 */
public class CustomizeNewExcel03 {

    /**
     * 表头
     */
    private String[] sHeader;

    public CustomizeNewExcel03(String[] sHeader) {
        this.sHeader = sHeader;
    }

    public void newExcel() throws IOException {

        //创建excel工作簿
        HSSFWorkbook workbook = new HSSFWorkbook();
        //创建工作表sheet
        HSSFSheet sheet = workbook.createSheet("java-auto");
        //创建sheet表头
        HSSFRow tRow = sheet.createRow(0);
        //声明表头的单元格变量
        HSSFCell tCell;
        for (int i = 0; i < sHeader.length; i++) {
            //创建表头单元格并为其赋值
            tCell = tRow.createCell(i);
            tCell.setCellValue(sHeader[i]);
        }
        File file = new File(System.getProperty("user.dir")+"/src/model.xls");
        file.createNewFile();
        System.out.println("生成的Excel文件简易模板见:" + file.toString());
        FileOutputStream fos = FileUtils.openOutputStream(file);
        //将定义的表头信息写入文件
        workbook.write(fos);
        fos.close();
    }
}
