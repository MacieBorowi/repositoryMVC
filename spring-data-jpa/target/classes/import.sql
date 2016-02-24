insert into library (id, library_name) values (1, 'Politechnika Wrocławska');
insert into library (id, library_name) values (2, 'Uniwersytet');

insert into author (id, first_name, last_name) values (1, 'Jan', 'Kowalski');
insert into author (id, first_name, last_name) values (2, 'Zbigniew', 'Nowak');
insert into author (id, first_name, last_name) values (3, 'Janusz', 'Jankowski');
insert into author (id, first_name, last_name) values (4, 'Anna', 'Zwolińska');
insert into author (id, first_name, last_name) values (5, 'Pan', 'Kot');
insert into author (id, first_name, last_name) values (6, 'Maria', 'Antonina');
insert into author (id, first_name, last_name) values (7, 'Adam', 'Konieczny');
insert into author (id, first_name, last_name) values (8, 'Alex', 'Trocki');
insert into author (id, first_name, last_name) values (9, 'Stanisław', 'Lem');

insert into book (id, title, library_id) values (1, 'Pierwsza książka', 1);
insert into book (id, title, library_id) values (2, 'Druga książka', 2);
insert into book (id, title, library_id) values (3, 'Trzecia książka', 1);
insert into book (id, title, library_id) values (4, 'On', 1);
insert into book (id, title, library_id) values (5, 'Pani z jeziora', 1);
insert into book (id, title, library_id) values (6, 'Pies', 1);
insert into book (id, title, library_id) values (7, 'Anastazja', 2);
insert into book (id, title, library_id) values (8, 'Trzcina', 1);
insert into book (id, title, library_id) values (9, 'Rewolucja', 2);
insert into book (id, title, library_id) values (10, 'Rok 1952', 1);

insert into book_author (id_book, id_author) values (1,1);
insert into book_author (id_book, id_author) values (1,2);
insert into book_author (id_book, id_author) values (2,2);
insert into book_author (id_book, id_author) values (3,3);
insert into book_author (id_book, id_author) values (4,4);
insert into book_author (id_book, id_author) values (5,5);
insert into book_author (id_book, id_author) values (6,5);
insert into book_author (id_book, id_author) values (7,6);
insert into book_author (id_book, id_author) values (8,7);
insert into book_author (id_book, id_author) values (9,8);
insert into book_author (id_book, id_author) values (9,7);
insert into book_author (id_book, id_author) values (9,6);
insert into book_author (id_book, id_author) values (9,1);
insert into book_author (id_book, id_author) values (9,2);
insert into book_author (id_book, id_author) values (10,9);
