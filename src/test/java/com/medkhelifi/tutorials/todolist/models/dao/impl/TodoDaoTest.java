package com.medkhelifi.tutorials.todolist.models.dao.impl;

import org.hibernate.SessionFactory;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import static org.junit.Assert.*;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = "classpath*:conf/applicationContext.xml")
public class TodoDaoTest {

    @Autowired
    SessionFactory sessionFactory;

    @Test
    public void testSessionFactory () {
        assertNotNull("Session Factory must not be null", sessionFactory);
    }

}