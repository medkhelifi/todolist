package com.medkhelifi.tutorials.todolist.models.dao;

import com.medkhelifi.tutorials.todolist.components.AuthenticationFacade;
import com.medkhelifi.tutorials.todolist.models.entities.Todo;
import com.medkhelifi.tutorials.todolist.models.entities.User;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PostFilter;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.access.prepost.PreFilter;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Component
@Transactional
public class TodoDao implements ITodoDao {

    @Autowired
    private SessionFactory sessionFactory;

    @Autowired
    private AuthenticationFacade authenticationFacade;

    @Override
    //@PostFilter("filterObject.userId == @authenticationFacade.getAuthenticatedFacade().id")
    @PostFilter("false")
    public List<Todo> getTodosByUserId(int userId) {
        return sessionFactory.getCurrentSession().createQuery("from Todo where userId = ?").setParameter(0, userId).list();
    }

    @Override
    //@PostFilter("filterObject.userByUserId == @authenticationFacade.getAuthenticatedFacade()")
    public List<Todo> getCurrentUserTodos() {
        User user = authenticationFacade.getAuthenticatedFacade();
        return getTodosByUserId(user.getId());

    }

    @Override
    @PreAuthorize("#todo.userByUserId == @authenticationFacade.getAuthenticatedFacade()")
    public Todo addTodo(Todo todo, User user) {
        todo.setUserByUserId(user);
        return (Todo) sessionFactory.getCurrentSession().save(todo);
    }

    @Override
    public Todo addTodoForCurrentUser(Todo todo) {
        return addTodo(todo, authenticationFacade.getAuthenticatedFacade());
    }

    @Override
    @PreAuthorize("#todo.userByUserId == @authenticationFacade.getAuthenticatedFacade()")
    public void changeTodoStatus(Todo todo) {
        todo.setDone(!todo.isDone());
        sessionFactory.getCurrentSession().update(todo);
    }

    public void setSessionFactory(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }
}
