package utilsTest;

import org.junit.Test;
import utils.CustomizeParseExcel03;

/**
 * Created with IntelliJ IDEA.
 * Description:
 *
 * @author hailongchen
 * Date: 2017-12-07
 * Time: 14:54
 */
public class ParseExcelTest {

    @Test
    public void parseExcel() {

        CustomizeParseExcel03 parseExcel = new CustomizeParseExcel03();
        parseExcel.setFileName("/Users/hailongchen/Documents/workspace/interfacePro/src/model.xls");
        parseExcel.setIndex(0);
        parseExcel.parseExcel();

    }
}
