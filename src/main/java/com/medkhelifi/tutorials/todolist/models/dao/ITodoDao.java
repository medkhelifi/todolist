package com.medkhelifi.tutorials.todolist.models.dao;

import com.medkhelifi.tutorials.todolist.models.entities.Todo;
import com.medkhelifi.tutorials.todolist.models.entities.User;

import java.util.List;

public interface ITodoDao {
    List<Todo> getTodosByUserId (int userId);

    List<Todo> getCurrentUserTodos();

    Todo addTodo(Todo todo, User user);

    Todo addTodoForCurrentUser (Todo todo);

    void changeTodoStatus(Todo todo);
}
