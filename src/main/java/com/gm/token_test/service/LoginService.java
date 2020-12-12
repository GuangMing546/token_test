package com.gm.token_test.service;


import com.gm.token_test.entity.LoginEntity;
import com.gm.token_test.util.ResultCode;

public interface LoginService {
    public ResultCode checkLogin(LoginEntity loginEntity);
}
