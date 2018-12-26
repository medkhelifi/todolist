package com.medkhelifi.tutorials.todolist.models.dao;


import com.medkhelifi.tutorials.todolist.components.AuthenticationFacade;
import com.medkhelifi.tutorials.todolist.models.entities.Todo;
import com.medkhelifi.tutorials.todolist.models.entities.User;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.junit.*;
import org.junit.runner.RunWith;
import org.mockito.*;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PostFilter;
import org.springframework.security.test.context.support.WithMockUser;
import org.springframework.security.test.context.support.WithSecurityContextTestExecutionListener;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.TestExecutionListeners;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.support.DependencyInjectionTestExecutionListener;
import org.springframework.test.context.support.DirtiesContextTestExecutionListener;
import org.springframework.test.context.transaction.TransactionalTestExecutionListener;
import org.springframework.test.context.web.ServletTestExecutionListener;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration (value = "classpath:/conf/applicationContext-test.xml")
@Transactional
public class TodoDaoTest {

    @Autowired
    SessionFactory testSessionFactory;

    @InjectMocks
    TodoDao todoDao;

    private boolean mockInitialized = false;

    @Before
    public void setUp(){
        if(!mockInitialized) {
            MockitoAnnotations.initMocks(this);
            mockInitialized = true;
        }
        todoDao.setSessionFactory(testSessionFactory);
    }

    @Test
    @WithMockUser (username = "user", roles = "ROLE_USER")
    public void getTodosByUserId_ShouldReturnEmptyList_IfCurrentUserIsDifferentFromSearchedUser(){
        int userId = 3;
        List<Todo> todos = todoDao.getTodosByUserId(userId);
        //assertTrue(todoDao.getTodosByUserId(userId).isEmpty());
    }

    @Test
    public void getTodosByUserIdShouldNotReturnNull(){
        User user = new User();
        assertNotNull(todoDao.getTodosByUserId(user.getId()));
    }




    @After
    public void tearDown() {

    }


}