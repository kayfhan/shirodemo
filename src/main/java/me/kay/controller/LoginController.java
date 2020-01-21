package me.kay.controller;

import me.kay.entity.Login;
import me.kay.utils.ResponseHelper;
import me.kay.utils.ResponseModel;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.*;

/**
 * @Description
 * @Author sgl
 * @Date 2018-06-11 17:51
 */
@RestController
public class LoginController {

    private final static Logger logger = LoggerFactory.getLogger("login");

    @RequestMapping(value = "/login", method = RequestMethod.POST, produces = "application/json")
    public ResponseModel authenticate(@RequestBody Login login) {
        UsernamePasswordToken token = new UsernamePasswordToken(login.getUsername(), login.getPassword());
        try {
            SecurityUtils.getSubject().login(token);
            return ResponseHelper.buildResponseModel("login successful.");
        } catch (Exception e) {
            return ResponseHelper.unAuthorizedFailure("authorized error.");
        }
    }

    @RequestMapping("/logout")
    public ResponseModel logout() {
        SecurityUtils.getSubject().logout();
        return ResponseHelper.buildResponseModel("logout successful.");
    }
}
