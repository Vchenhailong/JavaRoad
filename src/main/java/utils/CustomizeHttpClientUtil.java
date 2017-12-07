package utils;

import com.alibaba.fastjson.JSON;
import org.apache.http.client.fluent.Request;
import org.apache.http.entity.ContentType;

import java.io.IOException;

/**
 * Created with IntelliJ IDEA.
 * Description:
 *         Http请求工具类
 *
 * @author hailongchen
 *         Date: 2017-11-09
 *         Time: 10:24
 */
public class CustomizeHttpClientUtil {

    /**
     * @return String
     * 响应体
     */
    public String jsonPostHttp(Object object, String url) throws IOException {

        String response = Request.Post(url).bodyString(JSON.toJSONString(object), ContentType.APPLICATION_JSON).execute().returnContent().asString();

        System.out.println(response);   // 将返回的内容打印出来便于调试
        return response;
    }

    /**
     *
     */
    public void jsonPostHttp(String url, Object object) throws IOException {

        Request.Post(url).bodyString(JSON.toJSONString(object), ContentType.APPLICATION_JSON).execute().returnContent().asString();

    }

}
