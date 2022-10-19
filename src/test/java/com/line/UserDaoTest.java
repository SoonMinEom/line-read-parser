package com.line;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.sql.SQLException;

import static org.junit.jupiter.api.Assertions.*;

class UserDaoTest {

    @Test
    void addAndSelect() throws SQLException, ClassNotFoundException {

        UserDao userDao = new UserDaoFactory().AwsUserDao();
        String id = "19";
        User user = new User(id,"testclass","1111");
        userDao.add(user);

        User selectedUser = userDao.select("19");
        Assertions.assertEquals("testclass",selectedUser.getName());
    }
}