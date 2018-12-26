package com.medkhelifi.tutorials.todolist.services;

import com.medkhelifi.tutorials.todolist.models.dao.TodoDao;
import com.medkhelifi.tutorials.todolist.models.entities.Todo;
import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.core.IsNull.notNullValue;
import static org.junit.Assert.assertThat;
import static org.mockito.Mockito.*;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.mockito.invocation.InvocationOnMock;
import org.mockito.runners.MockitoJUnitRunner;
import org.mockito.stubbing.Answer;

import static org.mockito.Matchers.any;

@RunWith(MockitoJUnitRunner.class)
public class TodoServiceTest {

    @Mock
    private TodoDao todoDao;

    @InjectMocks
    private TodoService todoService;

    @Before
    public void setUp(){
        MockitoAnnotations.initMocks(this);
    }

    //Using Answer to set an id to the customer which is passed in as a parameter to the mock method.
    @Test
    public void testAddTodo_returnNewTodo() {
        when(todoDao.addTodoForCurrentUser(any(Todo.class))).thenAnswer(new Answer<Todo>() {

            @Override
            public Todo answer(InvocationOnMock invocation) throws Throwable {

                Object[] arguments = invocation.getArguments();

                if (arguments != null && arguments.length > 0 && arguments[0] != null){

                    Todo todo = (Todo) arguments[0];
                    todo.setId(1);

                    return todo;
                }

                return null;
            }
        });

        Todo todo = new Todo();
        todoService.setTodo(todo);
        assertThat(todoService.addTodoForCurrentUser(), is(notNullValue()));
    }

    //Throwing an exception from the mocked method
    @Test(expected = RuntimeException.class)
    public void testAddCustomer_throwsException() {

        when(todoDao.addTodoForCurrentUser(any(Todo.class))).thenThrow(RuntimeException.class);

        Todo todo = new Todo();
        todoService.setTodo(todo);
        todoService.addTodoForCurrentUser();//

    }

}