SET FOREIGN_KEY_CHECKS = 0;

DROP TABLE IF EXISTS employee;

CREATE TABLE employee (
    id              INT(11) NOT NULL AUTO_INCREMENT,
    name            VARCHAR(50) NOT NULL,
    surname         VARCHAR(50) NOT NULL,
    salary          FLOAT NULL,
    PRIMARY KEY (id)
) ENGINE=InnoDB AUTO_INCREMENT=1 DEFAULT CHARSET=utf8;

SET FOREIGN_KEY_CHECKS = 1;

INSERT INTO employee (name,surname,salary)
VALUES
('Sergei','Sudorov',42000.0),
('Ivan','Ivanov',40000.0),
('Pert','Petrov',36000.0);