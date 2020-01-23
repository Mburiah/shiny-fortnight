SET MODE PostgreSQL;

--DATABASE organisation
CREATE TABLE IF NOT EXISTS departments(
id serial PRIMARY KEY,
name VARCHAR,
description VARCHAR,
employees INTEGER,
);

CREATE TABLE IF NOT EXISTS news(
id serial PRIMARY KEY,
title VARCHAR,
details VARCHAR
);

CREATE TABLE IF NOT EXISTS employees(
id serial PRIMARY KEY,
name VARCHAR,
title VARCHAR,
department_id INTEGER,
)