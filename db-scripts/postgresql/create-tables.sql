CREATE TABLE task_definition
(
    id               BIGINT GENERATED BY DEFAULT AS IDENTITY NOT NULL,
    task_name        VARCHAR(255),
    task_description VARCHAR(255),
    CONSTRAINT pk_task_definition PRIMARY KEY (id)
);

CREATE TABLE task_step_definition
(
    id                 BIGINT GENERATED BY DEFAULT AS IDENTITY NOT NULL,
    step_name          VARCHAR(255),
    step_description   VARCHAR(255),
    step_number        INTEGER                                 NOT NULL,
    task_definition_id BIGINT,
    step_handler       VARCHAR(255),
    CONSTRAINT pk_task_step_definition PRIMARY KEY (id)
);

CREATE TABLE task_attribute_definition
(
    id                 BIGINT GENERATED BY DEFAULT AS IDENTITY NOT NULL,
    attribute_name     VARCHAR(255),
    task_definition_id BIGINT,
    CONSTRAINT pk_task_attribute_definition PRIMARY KEY (id)
);

CREATE TABLE task_instance
(
    id                 BIGINT GENERATED BY DEFAULT AS IDENTITY NOT NULL,
    task_definition_id BIGINT,
    created_at         TIMESTAMP WITHOUT TIME ZONE,
    updated_at         TIMESTAMP WITHOUT TIME ZONE,
    CONSTRAINT pk_task_instance PRIMARY KEY (id)
);

CREATE TABLE task_step_instance
(
    id                      BIGINT GENERATED BY DEFAULT AS IDENTITY NOT NULL,
    task_instance_id        BIGINT                                  NOT NULL,
    task_step_definition_id BIGINT                                  NOT NULL,
    status                  VARCHAR(255),
    started_at              TIMESTAMP WITHOUT TIME ZONE,
    ended_at                TIMESTAMP WITHOUT TIME ZONE,
    CONSTRAINT pk_task_step_instance PRIMARY KEY (id)
);

CREATE TABLE task_attribute_instance
(
    id               BIGINT GENERATED BY DEFAULT AS IDENTITY NOT NULL,
    attribute_name   VARCHAR(255),
    attribute_value  VARCHAR(255),
    task_instance_id BIGINT                                  NOT NULL,
    CONSTRAINT pk_task_attribute_instance PRIMARY KEY (id)
);

ALTER TABLE task_attribute_definition
    ADD CONSTRAINT FK_TASK_ATTRIBUTE_DEFINITION_ON_TASK_DEFINITION FOREIGN KEY (task_definition_id) REFERENCES task_definition (id);

ALTER TABLE task_instance
    ADD CONSTRAINT FK_TASK_INSTANCE_ON_TASK_DEFINITION FOREIGN KEY (task_definition_id) REFERENCES task_definition (id);

ALTER TABLE task_step_definition
    ADD CONSTRAINT FK_TASK_STEP_DEFINITION_ON_TASK_DEFINITION FOREIGN KEY (task_definition_id) REFERENCES task_definition (id);