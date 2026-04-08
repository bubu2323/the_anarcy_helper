CREATE TABLE reward_action_results
(
    id               INT NOT NULL AUTO_INCREMENT,
    reward_action_id INT NOT NULL,
    resource_id      INT NOT NULL,

    CONSTRAINT pk_reward_action_results PRIMARY KEY (id),
    CONSTRAINT fk_rares_reward_action
        FOREIGN KEY (reward_action_id) REFERENCES reward_actions (id),
    CONSTRAINT fk_rares_resource
        FOREIGN KEY (resource_id) REFERENCES resources (id)
);