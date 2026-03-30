CREATE TABLE requirements
(
    id                    INT     NOT NULL AUTO_INCREMENT,
    is_action              BOOLEAN NOT NULL DEFAULT FALSE,
    is_resource            BOOLEAN NOT NULL DEFAULT FALSE,
    resource_id           INT     NULL,
    prerequisite_action_id INT     NULL,

    CONSTRAINT pk_requirements PRIMARY KEY (id)
);