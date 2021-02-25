-- insert some users --
INSERT INTO USERS (firstname, lastname, email, username, password) VALUES ('thanos', 'user', 'thn@mail.com', 'thn12', 'pass1234');
-- insert some authors --
INSERT INTO AUTHOR (firstname, lastname) VALUES ('Leo', 'Tolstoy');
INSERT INTO AUTHOR (firstname, lastname) VALUES ('John', 'Steinbeck');
INSERT INTO AUTHOR (firstname, lastname) VALUES ('Αλέξανδρος', 'Παπαδιαμάντης');
INSERT INTO AUTHOR (firstname, lastname) VALUES ('Nikos', 'Kazantzakis');
INSERT INTO AUTHOR (firstname, lastname) VALUES ('F. Scott', 'Fitzgerald');
INSERT INTO AUTHOR (firstname, lastname) VALUES ('Arthur Conan', 'Doyle');
-- insert some books --
INSERT INTO BOOK (book_title, publication_year, publication_date, author_id, book_category, book_comments) VALUES ('War and Peace', '2020','2020-01-01', '1', 'LITERARY_REALISM', 'No comments yet..');
INSERT INTO BOOK (book_title, publication_year, publication_date, author_id, book_category, book_comments) VALUES ('The Great Gatsby', '1925','1925-04-10', '5', 'TRAGEDY', 'No comments yet..');
INSERT INTO BOOK (book_title, publication_year, publication_date, author_id, book_category, book_comments) VALUES ('Sherlock Holmes, A Study in Scarlet', '1887','1887-04-10', '6', 'DETECTIVE_MYSTERY', 'No comments yet..');
INSERT INTO BOOK (book_title, publication_year, publication_date, author_id, book_category, book_comments) VALUES ('The Grapes of Wrath', '1939','1939-01-01',  '2', 'DRAMA', 'No comments yet..');
INSERT INTO BOOK (book_title, publication_year, publication_date, author_id, book_category, book_comments) VALUES ('Η Φόνισσα', '1903','1903-01-01',  '3', 'DRAMA', 'No comments yet..');
INSERT INTO BOOK (book_title, publication_year, publication_date, author_id, book_category, book_comments) VALUES ('Report to Greco', '1965','1965-01-01',  '4', 'DRAMA', 'No comments yet..');
INSERT INTO BOOK (book_title, publication_year, publication_date, author_id, book_category, book_comments) VALUES ('The Last Temptation', '1960','1960-01-01',  '4', 'DRAMA', 'No comments yet..');