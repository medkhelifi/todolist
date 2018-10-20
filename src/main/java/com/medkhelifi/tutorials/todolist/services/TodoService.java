package com.medkhelifi.tutorials.todolist.services;

import com.medkhelifi.tutorials.todolist.models.dao.ITodoDao;
import com.medkhelifi.tutorials.todolist.models.entities.Todo;
import com.medkhelifi.tutorials.todolist.models.entities.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import java.util.List;

@ManagedBean
@Service
@RequestScoped
public class TodoService implements ITodoService {

    @Autowired
    private ITodoDao iTodoDao;

    private Todo todo = new Todo();


    @Override
    public void addTodo( User user) {
        iTodoDao.addTodo(this.todo, user);
    }

    @Override
    public void addTodoForCurrentUser() {
        iTodoDao.addTodoForCurrentUser(this.todo);
        this.todo = new Todo();
    }

    @Override
    public List<Todo> getCurrentUserTodos() {
        return iTodoDao.getCurrentUserTodos();
    }

    public void setITodoDao(ITodoDao ITodoDao) {  this.iTodoDao = ITodoDao; }

    public Todo getTodo() { return todo;  }

    public void setTodo(Todo todo) { this.todo = todo; }
}
