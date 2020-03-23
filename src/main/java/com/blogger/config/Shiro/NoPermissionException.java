package com.blogger.config.Shiro;

import com.blogger.util.CodeMsg;
import com.blogger.util.Result;
import org.apache.shiro.authz.AuthorizationException;
import org.apache.shiro.authz.UnauthorizedException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * 描述：
 *
 * @author caojing
 * @create 2019-01-27-17:12
 */
@ControllerAdvice
public class NoPermissionException {

    @ResponseBody
    @ExceptionHandler(UnauthorizedException.class)
    public Result handleShiroException(Exception ex) {
        return Result.error(CodeMsg.PERMISSION_CANNOTACCESS, "没有访问权限");
    }

    @ResponseBody
    @ExceptionHandler(AuthorizationException.class)
    public Result AuthorizationException(Exception ex) {
        return Result.error(CodeMsg.PERMISSION_ERROR, "权限认证失败");
    }
}
