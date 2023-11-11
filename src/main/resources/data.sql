-- noinspection SqlNoDataSourceInspectionForFile

-- noinspection SqlDialectInspectionForFile

-- ID's are auto generated. No need to enter them here. If they are entered here then
-- the auto generation will not work and the ID's will be the ones entered here. Also,
-- PostMapping doesn't work if the IDs are entered here because the ID's are not auto.
INSERT INTO users (user_name, password, email, profile_is_private)
VALUES ('cptlazy', 'password', 'cpt@lazy.com', true);

INSERT INTO users (user_name, password, email, profile_is_private)
VALUES ('powerpuff', 'password', 'pp@lazy.com', true);

INSERT INTO users (user_name, password, email, profile_is_private)
VALUES ('haze', 'password', 'haze@lazy.com', true);
