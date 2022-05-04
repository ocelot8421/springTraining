USE mysql;

CREATE SCHEMA
	if NOT EXISTS employees
	DEFAULT CHARACTER SET UTF8 COLLATE utf8_hungarian_ci;

CREATE USER 'employees'@'localhost' IDENTIFIED BY 'employees';

GRANT ALL ON employees.* TO 'employees'@'localhost';

USE employees;

CREATE TABLE employees (
	id BIGINT AUTO_INCREMENT,
	emp_name VARCHAR(255),
	CONSTRAINT pk_employee PRIMARY KEY (id));