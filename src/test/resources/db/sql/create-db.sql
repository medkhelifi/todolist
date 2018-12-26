create schema TODOLIST AUTHORIZATION SA;

CREATE TABLE TODOLIST.role (
  id int NOT NULL AUTO_INCREMENT,
  name varchar(20) NOT NULL,
  PRIMARY KEY (id),
  CONSTRAINT name UNIQUE  (name)
)   ;

CREATE TABLE TODOLIST.user (
  id int NOT NULL AUTO_INCREMENT,
  username varchar(50) NOT NULL,
  password varchar(250) NOT NULL,
  firstname varchar(150) NOT NULL,
  lastname varchar(150) NOT NULL,
  role_id int DEFAULT NULL,
  PRIMARY KEY (id),
  CONSTRAINT username UNIQUE  (username),
  CONSTRAINT fk_role_id FOREIGN KEY (role_id) REFERENCES TODOLIST.role (id) ON DELETE CASCADE ON UPDATE CASCADE
);
CREATE INDEX fk_role_id ON TODOLIST.user (role_id);

CREATE TABLE TODOLIST.todo (
  id int NOT NULL AUTO_INCREMENT,
  title varchar(150) NOT NULL,
  description clob,
  due_date datetime DEFAULT NULL,
  done bit(1) DEFAULT 0,
  user_id int NOT NULL,
  PRIMARY KEY (id),
  CONSTRAINT fk_user_id FOREIGN KEY (user_id) REFERENCES TODOLIST.user (id) ON DELETE CASCADE ON UPDATE CASCADE
);
CREATE INDEX fk_user_id ON TODOLIST.todo (user_id);


