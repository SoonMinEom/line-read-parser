package com.line;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.sql.SQLException;

import static org.junit.jupiter.api.Assertions.*;

class UserDaoTest {

    @Test
    void addAndSelect() throws SQLException, ClassNotFoundException {
        AWSUserDaoImpl userDao = new AWSUserDaoImpl();
        String id = "15";
        User user = new User(id,"testclass","1111");
        userDao.add(user);

        User selectedUser = userDao.select("10");
        Assertions.assertEquals("testclass",selectedUser.getName());
    }
}