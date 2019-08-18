package com.ssm.service.imp;

import com.ssm.dao.IUserDao;
import com.ssm.model.User;
import com.ssm.service.IUserService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service("userService")
public class UserServiceImpl implements IUserService {

    @Resource
    private IUserDao userDao;

    public List<User> selectUser() {
        return this.userDao.selectUser();
    }

    @Override
    public int insert(User user) {
        return 0;
    }

}