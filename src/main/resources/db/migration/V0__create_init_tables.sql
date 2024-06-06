CREATE SCHEMA IF NOT EXISTS bookstore;

-- Создание таблицы Books
CREATE TABLE IF NOT EXISTS bookstore.books (
                       id SERIAL PRIMARY KEY,
                       name VARCHAR(255) NOT NULL,
                       year INT,
                       url VARCHAR(255)
);

-- Создание таблицы Authors
CREATE TABLE IF NOT EXISTS bookstore.authors (
                         id SERIAL PRIMARY KEY,
                         name VARCHAR(255) NOT NULL
);

-- Создание таблицы Authors_books (связь многие-ко-многим между Authors и Books)
CREATE TABLE IF NOT EXISTS bookstore.authors_books (
                               author_id BIGINT,
                               book_id BIGINT,
                               FOREIGN KEY (author_id) REFERENCES bookstore.authors(id),
                               FOREIGN KEY (book_id) REFERENCES bookstore.books(id),
                               PRIMARY KEY (author_id, book_id)
);

-- Создание таблицы Categories
CREATE TABLE IF NOT EXISTS bookstore.categories (
                            id SERIAL PRIMARY KEY,
                            name VARCHAR(255) NOT NULL
);

-- Создание таблицы Categories_books (связь многие-ко-многим между Categories и Books)
CREATE TABLE IF NOT EXISTS bookstore.categories_books (
                                  category_id BIGINT,
                                  book_id BIGINT,
                                  FOREIGN KEY (category_id) REFERENCES bookstore.categories(id),
                                  FOREIGN KEY (book_id) REFERENCES bookstore.books(id),
                                  PRIMARY KEY (category_id, book_id)
);

-- Создание таблицы Tags
CREATE TABLE IF NOT EXISTS bookstore.tags (
                      id SERIAL PRIMARY KEY,
                      name VARCHAR(255) NOT NULL
);

-- Создание таблицы Tags_books (связь многие-ко-многим между Tags и Books)
CREATE TABLE IF NOT EXISTS bookstore.tags_books (
                            tag_id BIGINT,
                            book_id BIGINT,
                            FOREIGN KEY (tag_id) REFERENCES bookstore.tags(id),
                            FOREIGN KEY (book_id) REFERENCES bookstore.books(id),
                            PRIMARY KEY (tag_id, book_id)
);
