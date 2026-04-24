CREATE TABLE areas
(
    id   INT          NOT NULL AUTO_INCREMENT,
    name VARCHAR(100) NOT NULL,

    CONSTRAINT pk_action_category PRIMARY KEY (id)
);

INSERT INTO areas(name)
VALUES ('players castle'),
       ('enemy castle'),
       ('wealth wheel'),
       ('chapel'),
       ('training ground'),
       ('warcraft'),
       ('worship'),
       ('governance'),
       ('entertainment'),
       ('St. Valentines festival'),
       ('farms'),
       ('Michaelmas area'),
       ('quarry & forest');
