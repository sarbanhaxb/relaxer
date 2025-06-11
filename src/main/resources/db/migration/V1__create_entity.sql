CREATE SCHEMA IF NOT EXISTS users_schema;

CREATE TABLE IF NOT EXISTS t_passports(
    id INTEGER PRIMARY KEY NOT NULL,
    c_number VARCHAR(12) NOT NULL UNIQUE
);

CREATE TABLE IF NOT EXISTS t_users(
    id INTEGER PRIMARY KEY NOT NULL,
    c_name VARCHAR(50) NOT NULL,
    c_age INTEGER  NOT NULL CHECK(c_age > 15 AND c_age < 86),
    c_passport_id INTEGER UNIQUE,
    FOREIGN KEY (c_passport_id) REFERENCES t_passports(id)
);

CREATE TABLE IF NOT EXISTS t_accounts(
    id INTEGER PRIMARY KEY NOT NULL,
    title VARCHAR(50) NOT NULL,
    c_user_id INTEGER,
    FOREIGN KEY (c_user_id) REFERENCES t_users(id)
);

CREATE TABLE IF NOT EXISTS t_hobbies(
    id INTEGER PRIMARY KEY NOT NULL,
    c_type VARCHAR(50) NOT NULL
);

CREATE TABLE IF NOT EXISTS t_users_hobbies(
    c_user_id INTEGER,
    c_hobby_id INTEGER,
    PRIMARY KEY(c_user_id, c_hobby_id),
    FOREIGN KEY(c_user_id) REFERENCES t_users(id),
    FOREIGN KEY(c_hobby_id) REFERENCES t_hobbies(id)
);