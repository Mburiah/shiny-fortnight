SET MODE PostgreSQL;

--DATABASE organisation
CREATE TABLE IF NOT EXISTS departments(
id int PRIMARY KEY,
name VARCHAR,
description VARCHAR,
employees INTEGER,
);

CREATE TABLE IF NOT EXISTS news(
id int PRIMARY KEY,
title VARCHAR,
details VARCHAR
);

CREATE TABLE IF NOT EXISTS employees(
id int PRIMARY KEY,
name VARCHAR,
position VARCHAR,
department_id INTEGER,
)