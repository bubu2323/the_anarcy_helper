ALTER TABLE requirements
    ADD CONSTRAINT fk_requirements_resource
        FOREIGN KEY (resource_id) REFERENCES resources (id),
    ADD CONSTRAINT fk_requirements_prerequisite_action
        FOREIGN KEY (prerequisiteAction_id) REFERENCES prerequisite_action (id);