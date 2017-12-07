package utilsTest;

import org.junit.Test;
import utils.CustomizeNewExcel03;

import java.io.IOException;

/**
 * Created with IntelliJ IDEA.
 * Description:
 *
 * @author hailongchen
 * Date: 2017-12-07
 * Time: 14:10
 */
public class NewExcelModelTest {

    @Test
    public void createExcel() throws IOException {
        String[] sHeader = {"id","name","sex"};
        CustomizeNewExcel03 excel = new CustomizeNewExcel03(sHeader);
        excel.newExcel();
    }
}
