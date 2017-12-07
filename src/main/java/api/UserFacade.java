package api;

import dto.UserDto;

/**
 * Created with IntelliJ IDEA.
 * Description:
 *
 * @author hailongchen
 *         Date: 2017-12-05
 *         Time: 16:25
 */
public interface UserFacade {

    /**
     * 增加用户
     * @param userDto 用户信息
     *
     * */
    void addUser(UserDto userDto);
}
