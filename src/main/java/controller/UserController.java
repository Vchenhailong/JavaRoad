package controller;

import api.UserFacade;
import base.response.Response;
import dto.UserDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * Created with IntelliJ IDEA.
 * Description:
 *
 * @author hailongchen
 *         Date: 2017-12-05
 *         Time: 15:56
 */
@Controller
@RequestMapping("/")
public class UserController {

    @Autowired
    private UserFacade userFacade;

    @ResponseBody
    @RequestMapping("/addUser.do")
    public Response addUser(@RequestBody UserDto userDto){

        userFacade.addUser(userDto);

        return new Response(null);
    }


}
