-- 1. Bảng role: 3 hàng
INSERT INTO role (name)
VALUES ('ROLE_ADMIN');
INSERT INTO role (name)
VALUES ('ROLE_COACH');
INSERT INTO role (name)
VALUES ('ROLE_PLAYER');

-- 2. Bảng team: 2 hàng
INSERT INTO team (id, description, name)
VALUES (1, 'First team description', 'Team A');
INSERT INTO team (id, description, name)
VALUES (2, 'Second team description', 'Team B');

-- 3. Bảng member: 18 hàng
-- Lưu ý: Chúng ta ép giá trị cho cột id (auto_increment) để đảm bảo các ID dùng cho các bảng khác.
INSERT INTO member (id, date_of_birth, full_name, hometown, member_type, nationality)
VALUES (1, '1980-01-01', 'Admin User', 'Hanoi', NULL, 'Vietnamese'),
       (2, '1975-05-10', 'Coach One', 'Hanoi', 'COACH', 'Vietnamese'),
       (3, '1980-07-20', 'Coach Two', 'Hanoi', 'COACH', 'Vietnamese'),
       (4, '1995-02-15', 'Player 1', 'HCMC', 'PLAYER', 'Vietnamese'),
       (5, '1996-03-16', 'Player 2', 'HCMC', 'PLAYER', 'Vietnamese'),
       (6, '1997-04-17', 'Player 3', 'HCMC', 'PLAYER', 'Vietnamese'),
       (7, '1998-05-18', 'Player 4', 'HCMC', 'PLAYER', 'Vietnamese'),
       (8, '1999-06-19', 'Player 5', 'HCMC', 'PLAYER', 'Vietnamese'),
       (9, '1995-07-20', 'Player 6', 'HCMC', 'PLAYER', 'Vietnamese'),
       (10, '1996-08-21', 'Player 7', 'HCMC', 'PLAYER', 'Vietnamese'),
       (11, '1997-09-22', 'Player 8', 'HCMC', 'PLAYER', 'Vietnamese'),
       (12, '1998-10-23', 'Player 9', 'HCMC', 'PLAYER', 'Vietnamese'),
       (13, '1999-11-24', 'Player 10', 'HCMC', 'PLAYER', 'Vietnamese'),
       (14, '2000-12-25', 'Player 11', 'HCMC', 'PLAYER', 'Vietnamese'),
       (15, '2001-01-26', 'Player 12', 'HCMC', 'PLAYER', 'Vietnamese'),
       (16, '2002-02-27', 'Player 13', 'HCMC', 'PLAYER', 'Vietnamese'),
       (17, '2003-03-28', 'Player 14', 'HCMC', 'PLAYER', 'Vietnamese'),
       (18, '2004-04-29', 'Player 15', 'HCMC', 'PLAYER', 'Vietnamese');

-- 4. Bảng user: 18 hàng (mỗi user có cùng ID với member)
-- Gán role_id: ID=1 (Admin) → ROLE_ADMIN, ID=2,3 (Coach) → ROLE_COACH, ID 4-18 (Player) → ROLE_PLAYER.
INSERT INTO user (id, disabled, password, username, role_id)
VALUES (1, b'0', 'adminpass', 'admin', 1),
       (2, b'0', 'coachpass1', 'coach1', 2),
       (3, b'0', 'coachpass2', 'coach2', 2),
       (4, b'0', 'playerpass1', 'player1', 3),
       (5, b'0', 'playerpass2', 'player2', 3),
       (6, b'0', 'playerpass3', 'player3', 3),
       (7, b'0', 'playerpass4', 'player4', 3),
       (8, b'0', 'playerpass5', 'player5', 3),
       (9, b'0', 'playerpass6', 'player6', 3),
       (10, b'0', 'playerpass7', 'player7', 3),
       (11, b'0', 'playerpass8', 'player8', 3),
       (12, b'0', 'playerpass9', 'player9', 3),
       (13, b'0', 'playerpass10', 'player10', 3),
       (14, b'0', 'playerpass11', 'player11', 3),
       (15, b'0', 'playerpass12', 'player12', 3),
       (16, b'0', 'playerpass13', 'player13', 3),
       (17, b'0', 'playerpass14', 'player14', 3),
       (18, b'0', 'playerpass15', 'player15', 3);

-- 5. Bảng salary: 36 hàng (mỗi member có 2 dòng, ví dụ tháng 1 và tháng 2 năm 2025)
INSERT INTO salary (id, month, year, incentive, salary)
VALUES (1, 1, 2025, 100.0, 1000.0),
       (1, 2, 2025, 150.0, 1100.0),
       (2, 1, 2025, 200.0, 1500.0),
       (2, 2, 2025, 250.0, 1600.0),
       (3, 1, 2025, 200.0, 1500.0),
       (3, 2, 2025, 250.0, 1600.0),
       (4, 1, 2025, 50.0, 900.0),
       (4, 2, 2025, 60.0, 950.0),
       (5, 1, 2025, 50.0, 900.0),
       (5, 2, 2025, 60.0, 950.0),
       (6, 1, 2025, 50.0, 900.0),
       (6, 2, 2025, 60.0, 950.0),
       (7, 1, 2025, 50.0, 900.0),
       (7, 2, 2025, 60.0, 950.0),
       (8, 1, 2025, 50.0, 900.0),
       (8, 2, 2025, 60.0, 950.0),
       (9, 1, 2025, 50.0, 900.0),
       (9, 2, 2025, 60.0, 950.0),
       (10, 1, 2025, 50.0, 900.0),
       (10, 2, 2025, 60.0, 950.0),
       (11, 1, 2025, 50.0, 900.0),
       (11, 2, 2025, 60.0, 950.0),
       (12, 1, 2025, 50.0, 900.0),
       (12, 2, 2025, 60.0, 950.0),
       (13, 1, 2025, 50.0, 900.0),
       (13, 2, 2025, 60.0, 950.0),
       (14, 1, 2025, 50.0, 900.0),
       (14, 2, 2025, 60.0, 950.0),
       (15, 1, 2025, 50.0, 900.0),
       (15, 2, 2025, 60.0, 950.0),
       (16, 1, 2025, 50.0, 900.0),
       (16, 2, 2025, 60.0, 950.0),
       (17, 1, 2025, 50.0, 900.0),
       (17, 2, 2025, 60.0, 950.0),
       (18, 1, 2025, 50.0, 900.0),
       (18, 2, 2025, 60.0, 950.0);

