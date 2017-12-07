package service;

import api.UserFacade;
import dao.UserDao;
import dto.UserDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Created with IntelliJ IDEA.
 * Description:
 *
 * @author hailongchen
 *         Date: 2017-12-05
 *         Time: 16:37
 */
@Service
public class UserImpl implements UserFacade {

    @Autowired
    private UserDao userDao;

    @Override
    public void addUser(UserDto userDto) {

        userDao.addUser(userDto);
    }
}
