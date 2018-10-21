package com.medkhelifi.tutorials.todolist.models.dao;

import com.medkhelifi.tutorials.todolist.components.AuthenticationFacade;
import com.medkhelifi.tutorials.todolist.models.dao.ITodoDao;
import com.medkhelifi.tutorials.todolist.models.entities.Todo;
import com.medkhelifi.tutorials.todolist.models.entities.User;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
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
    public List<Todo> getTodosByUserId(int userId) {
        List todos= null;
        todos = sessionFactory.getCurrentSession().createQuery("from Todo where userId = ?").setParameter(0, userId).list();
        return todos;
    }

    @Override
    public List<Todo> getCurrentUserTodos() {
        User user = authenticationFacade.getAuthenticatedFacade();
        return getTodosByUserId(user.getId());

    }

    @Override
    public void addTodo(Todo todo, User user) {
        todo.setUserByUserId(user);
        sessionFactory.getCurrentSession().save(todo);
    }

    @Override
    public void addTodoForCurrentUser(Todo todo) {
        addTodo(todo, authenticationFacade.getAuthenticatedFacade());
    }

    @Override
    public void changeTodoStatus(Todo todo) {
        todo.setDone(!todo.isDone());
        sessionFactory.getCurrentSession().update(todo);
    }


}
