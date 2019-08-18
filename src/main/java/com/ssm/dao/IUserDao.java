package com.ssm.dao;

import com.ssm.model.User;

import java.util.List;

public interface IUserDao {
    List<User> selectUser();
}