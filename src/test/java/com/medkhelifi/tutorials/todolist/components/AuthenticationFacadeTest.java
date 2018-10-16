package com.medkhelifi.tutorials.todolist.components;

import com.medkhelifi.tutorials.todolist.models.dao.UserDao;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import static org.junit.Assert.*;

@RunWith( SpringJUnit4ClassRunner.class )
@ContextConfiguration(locations = "classpath*:conf/applicationContext.xml")
public class AuthenticationFacadeTest {

    @Autowired
    private UserDao userDao;

    @Test
    public void testUserDao(){
        assertNotNull(userDao);
    }

    @Test
    public void getAuthentication() {
    }

    @Test
    public void getAuthenticatedFacade() {
    }
}