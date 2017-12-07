package utils;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.regex.Pattern;

/**
 * Created with IntelliJ IDEA.
 * Description:
 *
 * @author hailongchen
 *         Date: 2017-11-30
 *         Time: 10:42
 */
@NoArgsConstructor
@AllArgsConstructor
@Data
@Builder
public class CalendarUtil {


    private String dateString;
    private static final int keyLength = 10;

    /**
     * 传入字符串类型的日期，校验字符串合法性，若合法则设置对应日期
     */
    public String checkDateFormat() throws Exception {

        String dateFormat = "^[1-9]\\d{3}-\\d{1,2}-\\d{1,2}";

        if (dateString.length() != keyLength || !Pattern.matches(dateFormat, dateString)) {

            throw new Exception("日期格式不正确");

        } else {
            //创建日历对象
            Calendar c = Calendar.getInstance();
            //设置日期时间格式
            SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
            //设定传入的日期时间
            Date d = sdf.parse(dateString);

            //这是方法1
//            c.setTime(d);

            // -- 这是方法2
            c.set(Calendar.YEAR, Integer.parseInt(dateString.substring(0, 4)));
            //月份有个偏移量，其初始为0，故在此需要减去1
            c.set(Calendar.MONTH, Integer.parseInt(dateString.substring(5, 7)) - 1);
            c.set(Calendar.DAY_OF_MONTH, Integer.parseInt(dateString.substring(8, 10)));
            // 方法2结束  --

            String result = sdf.format(c.getTime());

            System.out.println("当前传入时间是：" + result);
            return result;
        }

    }

}
