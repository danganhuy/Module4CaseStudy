CREATE DATABASE soccer_club;
USE soccer_club;

CREATE TABLE role (
	id INT PRIMARY KEY AUTO_INCREMENT,
    name NVARCHAR(50) NOT NULL
);

CREATE TABLE member (
    id INT PRIMARY KEY AUTO_INCREMENT,
    fullName NVARCHAR(255) NOT NULL,
    dateOfBirth DATE,
    nationality NVARCHAR(255),
    hometown NVARCHAR(255),
    memberType ENUM('COACH', 'PLAYER')
);

CREATE TABLE salary (
	id INT NOT NULL,
    month INT NOT NULL CHECK(month > 0 && month <= 12),
    year INT NOT NULL CHECK(year > 0),
    salary DOUBLE CHECK(salary > 0),
    incentive DOUBLE DEFAULT 0,
    PRIMARY KEY (id,month,year)
);

CREATE TABLE user (
	id INT PRIMARY KEY,
    username NVARCHAR(255) NOT NULL UNIQUE,
    password NVARCHAR(255) NOT NULL,
    role_id INT NOT NULL,
    disabled BINARY DEFAULT 0,
    FOREIGN KEY (role_id) REFERENCES role(id),
    FOREIGN KEY (id) REFERENCES member(id)
);

CREATE TABLE coach (
    id INT PRIMARY KEY,
    FOREIGN KEY (id) REFERENCES member(id) ON DELETE CASCADE
);

CREATE TABLE player (
    id INT PRIMARY KEY,
    height DECIMAL(5,2),
    weight DECIMAL(5,2),
    bmi DECIMAL(5,2) GENERATED ALWAYS AS (weight / (height * height)) STORED,
    ranking INT,
    coach_id INT,
    FOREIGN KEY (id) REFERENCES member(id) ON DELETE CASCADE,
    FOREIGN KEY (coachID) REFERENCES coach(id) ON DELETE SET NULL
);