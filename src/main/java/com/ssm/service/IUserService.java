package com.ssm.service;
import com.ssm.model.User;

import java.util.List;

public interface  IUserService {

    List<User> selectUser();

    int insert(User user);
}
