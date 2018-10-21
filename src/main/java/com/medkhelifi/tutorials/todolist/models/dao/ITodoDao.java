package com.medkhelifi.tutorials.todolist.models.dao;

import com.medkhelifi.tutorials.todolist.models.entities.Todo;
import com.medkhelifi.tutorials.todolist.models.entities.User;

import java.util.List;

public interface ITodoDao {
    List<Todo> getTodosByUserId (int userId);

    List<Todo> getCurrentUserTodos();

    void addTodo(Todo todo, User user);

    void addTodoForCurrentUser (Todo todo);

    void changeTodoStatus(Todo todo);
}
