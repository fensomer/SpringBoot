DROP TABLE IF EXISTS USERS;

CREATE TABLE USERS (
  id INT(11) NOT NULL AUTO_INCREMENT,
  name VARCHAR(100) NOT NULL,
  email VARCHAR(100) DEFAULT NULL,
  PRIMARY KEY (id)
);