package com.gm.token_test.service.impl;


import com.gm.token_test.entity.LoginEntity;
import com.gm.token_test.mapper.LoginMapper;
import com.gm.token_test.service.LoginService;
import com.gm.token_test.util.JwtUtil;
import com.gm.token_test.util.ResultCode;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

@Service
public class LoginServiceImpl implements LoginService {
    @Resource
    LoginMapper loginMapper;

    @Override
    public ResultCode checkLogin(LoginEntity loginEntity) {

        String userName=loginMapper.getPasswordByUserName(loginEntity);
        ResultCode resultCode=new ResultCode();
        resultCode.setCode(400);
        resultCode.setMessage("登录失败");
        resultCode.setToken("没token信息生成");
        if (userName != null){
            resultCode.setCode(200);
            resultCode.setMessage("登陆成功");
            String token=JwtUtil.sign(loginEntity.getUserName());
            resultCode.setToken(token);
        }
        return resultCode;
    }
}
