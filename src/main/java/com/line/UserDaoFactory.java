package com.line;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class UserDaoFactory {

    @Bean
    public UserDao AwsUserDao() {
        AwsConnectionMaker acm = new AwsConnectionMaker();
        UserDao userDao = new UserDao(acm);

        return userDao;
    }


}
