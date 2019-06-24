CREATE SCHEMA IF NOT EXISTS websocket;

CREATE TABLE IF NOT EXISTS websocket.messages
(
    id         serial not null,
    account_id int    not null,
    message    varchar(255)
);

COMMENT ON TABLE websocket.messages is 'Таблица сообщений';

CREATE unique index messages_id_uindex
    ON websocket.messages (id);

ALTER TABLE websocket.messages
    ADD CONSTRAINT messages_pk
        PRIMARY KEY (id);

INSERT INTO websocket.messages ("id", "account_id", "message")
VALUES (1, 1, 'Привет А!');
INSERT INTO websocket.messages ("id", "account_id", "message")
VALUES (2, 2, 'Привет Б!');
INSERT INTO websocket.messages ("id", "account_id", "message")
VALUES (3, 1, 'Как дела А?');
INSERT INTO websocket.messages ("id", "account_id", "message")
VALUES (4, 2, 'Отлично!');