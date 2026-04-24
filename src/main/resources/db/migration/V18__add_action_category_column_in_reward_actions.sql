ALTER TABLE reward_actions ADD area_id INT DEFAULT NULL;

ALTER TABLE reward_actions
    ADD CONSTRAINT fk_areas
        FOREIGN KEY (area_id) REFERENCES areas (id);

UPDATE reward_actions SET area_id = 1 WHERE reward_actions.id = 1;
UPDATE reward_actions SET area_id = 3 WHERE reward_actions.id = 2;
UPDATE reward_actions SET area_id = 4 WHERE reward_actions.id = 3;

UPDATE reward_actions SET area_id = 5 WHERE reward_actions.id = 5;
UPDATE reward_actions SET area_id = 6 WHERE reward_actions.id = 6;
UPDATE reward_actions SET area_id = 3 WHERE reward_actions.id = 7;
UPDATE reward_actions SET area_id = 7 WHERE reward_actions.id = 8;
UPDATE reward_actions SET area_id = 6 WHERE reward_actions.id = 9;
UPDATE reward_actions SET area_id = 3 WHERE reward_actions.id = 10;
UPDATE reward_actions SET area_id = 7 WHERE reward_actions.id = 11;

UPDATE reward_actions SET area_id = 7 WHERE reward_actions.id = 13;
UPDATE reward_actions SET area_id = 8 WHERE reward_actions.id = 14;
UPDATE reward_actions SET area_id = 6 WHERE reward_actions.id = 15;
UPDATE reward_actions SET area_id = 8 WHERE reward_actions.id = 16;
UPDATE reward_actions SET area_id = 3 WHERE reward_actions.id = 17;
UPDATE reward_actions SET area_id = 10 WHERE reward_actions.id = 18;
UPDATE reward_actions SET area_id = 1 WHERE reward_actions.id = 21;
UPDATE reward_actions SET area_id = 3 WHERE reward_actions.id = 22;

UPDATE reward_actions SET area_id = 2 WHERE reward_actions.id = 24;
UPDATE reward_actions SET area_id = 11 WHERE reward_actions.id = 25;

UPDATE reward_actions SET area_id = 8 WHERE reward_actions.id = 27;
UPDATE reward_actions SET area_id = 12 WHERE reward_actions.id = 28;
UPDATE reward_actions SET area_id = 2 WHERE reward_actions.id = 29;
UPDATE reward_actions SET area_id = 13 WHERE reward_actions.id = 30;
UPDATE reward_actions SET area_id = 1 WHERE reward_actions.id = 31;

UPDATE reward_actions SET area_id = 8 WHERE reward_actions.id = 33;
UPDATE reward_actions SET area_id = 12 WHERE reward_actions.id = 34;
UPDATE reward_actions SET area_id = 2 WHERE reward_actions.id = 35;

UPDATE reward_actions SET area_id = 8 WHERE reward_actions.id = 37;
UPDATE reward_actions SET area_id = 12 WHERE reward_actions.id = 38;
UPDATE reward_actions SET area_id = 2 WHERE reward_actions.id = 39;
UPDATE reward_actions SET area_id = 9 WHERE reward_actions.id = 40;

UPDATE reward_actions SET area_id = 3 WHERE reward_actions.id = 43;




