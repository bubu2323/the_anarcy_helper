ALTER TABLE requirements
    ADD CONSTRAINT fk_requirements_resource
        FOREIGN KEY (resource_id) REFERENCES resources (id),
    ADD CONSTRAINT fk_requirements_prerequisite_actions
        FOREIGN KEY (prerequisite_action_id) REFERENCES prerequisite_actions (id);