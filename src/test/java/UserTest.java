import bo.SEX;
import dto.UserDto;
import org.junit.Test;
import utils.CustomizeHttpClientUtil;

import java.io.IOException;

/**
 * Created with IntelliJ IDEA.
 * Description:
 *
 * @author hailongchen
 *         Date: 2017-12-05
 *         Time: 17:42
 */
public class UserTest {


    @Test
    public void setUserDto() throws IOException {

        UserDto userDto = new UserDto();
        userDto.setAge(22);
        userDto.setName("Lily");
        userDto.setSex(SEX.FEMALE);

        CustomizeHttpClientUtil customizeHttpClientUtil = new CustomizeHttpClientUtil();
        customizeHttpClientUtil.jsonPostHttp("http://localhost:8080/addUser.do",userDto);


    }
}
