CREATE TABLE requirements_resources
(
    id                             INT NOT NULL AUTO_INCREMENT,
    reward_actions_requirements_id INT NOT NULL,
    resource_id                    INT NOT NULL,

    CONSTRAINT pk_requirements_resources PRIMARY KEY (id),
    CONSTRAINT fk_rr_reward_actions_requirements
        FOREIGN KEY (reward_actions_requirements_id) REFERENCES reward_actions_requirements (id),
    CONSTRAINT fk_rr_resource
        FOREIGN KEY (resource_id) REFERENCES resources (id)
);