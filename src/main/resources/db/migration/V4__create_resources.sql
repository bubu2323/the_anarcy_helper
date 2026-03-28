CREATE TABLE resources
(
    id          INT          NOT NULL AUTO_INCREMENT,
    name        VARCHAR(255) NOT NULL,
    category_id INT NULL,
    color       VARCHAR(50) NULL,

    CONSTRAINT pk_resources PRIMARY KEY (id),
    CONSTRAINT fk_resources_category
        FOREIGN KEY (category_id) REFERENCES category (id)
);