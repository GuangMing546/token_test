package com.gm.token_test.controller;


import com.gm.token_test.entity.LoginEntity;
import com.gm.token_test.service.impl.LoginServiceImpl;
import com.gm.token_test.util.JwtUtil;
import com.gm.token_test.util.ResultCode;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;


@CrossOrigin //解决跨域问题
@RestController //@Controller @ResponseBody
@RequestMapping("/v1")
public class LoginController {
    @Autowired
    LoginServiceImpl loginService;

    @PostMapping("/login")
    public ResultCode checkLogin(@RequestBody LoginEntity loginEntity){
        System.out.println(loginEntity);
        return loginService.checkLogin(loginEntity);
    }

    @PostMapping("/test")
    public String test(HttpServletRequest request){
        String token=request.getHeader("token");
        boolean verity= JwtUtil.verity(token);
        if(verity) {
            return "token验证成功";
        }
        return "token验证失败";
    }
}
