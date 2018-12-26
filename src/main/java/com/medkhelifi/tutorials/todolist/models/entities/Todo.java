package com.medkhelifi.tutorials.todolist.models.entities;

import org.hibernate.annotations.Type;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table (name = "todo", schema = "TODOLIST")
public class Todo {

    private int id;
    private String title;
    private String description;
    private LocalDateTime dueDate;
    private boolean done;
    private int userId;
    private User userByUserId;

    @Id
    @Column (name = "id", nullable = false, insertable = false, updatable = false)
    public int getId() {   return id;  }
    public void setId(int id) { this.id = id; }

    @Basic
    @Column (name = "title", nullable = false, length = 100)
    public String getTitle() { return title; }
    public void setTitle(String title) {  this.title = title;  }

    @Basic
    @Column (name = "description", length = 512)
    public String getDescription() { return description;  }
    public void setDescription(String description) { this.description = description; }

    @Type(type = "com.medkhelifi.tutorials.todolist.util.LocalDateTimeUserType")
    @Column (name = "due_date")
    public LocalDateTime getDueDate() { return dueDate;}
    public void setDueDate(LocalDateTime dueDate) { this.dueDate = dueDate; }

    @Basic
    @Column (name = "done")
    public boolean isDone() { return done; }
    public void setDone(boolean done) { this.done = done;}

    @Basic
    @Column(name = "user_id", nullable = true, insertable = false, updatable = false)
    public int getUserId() {return userId; }
    public void setUserId(int userId) { this.userId = userId; }

    @ManyToOne
    @JoinColumn(name = "user_id", referencedColumnName = "id")
    public User getUserByUserId() {return userByUserId; }
    public void setUserByUserId(User userByUserId) {this.userByUserId = userByUserId; }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Todo todo = (Todo) o;

        if (id != todo.id) return false;
        if (title != null ? !title.equals(todo.title) : todo.title != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = id;
        result = 31 * result + (title != null ? title.hashCode() : 0);
        return result;
    }

}
