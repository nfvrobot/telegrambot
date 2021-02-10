CREATE SCHEMA city_helper_storage;

SET SEARCH_PATH = public;

CREATE TABLE city_helper (
    id BIGSERIAL PRIMARY KEY,
    name CHARACTER VARYING (64) NOT NULL UNIQUE,
    info CHARACTER VARYING (128) NOT NULL
);

INSERT INTO city (name, info) VALUES
    ('Москва', 'Не забудьте посетить Красную Площадь'),
    ('Санкт-Петербург', 'Посещать нужно всё, особенно там где разливают алкоголь'),
    ('Пермь', 'Оно тебе не надо, ехай домой'),
    ('Минск', 'Ну такое...');