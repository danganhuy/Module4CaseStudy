CREATE DATABASE soccer_club;
USE soccer_club;

CREATE TABLE role (
	id INT PRIMARY KEY AUTO_INCREMENT,
    name NVARCHAR(63) NOT NULL
);

CREATE TABLE member (
    id INT PRIMARY KEY AUTO_INCREMENT,
    fullName NVARCHAR(255) NOT NULL,
    dateOfBirth DATE,
    nationality NVARCHAR(100),
    hometown NVARCHAR(255),
    memberType ENUM('COACH', 'PLAYER')
);

CREATE TABLE salary (
	id INT NOT NULL,
    month INT NOT NULL,
    year INT NOT NULL,
    salary DOUBLE CHECK(salary > 0),
    incentive DOUBLE DEFAULT 0,
    PRIMARY KEY (id,month,year)
);

CREATE TABLE user (
	id INT PRIMARY KEY,
    username NVARCHAR(255) NOT NULL UNIQUE,
    password NVARCHAR(255) NOT NULL,
    role_id INT NOT NULL,
    FOREIGN KEY (role_id) REFERENCES role(id),
    FOREIGN KEY (id) REFERENCES member(id)
);

CREATE TABLE coaches (
    id INT PRIMARY KEY,
    FOREIGN KEY (id) REFERENCES member(id) ON DELETE CASCADE
);

CREATE TABLE player (
    id INT PRIMARY KEY,
    height DECIMAL(5,2),
    weight DECIMAL(5,2),
    bmi DECIMAL(5,2) GENERATED ALWAYS AS (weight / (height * height)) STORED,
    ranking INT,
    coachID INT,
    FOREIGN KEY (id) REFERENCES member(id) ON DELETE CASCADE,
    FOREIGN KEY (coachID) REFERENCES coaches(id) ON DELETE SET NULL
);