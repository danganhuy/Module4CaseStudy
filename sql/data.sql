USE soccer_club;

INSERT INTO role (name) VALUES 
('ADMIN'),
('COACH'),
('PLAYER');

INSERT INTO member (fullName, dateOfBirth, nationality, hometown, memberType) VALUES
('Admin User', '1990-01-01', 'Unknown', 'System', NULL), 
('Pep Guardiola', '1971-01-18', 'Spain', 'Santpedor', 'COACH'),
('Jurgen Klopp', '1967-06-16', 'Germany', 'Stuttgart', 'COACH'),
('Lionel Messi', '1987-06-24', 'Argentina', 'Rosario', 'PLAYER'),
('Cristiano Ronaldo', '1985-02-05', 'Portugal', 'Madeira', 'PLAYER'),
('Neymar Jr', '1992-02-05', 'Brazil', 'Mogi das Cruzes', 'PLAYER'),
('Kylian Mbappe', '1998-12-20', 'France', 'Paris', 'PLAYER'),
('Kevin De Bruyne', '1991-06-28', 'Belgium', 'Drongen', 'PLAYER'),
('Robert Lewandowski', '1988-08-21', 'Poland', 'Warsaw', 'PLAYER'),
('Virgil van Dijk', '1991-07-08', 'Netherlands', 'Breda', 'PLAYER'),
('Sergio Ramos', '1986-03-30', 'Spain', 'Seville', 'PLAYER'),
('Luka Modric', '1985-09-09', 'Croatia', 'Zadar', 'PLAYER'),
('Bruno Fernandes', '1994-09-08', 'Portugal', 'Maia', 'PLAYER'),
('Mohamed Salah', '1992-06-15', 'Egypt', 'Nagrig', 'PLAYER'),
('Erling Haaland', '2000-07-21', 'Norway', 'Leeds', 'PLAYER'),
('Harry Kane', '1993-07-28', 'England', 'London', 'PLAYER'),
('Eden Hazard', '1991-01-07', 'Belgium', 'La Louvière', 'PLAYER'),
('Paul Pogba', '1993-03-15', 'France', 'Lagny-sur-Marne', 'PLAYER');

INSERT INTO salary (id, month, year, salary, incentive) VALUES
-- Huấn luyện viên
(2, 1, 2024, 2000000, 500000),
(2, 2, 2024, 2000000, 450000),
(3, 1, 2024, 1800000, 400000),
(3, 2, 2024, 1800000, 350000),

-- Cầu thủ
(4, 1, 2024, 1500000, 200000),
(4, 2, 2024, 1500000, 180000),
(5, 1, 2024, 1600000, 250000),
(5, 2, 2024, 1600000, 230000),
(6, 1, 2024, 1400000, 180000),
(6, 2, 2024, 1400000, 160000),
(7, 1, 2024, 1550000, 210000),
(7, 2, 2024, 1550000, 200000),
(8, 1, 2024, 1450000, 190000),
(8, 2, 2024, 1450000, 180000),
(9, 1, 2024, 1520000, 220000),
(9, 2, 2024, 1520000, 200000),
(10, 1, 2024, 1580000, 240000),
(10, 2, 2024, 1580000, 230000),
(11, 1, 2024, 1480000, 200000),
(11, 2, 2024, 1480000, 180000),
(12, 1, 2024, 1430000, 170000),
(12, 2, 2024, 1430000, 160000),
(13, 1, 2024, 1470000, 180000),
(13, 2, 2024, 1470000, 170000),
(14, 1, 2024, 1420000, 160000),
(14, 2, 2024, 1420000, 150000),
(15, 1, 2024, 1590000, 250000),
(15, 2, 2024, 1590000, 240000),
(16, 1, 2024, 1480000, 190000),
(16, 2, 2024, 1480000, 180000),
(17, 1, 2024, 1440000, 175000),
(17, 2, 2024, 1440000, 165000),
(18, 1, 2024, 1500000, 210000),
(18, 2, 2024, 1500000, 200000);

INSERT INTO user (id, username, password, role_id) VALUES
(1, 'admin', 'adminpass', 1),
(2, 'coach_pep', 'pass123', 2),
(3, 'coach_klopp', 'pass123', 2),
(4, 'messi', 'messi10', 3),
(5, 'ronaldo', 'cr7', 3),
(6, 'neymar', 'neyjr', 3),
(7, 'mbappe', 'mbappe7', 3),
(8, 'debruyne', 'kdb17', 3),
(9, 'lewandowski', 'lewa9', 3),
(10, 'vandijk', 'vvd4', 3),
(11, 'ramos', 'sr4', 3),
(12, 'modric', 'modric10', 3),
(13, 'bruno', 'bf8', 3),
(14, 'salah', 'ms11', 3),
(15, 'haaland', 'haaland9', 3),
(16, 'kan', 'kan10', 3),
(17, 'hazard', 'hazard7', 3),
(18, 'pogba', 'pogba6', 3);

INSERT INTO coach (id) VALUES
(2), -- Pep Guardiola
(3); -- Jurgen Klopp

INSERT INTO player (id, height, weight, ranking, coachID) VALUES
(4, 1.70, 72, 1, 2),
(5, 1.87, 83, 2, 2),
(6, 1.75, 68, 3, 3),
(7, 1.78, 73, 2, 3),
(8, 1.81, 70, 3, 2),
(9, 1.85, 80, 4, 3),
(10, 1.93, 92, 5, 2),
(11, 1.84, 82, 2, 3),
(12, 1.72, 68, 4, 2),
(13, 1.79, 74, 3, 3),
(14, 1.75, 69, 5, 2),
(15, 1.94, 88, 1, 3),
(16, 1.82, 76, 2, 2),
(17, 1.77, 72, 3, 3),
(18, 1.91, 85, 4, 2);