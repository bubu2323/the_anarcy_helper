CREATE TABLE reward_actions
(
    id          INT          NOT NULL AUTO_INCREMENT,
    action_name VARCHAR(255) NOT NULL,
    immediate   BOOLEAN      NOT NULL DEFAULT FALSE,

    CONSTRAINT pk_reward_actions PRIMARY KEY (id)
);