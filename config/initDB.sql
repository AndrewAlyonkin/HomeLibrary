CREATE TABLE author
(
    id       BIGSERIAL PRIMARY KEY NOT NULL,
    fio      varchar(300)          NOT NULL,
    birthday date                  NOT NULL
);

CREATE TABLE genre
(
    id   SERIAL       NOT NULL PRIMARY KEY,
    name varchar(100) NOT NULL
);

CREATE TABLE publisher
(
    id   SERIAL       NOT NULL PRIMARY KEY,
    name varchar(100) NOT NULL
);

CREATE TABLE book
(
    id           BIGSERIAL PRIMARY KEY NOT NULL,
    name         varchar(45)           NOT NULL,
    content      BYTEA                 NOT NULL,
    page_count   SMALLINT              NOT NULL,
    isbn         varchar(100) UNIQUE   NOT NULL,
    genre_id     SMALLINT              NOT NULL REFERENCES genre (id) ON UPDATE CASCADE,
    author_id    INT                   NOT NULL REFERENCES author (id) ON UPDATE CASCADE,
    publish_year SMALLINT              NOT NULL,
    publisher_id INT                   NOT NULL REFERENCES publisher (id) ON DELETE NO ACTION ON UPDATE NO ACTION,
    image        BYTEA,
    descr        varchar(5000) DEFAULT NULL,
    rating       SMALLINT      DEFAULT 0,
    vote_count   INT           DEFAULT 0
);

