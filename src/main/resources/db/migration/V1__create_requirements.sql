CREATE TABLE requirements
(
    id                    INT     NOT NULL AUTO_INCREMENT,
    isAction              BOOLEAN NOT NULL DEFAULT FALSE,
    isResource            BOOLEAN NOT NULL DEFAULT FALSE,
    resource_id           INT     NULL,
    prerequisiteAction_id INT     NULL,

    CONSTRAINT pk_requirements PRIMARY KEY (id)
);