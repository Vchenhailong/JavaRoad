package utilsTest;

import com.alibaba.fastjson.JSONObject;
import org.junit.Test;
import utils.CalendarUtil;
import utils.CustomizeFileUtil;
import utils.CustomizeHttpClientUtil;

import java.io.IOException;

/**
 * Created by hailongchen on 2017/11/8.
 * 注意：理应一个src.main.java.class就对应有一个测试类文件，而不是放一起
 * 此处仅仅是偷懒，临时测试用
 *
 */

public class UtilsTest {

    @Test
    public void httpClientUtilTest(){

        JSONObject jsonObject = new JSONObject();
        jsonObject.put("appId", "1");
        jsonObject.put("userName", "13975161675");
        jsonObject.put("password", "111111");
        CustomizeHttpClientUtil customizeHttpClientUtil = new CustomizeHttpClientUtil();

        try {
            customizeHttpClientUtil.jsonPostHttp(jsonObject,"http://manage-uat.yun-chang.cn/manage/auth/login.do");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void FileUtilTextIOTest() throws IOException {


        CustomizeFileUtil customizeFileUtil = new CustomizeFileUtil();
        customizeFileUtil.setSrcFileName("/Users/hailongchen/Desktop/json.txt");

        customizeFileUtil.setDstFileName("/Users/hailongchen/Desktop/writer.txt");
        customizeFileUtil.textIO();


    }

    @Test
    public void FileUtilSteamIOTest() throws IOException {
        CustomizeFileUtil customizeFileUtil = new CustomizeFileUtil();
        customizeFileUtil.setSrcFileName("/Users/hailongchen/Desktop/yinzhang.png");


        customizeFileUtil.setDstFileName("/Users/hailongchen/Desktop/yin.png");
        customizeFileUtil.streamIO();
        customizeFileUtil.bufferedIO();
    }

    @Test
    public void CalendarUtilTest() throws Exception {
        CalendarUtil calendarUtil = new CalendarUtil();
        calendarUtil.setDateString("2012-05-01");
        calendarUtil.checkDateFormat();
    }

}
