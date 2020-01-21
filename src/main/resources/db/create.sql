SET MODE PostgreSQL;

CREATE TABLE IF NOT EXISTS departments(
id int PRIMARY KEY auto_increment,
name VARCHAR,
description VARCHAR,
employees INTEGER,
);

CREATE TABLE IF NOT EXISTS news(
id int PRIMARY KEY auto_increment,
title VARCHAR,
details VARCHAR,
);

CREATE TABLE IF NOT EXISTS employees(
id int PRIMARY KEY auto_increment,
name VARCHAR,
position VARCHAR,
department_id INTEGER,
)