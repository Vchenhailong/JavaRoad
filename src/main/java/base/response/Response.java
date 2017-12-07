package base.response;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * Created by hailongchen on 2017/11/3.
 * web接口响应类
 */

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Response {

    private String rspCode = "00000";

    private String rspInfo = "成功";

    private Object data = null;

    /**
     * 成功时，返回给controller
     */
    public Response(Object data) {

        this.rspCode = "00000";
        this.rspInfo = "成功";
        this.data = data;

    }

    /**
     * 异常时，返回给controller
     */
    public Response(String rspCode, String rspInfo) {

        this.rspCode = rspCode;
        this.rspInfo = rspInfo;

    }

}
