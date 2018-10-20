package com.medkhelifi.tutorials.todolist.services;

import com.medkhelifi.tutorials.todolist.models.entities.Todo;
import com.medkhelifi.tutorials.todolist.models.entities.User;

import java.util.List;

public interface ITodoService {
    void addTodo(User user);
    void addTodoForCurrentUser ();
    List<Todo> getCurrentUserTodos();
}
