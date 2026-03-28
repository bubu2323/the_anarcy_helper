CREATE TABLE reward_actions_requirements
(
    id               INT NOT NULL AUTO_INCREMENT,
    reward_action_id INT NOT NULL,
    requirement_id   INT NOT NULL,

    CONSTRAINT pk_reward_actions_requirements PRIMARY KEY (id),
    CONSTRAINT fk_rar_reward_action
        FOREIGN KEY (reward_action_id) REFERENCES reward_actions (id),
    CONSTRAINT fk_rar_requirement
        FOREIGN KEY (requirement_id) REFERENCES requirements (id)
);