DROP TABLE IF EXISTS USERS;

CREATE TABLE USERS (
  id INT(11) NOT NULL AUTO_INCREMENT,
  name VARCHAR(100) NOT NULL,
  email VARCHAR(100) DEFAULT NULL,
  PRIMARY KEY (id)
);

INSERT INTO USERS (id, name, email) VALUES (1, 'John', 'john@gmail.com');
INSERT INTO USERS (id, name, email) VALUES (2, 'Rod', 'rod@gmail.com');
INSERT INTO USERS (id, name, email) VALUES (3, 'Mike', 'mike@gmail.com');