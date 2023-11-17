-- noinspection SqlNoDataSourceInspectionForFile

-- noinspection SqlDialectInspectionForFile

-- ID's are auto generated. No need to enter them here. If they are entered here then
-- the auto generation will not work and the ID's will be the ones entered here. Also,
-- PostMapping doesn't work if the IDs are entered here because the ID's are not auto.

-- Users
INSERT INTO users (user_name, password, email, profile_private)
VALUES ('cptlazy', 'password', 'cpt@lazy.com', true);

INSERT INTO users (user_name, password, email, profile_private)
VALUES ('powerpuff', 'password', 'pp@lazy.com', true);

INSERT INTO users (user_name, password, email, profile_private)
VALUES ('haze', 'password', 'haze@lazy.com', true);

--  Game systems
INSERT INTO game_systems (game_system_name, game_system_review, game_system_rating)
VALUES ('Dreamcast', 'very good', 3);

INSERT INTO game_systems (game_system_name, game_system_review, game_system_rating)
VALUES ('Neo-Geo', 'the godfather', 3);

INSERT INTO game_systems (game_system_name, game_system_review, game_system_rating)
VALUES ('Playstation', 'top seller', 2);

-- Games
INSERT INTO games (game_name, game_review, game_rating)
VALUES ('Sonic', 'fast', '3');

INSERT INTO games (game_name, game_review, game_rating)
VALUES ('Super Mario', 'fun', '2');

INSERT INTO games (game_name, game_review, game_rating)
VALUES ('Soul Calibur', 'fun', '1');

-- Game conditions
INSERT INTO game_conditions (is_complete_in_box, has_manual, has_case)
VALUES (true, true, true);

INSERT INTO game_conditions (is_complete_in_box, has_manual, has_case)
VALUES (false, true, false);

INSERT INTO game_conditions (is_complete_in_box, has_manual, has_case)
VALUES (true, true, false);

-- Game system conditions
INSERT INTO game_system_conditions (has_box, has_cables, is_modified)
VALUES (true, true, true);

INSERT INTO game_system_conditions (has_box, has_cables, is_modified)
VALUES (true, false, true);

INSERT INTO game_system_conditions (has_box, has_cables, is_modified)
VALUES (true, true, false);