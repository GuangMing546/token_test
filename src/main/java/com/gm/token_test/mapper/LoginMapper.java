package com.gm.token_test.mapper;

import com.gm.token_test.entity.LoginEntity;

public interface LoginMapper {
    public String getPasswordByUserName(LoginEntity loginEntity);
}
