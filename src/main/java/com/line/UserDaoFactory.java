package com.line;

public class UserDaoFactory {

    public UserDao AwsUserDao() {
        AwsConnectionMaker acm = new AwsConnectionMaker();
        UserDao userDao = new UserDao(acm);

        return userDao;
    }
}
