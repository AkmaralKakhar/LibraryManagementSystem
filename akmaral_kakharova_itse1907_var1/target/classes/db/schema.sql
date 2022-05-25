create table Books(
                       ID SERIAL,
                       name varchar(200),
                       genre varchar(200),
                       publishedYear int,
                       author varchar(200),
                        isbn bigint,
                       primary key(id));


create table Recommendations(
                                id int not null,
                                bookId int not null,
                                comment varchar(500),
                                primary key(id),
                                CONSTRAINT FK_RECOM_BOOK FOREIGN KEY (BOOKID)
                                    REFERENCES Books (ID));
create table Profile(
                        id int not null,
                        fname varchar(50),
                        lname varchar(50),
                        age int,
                        email varchar(100),
                        login varchar(50),
                        password varchar(50),
                        primary key(id));

create table MyList(
                       bookId int not null,
                       profileId int not null,
                       primary key(bookId,profileId),
                       CONSTRAINT FK_MYLIST_BOOK FOREIGN KEY (bookId)
                           REFERENCES Books (ID) ON DELETE CASCADE,
                       CONSTRAINT FR_MYLIST_PROFILE FOREIGN KEY (PROFILEID)
                           REFERENCES Profile (ID));



drop table recommendations cascade

drop table mylist cascade

drop table profile cascade

drop table books cascade