-- 6. Bảng coach: 2 hàng (chỉ dùng member ID 2 và 3)
INSERT INTO coach (id, team_id)
VALUES (2, 1);
INSERT INTO coach (id, team_id)
VALUES (3, 2);

-- 7. Bảng player: 15 hàng (chỉ dùng member ID từ 4 đến 18)
-- Phân bổ: ID 4-11 thuộc Team A, ID 12-18 thuộc Team B.
INSERT INTO player (id, bmi, height, ranking, team_id, weight)
VALUES (4, 22.5, 175.0, 1, 1, 70.0),
       (5, 22.5, 176.0, 2, 1, 71.0),
       (6, 22.5, 177.0, 3, 1, 72.0),
       (7, 22.5, 178.0, 4, 1, 73.0),
       (8, 22.5, 179.0, 5, 1, 74.0),
       (9, 22.5, 180.0, 6, 1, 75.0),
       (10, 22.5, 181.0, 7, 1, 76.0),
       (11, 22.5, 182.0, 8, 1, 77.0),
       (12, 23.5, 173.0, 9, 2, 68.0),
       (13, 23.5, 174.0, 10, 2, 69.0),
       (14, 23.5, 175.0, 11, 2, 70.0),
       (15, 23.5, 176.0, 12, 2, 71.0),
       (16, 23.5, 177.0, 13, 2, 72.0),
       (17, 23.5, 178.0, 14, 2, 73.0),
       (18, 23.5, 179.0, 15, 2, 74.0);

-- 8. Bảng matches: 5 hàng
-- Giả sử id của matches được auto_increment sẽ là 1,2,3,4,5 theo thứ tự chèn.
INSERT INTO matches (coach_id, date, location, name, team_id)
VALUES (2, '2025-03-01 15:00:00', 'Stadium A', 'Match 1', 1),
       (3, '2025-03-05 16:00:00', 'Stadium B', 'Match 2', 2),
       (2, '2025-03-10 17:00:00', 'Stadium A', 'Match 3', 1),
       (3, '2025-03-15 18:00:00', 'Stadium B', 'Match 4', 2),
       (2, '2025-03-20 19:00:00', 'Stadium A', 'Match 5', 1);

-- 9. Bảng match_player: 32 hàng
-- Phân bổ ví dụ:
-- Trận 1 (match_id=1, Team A): chọn 7 cầu thủ (ID 4,5,6,7,8,9,10)
INSERT INTO match_player (match_id, player_id, performance_rating, review)
VALUES (1, 4, 8, 'Good'),
       (1, 5, 7, 'Average'),
       (1, 6, 9, 'Excellent'),
       (1, 7, 6, 'Fair'),
       (1, 8, 8, 'Good'),
       (1, 9, 7, 'Average'),
       (1, 10, 8, 'Good');

-- Trận 2 (match_id=2, Team B): chọn 7 cầu thủ (ID 12,13,14,15,16,17,18)
INSERT INTO match_player (match_id, player_id, performance_rating, review)
VALUES (2, 12, 7, 'Good'),
       (2, 13, 8, 'Good'),
       (2, 14, 6, 'Fair'),
       (2, 15, 9, 'Excellent'),
       (2, 16, 7, 'Good'),
       (2, 17, 8, 'Good'),
       (2, 18, 7, 'Average');

-- Trận 3 (match_id=3, Team A): chọn 7 cầu thủ (ID 4,5,6,7,8,9,10)
INSERT INTO match_player (match_id, player_id, performance_rating, review)
VALUES (3, 4, 9, 'Excellent'),
       (3, 5, 8, 'Good'),
       (3, 6, 7, 'Average'),
       (3, 7, 8, 'Good'),
       (3, 8, 9, 'Excellent'),
       (3, 9, 7, 'Average'),
       (3, 10, 8, 'Good');

-- Trận 4 (match_id=4, Team B): chọn 6 cầu thủ (ID 12,13,14,15,16,17)
INSERT INTO match_player (match_id, player_id, performance_rating, review)
VALUES (4, 12, 8, 'Good'),
       (4, 13, 7, 'Average'),
       (4, 14, 9, 'Excellent'),
       (4, 15, 8, 'Good'),
       (4, 16, 7, 'Average'),
       (4, 17, 8, 'Good');

-- Trận 5 (match_id=5, Team A): chọn 5 cầu thủ (ID 4,6,8,10,11)
INSERT INTO match_player (match_id, player_id, performance_rating, review)
VALUES (5, 4, 7, 'Average'),
       (5, 6, 8, 'Good'),
       (5, 8, 9, 'Excellent'),
       (5, 10, 7, 'Average'),
       (5, 11, 8, 'Good');