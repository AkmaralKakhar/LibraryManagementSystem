
insert into books (name, genre, publishedYear,author, isbn)
values ('Robinson Crusoe', 'Classic', 1719,'Daniel Defoe', 45);

insert into books (name, genre, publishedYear,author, isbn)
values ('Emma', 'Drama', 1816,'Jane Austen', 45);

insert into books (name, genre, publishedYear,author, isbn)
values ('Alice in Wonderland', 'Fantasy', 1865,'Lewis Carrol', 45);

insert into books (name, genre, publishedYear,author, isbn)
values('Little Women', 'Detective', 1869,'Louisa May Alcott', 45);


insert into Recommendations(id,bookId, comment)
values(1,1,'By the end of the 19th century, no book in English literary history had enjoyed more editions, spin-offs and translations. Crusoe’s world-famous novel is a complex literary confection, and it’s irresistible.');

insert into Recommendations(id,bookId, comment)
values(2,2,'Jane Austen’s Emma is her masterpiece, mixing the sparkle of her early books with a deep sensibility.');


insert into Recommendations(id,bookId, comment)
values(3,3,'Lewis Carroll’s brilliant nonsense tale is one of the most influential and best loved in the English canon.');


insert into Recommendations(id,bookId,comment)
values(4,4,'Louisa May Alcott’s highly original tale aimed at a young female market has iconic status in America and never been out of print');


insert into profile (id,fname, lname, age, email, login, password)
values (1,'admin', 'admin', 19, 'admin@gmail.com', 'admin', 'root123');

insert into profile (id,fname, lname, age, email, login, password )
values (2,'Akmaral', 'Kakhar', 19, 'a.kakharova@gmail.com', 'akmaral', 'akmaral');

insert into profile (id,fname, lname, age, email, login, password )
values (3,'Nursat', 'Beisenbayev', 20, 'nursat@gmail.com', 'nurs', 'nurs');

insert into profile (id,fname, lname, age, email, login, password )
values (4,'Gulzada', 'Kakhar', 23, 'gulzada@gmail.com', 'gulzada', 'gulzada');



insert into MyList(bookId, profileId)
values( 1, 1);

insert into MyList(bookId, profileId)
values( 2, 2);

insert into MyList(bookId, profileId)
values( 3, 3);

insert into MyList(bookId, profileId)
values( 4, 4);
